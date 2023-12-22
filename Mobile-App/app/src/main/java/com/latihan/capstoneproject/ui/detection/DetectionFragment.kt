package com.latihan.capstoneproject.ui.detection

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.latihan.capstoneproject.databinding.FragmentUploadBinding

class DetectionFragment : Fragment() {

    private var _binding: FragmentUploadBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUploadBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.btnScan.setOnClickListener {
            val intent = Intent(requireContext(), DetectionActivity::class.java)
            startActivity(intent)
        }
        return root
    }

}