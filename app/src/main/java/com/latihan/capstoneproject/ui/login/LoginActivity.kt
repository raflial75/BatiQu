package com.latihan.capstoneproject.ui.login

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.content.Context
import android.content.Intent
import android.os.Bundle
=======
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.google.firebase.auth.FirebaseAuth
import com.latihan.capstoneproject.databinding.ActivityLoginBinding
=======
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
import androidx.lifecycle.ViewModelProvider
import com.latihan.capstoneproject.R
import com.latihan.capstoneproject.ViewModelFactory
import com.latihan.capstoneproject.data.pref.UserPreference
import com.latihan.capstoneproject.databinding.ActivityLoginBinding
import com.latihan.capstoneproject.data.isValidEmail
import com.latihan.capstoneproject.data.validateMinLegth
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
import com.latihan.capstoneproject.ui.main.MainActivity
import com.latihan.capstoneproject.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    private lateinit var binding: ActivityLoginBinding
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    //private lateinit var loginViewModel: LoginViewModel
    private lateinit var firebaseAuth: FirebaseAuth
=======
    private lateinit var loginViewModel: LoginViewModel
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
    private lateinit var loginViewModel: LoginViewModel
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
    private lateinit var loginViewModel: LoginViewModel
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
    private lateinit var loginViewModel: LoginViewModel
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
    private lateinit var loginViewModel: LoginViewModel
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        firebaseAuth = FirebaseAuth.getInstance()

        val btnLogin = binding.btnLogin
        val tvRegister = binding.btnCreateAcc

        btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_CLEAR_TOP   //need rework if it make the app crash
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty fields is not allowed", Toast.LENGTH_SHORT)
                    .show()
            }
        }


        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

//        if (firebaseAuth.currentUser != null) {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
        //playAnimation()
        //setUpAction()
        //buttonEnable()
       //passwordEditText()
    }

//    private fun setUpAction() {
//        val email = binding.edtEmail.text
//        val password = binding.edtPassword.text
//        binding.btnLogin.setOnClickListener {
//            when {
//                email?.isEmpty()!! -> {
//                    Toast.makeText(this, getString(R.string.message_email), Toast.LENGTH_SHORT).show()
//                }
//                password?.isEmpty()!! -> {
//                    Toast.makeText(this, getString(R.string.message_password), Toast.LENGTH_SHORT).show()
//                }
//                else -> {
//                    setUpLogin()
//                    showLoading(true)
//                }
//            }
//        }
//
//        binding.btnCreateAcc.setOnClickListener {
//            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
//            startActivity(intent)
//        }
//    }
//
//    private fun setUpLogin() {
//        binding.apply {
//            val email = edtEmail.text.toString()
//            val password = edtPassword.text.toString()
//            loginViewModel.login(email, password)
//        }
//    }
//    private fun buttonEnable() {
//        val emailEditText = binding.edtEmail.text
//        val passwordEditText = binding.edtPassword.text
//        binding.btnLogin.isEnabled =
//            isValidEmail(emailEditText.toString()) && validateMinLegth(passwordEditText.toString())
//    }
//    private fun playAnimation() {
//        ObjectAnimator.ofFloat(binding.imageLogo, View.TRANSLATION_X, -30f, 30f).apply {
//            duration = 6000
//            repeatCount = ObjectAnimator.INFINITE
//            repeatMode = ObjectAnimator.REVERSE
//        }.start()
//
//        val imagelogo = ObjectAnimator.ofFloat(binding.imageLogo, View.ALPHA, 1f).setDuration(500)
//        val tvLogin = ObjectAnimator.ofFloat(binding.tvLogin, View.ALPHA, 1f).setDuration(500)
//        val edtEmail = ObjectAnimator.ofFloat(binding.edtEmail, View.ALPHA, 1f).setDuration(500)
//        val edtPassword = ObjectAnimator.ofFloat(binding.edtPassword, View.ALPHA, 1f).setDuration(500)
//        val btnLogin = ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(500)
//        val tvOr = ObjectAnimator.ofFloat(binding.tvOr, View.ALPHA, 1f).setDuration(500)
//        val btnCreateAcc = ObjectAnimator.ofFloat(binding.btnCreateAcc, View.ALPHA, 1f).setDuration(500)
//
//        val together = AnimatorSet().apply {
//            playTogether(edtEmail, edtPassword)
//        }
//
//        AnimatorSet().apply {
//            playSequentially(imagelogo, tvLogin, btnLogin, tvOr, btnCreateAcc, together)
//            startDelay = 500
//        }.start()
//    }

//    private fun showLoading(loading: Boolean) { binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE }
//
//    private fun passwordEditText() {
//        binding.edtPassword.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                buttonEnable()
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//            }
//        })
//    }
=======
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
=======
>>>>>>> ed29daf81a0782be93901d89e1788c206dc19460
        loginViewModel = ViewModelProvider(this, ViewModelFactory(UserPreference.getInstance(dataStore)))[LoginViewModel::class.java]

        playAnimation()
        setUpAction()
        buttonEnable()
        passwordEditText()

        loginViewModel.getLogin().observe(this) {
            if (it.error) {
                showLoading(false)
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
            else{
                showLoading(true)
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }
    }

    private fun setUpAction() {
        val email = binding.edtEmail.text
        val password = binding.edtPassword.text
        binding.btnLogin.setOnClickListener {
            when {
                email?.isEmpty()!! -> {
                    Toast.makeText(this, getString(R.string.message_email), Toast.LENGTH_SHORT).show()
                }
                password?.isEmpty()!! -> {
                    Toast.makeText(this, getString(R.string.message_password), Toast.LENGTH_SHORT).show()
                }
                else -> {
                    setUpLogin()
                    showLoading(true)
                }
            }
        }

        binding.btnCreateAcc.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    private fun setUpLogin() {
        binding.apply {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            loginViewModel.login(email, password)
        }
    }
    private fun buttonEnable() {
        val emailEditText = binding.edtEmail.text
        val passwordEditText = binding.edtPassword.text
        binding.btnLogin.isEnabled =
            isValidEmail(emailEditText.toString()) && validateMinLegth(passwordEditText.toString())
    }
    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imageLogo, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val imagelogo = ObjectAnimator.ofFloat(binding.imageLogo, View.ALPHA, 1f).setDuration(500)
        val tvLogin = ObjectAnimator.ofFloat(binding.tvLogin, View.ALPHA, 1f).setDuration(500)
        val edtEmail = ObjectAnimator.ofFloat(binding.edtEmail, View.ALPHA, 1f).setDuration(500)
        val edtPassword = ObjectAnimator.ofFloat(binding.edtPassword, View.ALPHA, 1f).setDuration(500)
        val btnLogin = ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(500)
        val tvOr = ObjectAnimator.ofFloat(binding.tvOr, View.ALPHA, 1f).setDuration(500)
        val btnCreateAcc = ObjectAnimator.ofFloat(binding.btnCreateAcc, View.ALPHA, 1f).setDuration(500)

        val together = AnimatorSet().apply {
            playTogether(edtEmail, edtPassword)
        }

        AnimatorSet().apply {
            playSequentially(imagelogo, tvLogin, btnLogin, tvOr, btnCreateAcc, together)
            startDelay = 500
        }.start()
    }

    private fun showLoading(loading: Boolean) { binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE }

    private fun passwordEditText() {
        binding.edtPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                buttonEnable()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
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