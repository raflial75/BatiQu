package com.latihan.capstoneproject.ui.main

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.latihan.capstoneproject.databinding.ActivityDetailBinding
import com.latihan.capstoneproject.response.Batik
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Detail Batik"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val get = intent.getParcelableExtra<Batik>(SET)

        val name = intent.getStringExtra(EXTRA_NAME) ?: ""
        val address = intent.getStringExtra(EXTRA_ADDRESS) ?: ""
        val photo = intent.getStringExtra(EXTRA_PHOTO) ?: ""
        val description = intent.getStringExtra(EXTRA_DESCRIPTION) ?: ""
        Log.d("DetailActivity", "Name: $name, Address: $address, Photo: $photo, Description: $description")

        if (get != null) {
            Log.i("TES", get.toString())
            binding.batikName.text = get.name
            binding.address.text = get.address
            Glide.with(this)
                .load(get.photo)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.Image)
            binding.description.text = get.description

        }

        var _isChecked = false

        CoroutineScope(Dispatchers.IO).launch {
            val count = detailViewModel.favCheck(name, address, photo, description)
            withContext(Dispatchers.Main) {
                if (count != null) {
                    if (count > 0) {
                        binding.btnStar.isChecked = true
                        _isChecked = true
                    } else {
                        binding.btnStar.isChecked = false
                        _isChecked = false
                    }
                }
            }
        }

        binding.btnStar.setOnClickListener {
            _isChecked = !_isChecked
            if (_isChecked) {
                detailViewModel.addToFavorite(name, address, photo, description)
            } else {
                detailViewModel.removeFromFavorite(name, address, photo, description)
            }
            binding.btnStar.isChecked = _isChecked
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val SET = "set"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_ADDRESS = "extra_address"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DESCRIPTION = "extra_description"

    }
}
