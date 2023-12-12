package com.latihan.capstoneproject.ui.register

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.latihan.capstoneproject.R
import com.latihan.capstoneproject.databinding.ActivityRegisterBinding
import com.latihan.capstoneproject.data.isValidEmail
import com.latihan.capstoneproject.data.validateMinLegth
import com.latihan.capstoneproject.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        registerViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[RegisterViewModel::class.java]

        registerViewModel.getRegister().observe(this) {
            if (it == null) {
                showLoading(true)
            }
            else {
                Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                showLoading(false)
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }
        setUpAction()
        playAnimation()
        buttonEnable()
        passwordEditText()
    }

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imageLogo, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val btnbacktologin = ObjectAnimator.ofFloat(binding.btnBackToLogin, View.ALPHA, 1f).setDuration(500)
        val imagelogo = ObjectAnimator.ofFloat(binding.imageLogo, View.ALPHA, 1f).setDuration(500)
        val tvReg = ObjectAnimator.ofFloat(binding.tvReg, View.ALPHA, 1f).setDuration(500)
        val edtEmail = ObjectAnimator.ofFloat(binding.edtEmail, View.ALPHA, 1f).setDuration(500)
        val edtUsername = ObjectAnimator.ofFloat(binding.edtUsername, View.ALPHA, 1f).setDuration(500)
        val edtPassword = ObjectAnimator.ofFloat(binding.edtPassword, View.ALPHA, 1f).setDuration(500)
        val btnCreateAcc = ObjectAnimator.ofFloat(binding.btnCreateAcc, View.ALPHA, 1f).setDuration(500)
        val together = AnimatorSet().apply {
            playTogether(edtEmail, edtUsername, edtPassword)
        }

        AnimatorSet().apply {
            playSequentially(btnbacktologin, imagelogo, tvReg, btnCreateAcc, together)
            startDelay = 500
        }.start()
    }

    private fun setUpAction() {
        val name = binding.edtUsername.text
        val email = binding.edtEmail.text
        val password = binding.edtPassword.text

        binding.btnCreateAcc.setOnClickListener {
            when {
                name.isEmpty() -> {
                    Toast.makeText(this, getString(R.string.message_username), Toast.LENGTH_SHORT).show()
                }
                email?.isEmpty()!! -> {
                    Toast.makeText(this, getString(R.string.message_email), Toast.LENGTH_SHORT).show()
                }
                password?.isEmpty()!! -> {
                    Toast.makeText(this, getString(R.string.message_password), Toast.LENGTH_SHORT).show()
                }
                else -> {
                    setUpRegister()
                    showLoading(true)
                }
            }
        }
        binding.btnBackToLogin.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
    private fun buttonEnable() {
        val emailEditText = binding.edtEmail.text
        val passwordEditText = binding.edtPassword.text
        binding.btnCreateAcc.isEnabled =
            isValidEmail(emailEditText.toString()) && validateMinLegth(passwordEditText.toString())
    }
    private fun setUpRegister() {
        binding.apply {
            val name = edtUsername.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            registerViewModel.register(name, email, password)
        }
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
}