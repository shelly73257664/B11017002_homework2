// MainActivity.kt
package com.example.b11017002_homework2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.b11017002_homework2.PlaceAdapter
import com.example.b11017002_homework2.PlaceDetailActivity
import com.example.b11017002_homework2.R
import com.example.b11017002_homework2.Place
import com.example.b11017002_homework2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val places = listOf(
            Place("美國", R.drawable.image_1, "自由女神像（Statue of Liberty）", "Details",40.6892,-74.0445),
            Place("法國", R.drawable.image_2, "埃菲爾鐵塔（Eiffel Tower）", "Details", 48.8584, 2.2945),
            Place("英國", R.drawable.image_3, "大笨鐘（Big Ben）", "Details", 51.5007, -0.1246),
            Place("中國", R.drawable.image_4, "萬里長城（Great Wall）", "Details", 40.4319, 116.5704),
            Place("俄羅斯", R.drawable.image_5, "莫斯科紅場（Red Square in Moscow）", "Details", 55.7539, 37.6208),
            Place("義大利", R.drawable.image_6, "比薩斜塔（Leaning Tower of Pisa）", "Details", 43.7229, 10.3966),
            Place("印度", R.drawable.image_7, "泰姬陵（Taj Mahal）", "Details", 27.1751, 78.0421),
            Place("荷蘭", R.drawable.image_8, "風車（Windmill）", "Details", 52.6326, 4.7519),
            Place("巴西", R.drawable.image_9, "救世主耶穌基督像（Jesus Christ）", "Details", -22.9519, -43.2105),
            Place("阿聯酋", R.drawable.image_10, "阿拉伯塔飯店（Burj Al Arab）", "Details", 25.1412, 55.1853)
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = PlaceAdapter(places) { place ->
            val intent = Intent(this, PlaceDetailActivity::class.java)
            intent.putExtra("PLACE", place)
            startActivity(intent)
        }
    }

    fun viewPlaceDetails(view:View){
        //處理按下“View Place Detils ”按鈕的事件
        val intent=Intent(this, PlaceDetailActivity::class.java)
        val position = binding.recyclerView.getChildAdapterPosition(view)
        //val place = (binding.recyclerView.adapter as PlaceAdapter).places[position]
        val place = (binding.recyclerView.adapter as? PlaceAdapter)?.places?.get(position)
        intent.putExtra("PLACE", place)
        startActivity(intent)
    }
}
