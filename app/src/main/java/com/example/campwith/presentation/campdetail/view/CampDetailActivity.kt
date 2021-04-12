package com.example.campwith.presentation.campdetail.view

import android.os.Bundle
import androidx.annotation.UiThread
import com.example.campwith.R
import com.example.campwith.data.Item
import com.example.campwith.databinding.ActivityCampDetailBinding
import com.example.campwith.presentation.base.BaseActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage

class CampDetailActivity : BaseActivity<ActivityCampDetailBinding>(R.layout.activity_camp_detail),
    OnMapReadyCallback {

    lateinit var campItem: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        campItem = intent.getParcelableExtra("campitem")!!
        binding.itemCamp = campItem
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.fragment_map) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.fragment_map, it).commit()
            }
        mapFragment.getMapAsync(this)
    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        val cameraPosition = CameraPosition(LatLng(campItem.mapY, campItem.mapX), 27.0)
        naverMap.cameraPosition = cameraPosition
        val marker = Marker()
        marker.icon = OverlayImage.fromResource(R.drawable.ic_baseline_place_24)
        marker.position = LatLng(campItem.mapY, campItem.mapX)
        marker.map = naverMap
    }
}