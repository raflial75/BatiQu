package com.latihan.capstoneproject.ui.profile

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.content.Intent
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.latihan.capstoneproject.databinding.FragmentProfileBinding
import com.latihan.capstoneproject.ui.login.LoginActivity

=======
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.latihan.capstoneproject.databinding.FragmentProfileBinding
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private lateinit var firebaseAuth: FirebaseAuth
=======

    // This property is only valid between onCreateView and
    // onDestroyView.
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======

    // This property is only valid between onCreateView and
    // onDestroyView.
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======

    // This property is only valid between onCreateView and
    // onDestroyView.
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======

    // This property is only valid between onCreateView and
    // onDestroyView.
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======

    // This property is only valid between onCreateView and
    // onDestroyView.
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
        val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.dProfil
        binding.tvProfile
        binding.btnLogout
        binding.tvEmail
        binding.icBackground
        binding.imageLogo
        binding.tvUsername
        binding.tvWelcome
        //val textView: TextView = binding.textNotifications
        profileViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
}