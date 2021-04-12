package com.example.campwith.presentation.campdetail.view

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.annotation.UiThread
import androidx.fragment.app.Fragment
import com.example.campwith.R
import com.example.campwith.data.Item
import com.example.campwith.databinding.ActivityCampDetailBinding
import com.example.campwith.presentation.base.BaseActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import kotlinx.android.synthetic.main.activity_camp_detail.*

class CampDetailActivity : BaseActivity<ActivityCampDetailBinding>(R.layout.activity_camp_detail){

    lateinit var campItem: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        campItem = intent.getParcelableExtra("campitem")!!
        binding.itemCamp = campItem

        val campReviewFragment = CampReviewFragment.newInstance("","")
        val campMapFragment = CampMapFragment.newInstance(campItem)
        supportFragmentManager.beginTransaction().add(R.id.fl_container, campReviewFragment).commit();

        tl_tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            lateinit var selectedFragment: Fragment
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position){
                    0 -> selectedFragment = campReviewFragment
                    1 -> selectedFragment = campMapFragment
                }
                supportFragmentManager.beginTransaction().replace(R.id.fl_container, selectedFragment).commit()
            }
        })
    }
}