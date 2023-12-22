package com.latihan.capstoneproject.ui.main

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.latihan.capstoneproject.R
import com.latihan.capstoneproject.databinding.ActivityDetailBinding
import com.latihan.capstoneproject.response.ItemsItem
import com.latihan.capstoneproject.response.ResponseSearchDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel by viewModels<DetailViewModel>()

    //private val detailViewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Detail Batik"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val get = intent.getParcelableExtra<ItemsItem>(SET)

        val name = intent.getStringExtra(EXTRA_NAME) ?: ""
        val address = intent.getStringExtra(EXTRA_ADDRESS) ?: ""
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION) ?: ""
        Log.d("DetailActivity", "Name: $name, Address: $address, Photo: $photo, Description: $description")

        detailViewModel.getName(name)
        detailViewModel.userDetail.observe(this) { user ->
            setUserData(user)
        }
//        detailViewModel.isLoading.observe(this) {
//            showLoading(it)
//        }

        var _isChecked = false

        CoroutineScope(Dispatchers.IO).launch {
            val count = detailViewModel.checkUser(name, address, photo, description)
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
                binding.btnStar.setBackgroundResource(R.drawable.ic_star_rate)
            } else {
                detailViewModel.removeFromFavorite(name, address, photo, description)
                binding.btnStar.setBackgroundResource(R.drawable.ic_star)
            }
            binding.btnStar.isChecked = _isChecked
        }
        if (get != null) {
            Log.i("TES", get.toString())
            binding.batikName.text = get.name
            binding.address.text = get.address
            binding.description.text = get.description
            Glide.with(this)
                .load(get.photo)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.Image)


        }


    }

    private fun setUserData(user: ResponseSearchDetail) {
        binding.apply {
            batikName.text = user.name
            address.text = user.address
            description.text = user.description
        }
        Glide.with(this)
            .load(user.photo)
            .circleCrop()
            .into(binding.Image)

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
