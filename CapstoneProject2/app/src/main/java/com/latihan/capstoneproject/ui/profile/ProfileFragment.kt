package com.latihan.capstoneproject.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.latihan.capstoneproject.databinding.FragmentProfileBinding
import com.latihan.capstoneproject.ui.login.LoginActivity


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private lateinit var firebaseAuth: FirebaseAuth
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        firebaseAuth = FirebaseAuth.getInstance()
        val user = firebaseAuth.currentUser

        if (user != null){
            val displayName = user.displayName
            if (displayName != null && displayName.isNotEmpty()) {
                binding.tvUsername.text = displayName
            } else {
                // If display name is null or empty, you may want to set a default value
                binding.tvUsername.text = "DefaultUsername"
            }
            binding.tvEmail.text = user.email
        }

        if (firebaseAuth.currentUser != null){
            firebaseAuth.currentUser?.let {
                binding.tvEmail.text = it.email
            }
        }

        binding.btnLogout.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(
                Intent(requireContext(),LoginActivity::class.java)
            )
        }

        return root
    }
}