package com.latihan.capstoneproject.ui.favorite

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.latihan.capstoneproject.data.adapter.ListBatikAdapter
import com.latihan.capstoneproject.database.FavoriteEntity
import com.latihan.capstoneproject.databinding.FragmentFavoriteBinding
import com.latihan.capstoneproject.response.Batik
import com.latihan.capstoneproject.ui.main.DetailActivity

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var listBatikAdapter: ListBatikAdapter

    private val binding get() = _binding!!

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val root: View = binding.root


        favoriteViewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]
        favoriteViewModel.batikList.observe(viewLifecycleOwner) { batik ->
            setBatik(batik)
        }

        listBatikAdapter = ListBatikAdapter(ArrayList())
        listBatikAdapter.notifyDataSetChanged()

        if (requireContext().resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvFav.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            binding.rvFav.layoutManager = LinearLayoutManager(requireContext())
        }

        binding.rvFav.adapter = listBatikAdapter

        return root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        favoriteViewModel.getFavoriteUser()?.observe(this) { users ->
            if (users != null) {
                val list = mapList(users)
                Log.d("FavoriteActivity", "Favorite Users: $list")
                listBatikAdapter.setList(list)
                listBatikAdapter.notifyDataSetChanged()
                if (list.isEmpty()) {
                    binding.emptyTextView.visibility = View.VISIBLE
                    binding.rvFav.visibility = View.GONE
                } else {
                    binding.emptyTextView.visibility = View.GONE
                    binding.rvFav.visibility = View.VISIBLE
                }
            }
        }
    }
    private fun setBatik(batik: List<Batik>?) {

        listBatikAdapter = ListBatikAdapter(batik as ArrayList<Batik>)
        binding.rvFav.adapter = listBatikAdapter
        Log.d("TESTING-SetUser", "$batik")

        listBatikAdapter.setOnItemClickListener (object : ListBatikAdapter.OnItemClickListener {
            override fun onItemSelect(data: Batik) {
                showSelected(data)
            }
        })
    }
    private fun showSelected(batik: Batik) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.SET, batik.name)
        intent.putExtra(DetailActivity.SET, batik.address)
        intent.putExtra(DetailActivity.SET, batik.photo)
        intent.putExtra(DetailActivity.SET, batik.description)
        startActivity(intent)
    }
    private fun mapList(batik: List<FavoriteEntity>): ArrayList<Batik> {
        val listBatik = ArrayList<Batik>()
        for (set in batik){
            val batikMapped = Batik(
                set.name,
                set.address,
                set.photo,
                set.description
            )
            listBatik.add(batikMapped)
        }
        Log.d("FavoriteActivity", "List Mapped: $listBatik")
        return listBatik
    }
}