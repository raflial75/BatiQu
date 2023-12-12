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
import com.latihan.capstoneproject.response.Batik
import com.latihan.capstoneproject.ui.main.DetailActivity

class ListBatikAdapter(private val listBatik: ArrayList<Batik>) : RecyclerView.Adapter<ListBatikAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
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

    override fun getItemCount(): Int = listBatik.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.rvStory)
        val tvName: TextView = itemView.findViewById(R.id.nama)
        val tvAddress: TextView = itemView.findViewById(R.id.alamat)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Batik)
    }
}