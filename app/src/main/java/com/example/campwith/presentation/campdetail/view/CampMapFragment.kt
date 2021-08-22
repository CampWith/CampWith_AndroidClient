package com.example.campwith.presentation.campdetail.view

import android.os.Bundle
import android.view.View
import androidx.annotation.UiThread
import com.example.campwith.R
import com.example.campwith.data.camp.response.CampDetailResponse
import com.example.campwith.data.camp.response.CampResponseItem
import com.example.campwith.databinding.FragmentCampMapBinding
import com.example.campwith.presentation.base.BaseFragment
import com.example.campwith.presentation.campdetail.viewmodel.CampMapViewModel
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ARG_PARAM = "campItem"

class CampMapFragment :
    BaseFragment<FragmentCampMapBinding, CampMapViewModel>(R.layout.fragment_camp_map),
    OnMapReadyCallback {
    override val viewModel: CampMapViewModel by viewModel()
    private var campItem: CampResponseItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fm = childFragmentManager
        val mapFragment = fm.findFragmentById(R.id.fragment_map) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.fragment_map, it).commit()
            }
        mapFragment.getMapAsync(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            campItem = it.getParcelable(ARG_PARAM)
        }

        binding.itemCamp = campItem
    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        val cameraPosition = CameraPosition(LatLng(campItem!!.mapY, campItem!!.mapX), 20.0)
        naverMap.cameraPosition = cameraPosition
        val marker = Marker()
        marker.icon = OverlayImage.fromResource(R.drawable.ic_round_place_24)
        marker.position = LatLng(campItem!!.mapY, campItem!!.mapX)
        marker.map = naverMap

    }
}