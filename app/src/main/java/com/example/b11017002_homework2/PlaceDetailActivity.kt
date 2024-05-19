package com.example.b11017002_homework2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.b11017002_homework2.databinding.ActivityPlaceDetailBinding

class PlaceDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaceDetailBinding
    private var place: Place? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        place = intent.getParcelableExtra<Place>("PLACE")
        place?.let {
            binding.placeImage.setImageResource(it.imageResId)
            binding.placeDescription.text = it.description
        }

        // 返回按鈕點擊事件
        binding.backButton.setOnClickListener {
            finish() // 返回到上一個活動
        }

        // 設置按鈕點擊事件打開google 地圖
        binding.openMapButton.setOnClickListener {
            place?.let { openMapActivity(it) }
        }
    }

    private fun openMapActivity(place: Place) {
        val uri = Uri.parse("geo:${place.latitude},${place.longitude}?q=${place.latitude},${place.longitude}(${Uri.encode(place.name)})")
        val intent = Intent(Intent.ACTION_VIEW, uri).apply {
            setPackage("com.google.android.apps.maps")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Google Maps app not installed", Toast.LENGTH_SHORT).show()
        }
    }
}
