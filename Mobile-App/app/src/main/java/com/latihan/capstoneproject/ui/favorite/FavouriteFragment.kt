package com.latihan.capstoneproject.ui.favorite


import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.latihan.capstoneproject.data.adapter.ListAdapter
import com.latihan.capstoneproject.database.FavouriteEntity
import com.latihan.capstoneproject.databinding.FragmentFavoriteBinding
import com.latihan.capstoneproject.response.ItemsItem
import com.latihan.capstoneproject.ui.main.DetailActivity

class FavouriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var listAdapter: ListAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        favoriteViewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]

        favoriteViewModel.userList.observe(viewLifecycleOwner) { users ->
            setUser(users)
        }

        listAdapter = ListAdapter(ArrayList())
        listAdapter.notifyDataSetChanged()

        if (requireContext().resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding?.rvFav?.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            binding?.rvFav?.layoutManager = LinearLayoutManager(requireContext())
        }

        binding?.rvFav?.adapter = listAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        favoriteViewModel.getFavoriteUser()?.observe(this) { users ->
            if (users != null) {
                val list = mapList(users)
                Log.d("FavoriteActivity", "Favorite Users: $list")
                listAdapter.setList(list)
                listAdapter.notifyDataSetChanged()
                if (list.isEmpty()) {
                    binding?.emptyTextView?.visibility = View.VISIBLE
                    binding?.rvFav?.visibility = View.GONE
                } else {
                    binding?.emptyTextView?.visibility = View.GONE
                    binding?.rvFav?.visibility = View.VISIBLE
                }
            }
        }
    }
    private fun setUser(users: List<ItemsItem>?) {

        listAdapter = ListAdapter(users as ArrayList<ItemsItem>)
        binding?.rvFav?.adapter = listAdapter
        Log.d("TESTING-SetUser", "$users")

        listAdapter.setOnItemClickListener (object : ListAdapter.OnItemClickListener {
            override fun onItemSelect(data: ItemsItem) {
                Log.d("TESTING-OnClicked", "$data")
                showSelected(data)
            }
        })
    }
    private fun showSelected(user: ItemsItem) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_NAME, user.name)
        intent.putExtra(DetailActivity.EXTRA_ADDRESS, user.address)
        intent.putExtra(DetailActivity.EXTRA_PHOTO, user.photo)
        intent.putExtra(DetailActivity.EXTRA_DESCRIPTION, user.description)
        startActivity(intent)
    }
    private fun mapList(users: List<FavouriteEntity>): ArrayList<ItemsItem> {
        val listUsers = ArrayList<ItemsItem>()
        for (user in users){
            val userMapped = ItemsItem(
                user.name,
                user.address,
                user.photo,
                user.description
            )
            listUsers.add(userMapped)
        }
        Log.d("FavoriteActivity", "List Mapped: $listUsers")
        return listUsers
    }
    @Deprecated("Deprecated in Java")
    @Suppress("DEPRECATION")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}