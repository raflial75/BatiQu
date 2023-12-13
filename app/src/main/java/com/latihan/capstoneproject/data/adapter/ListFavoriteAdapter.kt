package com.latihan.capstoneproject.data.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.latihan.capstoneproject.R
import com.latihan.capstoneproject.data.pref.UserPreference
import com.latihan.capstoneproject.response.Batik
import com.latihan.capstoneproject.ui.main.DetailActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ListFavoriteAdapter(private val listBatik: ArrayList<Batik>, private val pref: UserPreference) : RecyclerView.Adapter<ListFavoriteAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        fetchDataFromApi()
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, address, photo) = listBatik[position]
        holder.tvName.text = name
        holder.tvAddress.text = address
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener {
            val intentDetailBatik = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetailBatik.putExtra(DetailActivity.SET, listBatik[position])
            holder.itemView.context.startActivity(intentDetailBatik)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Batik)
    }

    override fun getItemCount(): Int = listBatik.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.rvStory)
        val tvName: TextView = itemView.findViewById(R.id.nama)
        val tvAddress: TextView = itemView.findViewById(R.id.alamat)
    }

    private fun fetchDataFromApi() {
        println("Fetching Articles ..")
        val url = URL("https://backend.batikin.site/api/articles/bookmark")
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        val token = pref.getUserToken() ?: ""
        val tokenHeader = "Bearer $token"
        connection.setRequestProperty("Authorization", tokenHeader)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val responseCode = connection.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val reader = BufferedReader(InputStreamReader(connection.inputStream))
                    val response = StringBuilder()
                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        response.append(line)
                    }
                    reader.close()

                    val jsonObject = JSONObject(response.toString())
                    val dataArray: JSONArray = jsonObject.getJSONArray("data")
                    try {

                        val dataList = ArrayList<Batik>()
                        for (i in 0 until dataArray.length()) {
                            val dataObject = dataArray.getJSONObject(i)
                            val name = dataObject.getString("name")
                            val address = dataObject.getString("address")
                            val description = dataObject.getString("description")
                            val image = dataObject.getString("image")

                            val data = Batik(name, address, description, image)
                            dataList.add(data)
                        }

                        withContext(Dispatchers.Main) {
                            listBatik.clear()
                            listBatik.addAll(dataList)
                            notifyDataSetChanged()
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()

            } finally {
                connection.disconnect()
            }
        }
    }

}