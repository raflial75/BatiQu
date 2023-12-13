package com.latihan.capstoneproject.ui.main

import android.os.Bundle
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.google.android.material.bottomnavigation.BottomNavigationView
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
import com.google.android.material.bottomnavigation.BottomNavigationView
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
import com.google.android.material.bottomnavigation.BottomNavigationView
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
import com.google.android.material.bottomnavigation.BottomNavigationView
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
import com.google.android.material.bottomnavigation.BottomNavigationView
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.google.android.material.bottomnavigation.BottomNavigationView
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
import com.latihan.capstoneproject.R
import com.latihan.capstoneproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
//    private lateinit var pref: UserPreference
//    private lateinit var mainViewModel: MainViewModel
//    private lateinit var adapter: ListBatikAdapter
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navView: BottomNavigationView = binding.navView

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        val navController = findNavController(R.id.nav_host)
=======
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_favorite, R.id.navigation_upload, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

//        mainViewModel.getUser().observe(this) { user ->
//
//            if (user.token.isNotEmpty()) {
//
//                binding.rvStory.adapter = adapter
//                Log.d("result main :", user.token)
//            } else {
//                startActivity(Intent(this, LoginActivity::class.java))
//                finish()
//            }
//        }
//        binding.apply {
//            rvStory.layoutManager = LinearLayoutManager(this@MainActivity)
//            rvStory.setHasFixedSize(true)
//            rvStory.adapter = adapter
//        }
//        loginCheck()
    }

//    private fun loginCheck() {
//        lifecycleScope.launch {
//            val user = pref.getUser().first() // Using first() to get the latest UserState
//
//            if (user.token.isNotEmpty()) {
//                // The user is logged in, you can proceed to the main part of the app
//                // For example, starting a HomeFragment or MainActivity
//                val intent = Intent(this@MainActivity, HomeFragment::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                // The user is not logged in, redirect to the login screen
//                val intent = Intent(this@MainActivity, LoginActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//        }
//    }
=======
    }
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
    }
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
    }
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
    }
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
    }
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
}