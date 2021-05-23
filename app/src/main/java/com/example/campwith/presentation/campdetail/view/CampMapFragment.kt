package com.example.campwith.presentation.campdetail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.UiThread
import com.example.campwith.R
import com.example.campwith.data.camp.response.CampDetailResponse
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage

private const val ARG_PARAM = "campItem"

class CampMapFragment : Fragment(), OnMapReadyCallback {
    private var campItem: CampDetailResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fm = childFragmentManager
        val mapFragment = fm.findFragmentById(R.id.fragment_map) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.fragment_map, it).commit()
            }
        mapFragment.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            campItem = it.getParcelable(ARG_PARAM)
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camp_map, container, false)
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