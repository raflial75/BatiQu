package com.latihan.capstoneproject.ui.main

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.latihan.capstoneproject.databinding.ActivityDetailBinding
import com.latihan.capstoneproject.response.Batik

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val SET = "set"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Detail Batik"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val get = intent.getParcelableExtra<Batik>(SET)

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
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Kembali ke aktivitas sebelumnya
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
