// PlaceDetailActivity.kt
package com.example.b11017002_homework2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.b11017002_homework2.databinding.ActivityPlaceDetailBinding

class PlaceDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaceDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val place = intent.getParcelableExtra<Place>("PLACE")
        place?.let {
            binding.placeImage.setImageResource(it.imageResId)
            binding.placeDescription.text = it.description
        }
        // 返回按鈕點擊事件
        binding.backButton.setOnClickListener {
            finish() // 返回到上一個活動
        }
    }
}
