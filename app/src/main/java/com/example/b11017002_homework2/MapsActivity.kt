package com.example.b11017002_homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.b11017002_homework2.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val places = listOf(
            Place("美國", R.drawable.image_1, "自由女神像（Statue of Liberty）", "Details", 40.6892, -74.0445),
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

        for (place in places) {
            val location = LatLng(place.latitude, place.longitude)
            mMap.addMarker(MarkerOptions().position(location).title(place.name))
        }
    }

}