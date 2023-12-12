package com.latihan.capstoneproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.latihan.capstoneproject.R
import com.latihan.capstoneproject.data.adapter.ListBatikAdapter
import com.latihan.capstoneproject.databinding.FragmentHomeBinding
import com.latihan.capstoneproject.response.Batik

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var rvStory: RecyclerView
    private val list = ArrayList<Batik>()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        rvStory = binding.rvStory
        rvStory.setHasFixedSize(true)

        list.addAll(getListBatik())
        showRecyclerList()
        homeViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
        }
        return root
    }

    private fun getListBatik(): ArrayList<Batik> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataAddress = resources.getStringArray(R.array.data_address)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listBatik = ArrayList<Batik>()
        for (i in dataName.indices) {
            val batik = Batik(dataName[i], dataAddress[i], dataPhoto.getResourceId(i, -1))
            listBatik.add(batik)
        }
        dataPhoto.recycle() // Recycle the TypedArray
        return listBatik
    }

    private fun showRecyclerList() {
        rvStory.layoutManager = LinearLayoutManager(requireContext())
        val listBatikAdapter = ListBatikAdapter(list)
        rvStory.adapter = listBatikAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
