package com.latihan.capstoneproject.ui

import android.annotation.SuppressLint
import android.content.Intent
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.latihan.capstoneproject.R
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
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.latihan.capstoneproject.R
import com.latihan.capstoneproject.ui.main.MainActivity
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

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            startActivity(Intent(this@SplashScreen, LoginActivity::class.java))
=======
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
            finish()
        }, 3000)
    }
}