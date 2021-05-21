package com.example.campwith.presentation.main.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.campwith.R
import com.example.campwith.databinding.FragmentCityDialogBinding
import com.example.campwith.presentation.base.BaseDialogFragment
import com.example.campwith.presentation.camplist.view.CampListActivity
import kotlinx.android.synthetic.main.fragment_city_dialog.*

class CityDialogFragment : BaseDialogFragment<FragmentCityDialogBinding>(R.layout.fragment_city_dialog) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_city_dialog, container, false)
        view.findViewById<ImageView>(R.id.btn_cancle).setOnClickListener { dismiss() }
        for(i in 1..8){
            val resName="btn_region"
            val resId = resources.getIdentifier(resName+i,"id", activity?.packageName)
            val btn = view.findViewById<Button>(resId)
            btn.setOnClickListener {
                val intent = Intent(activity, CampListActivity::class.java)
                intent.putExtra("doName", btn.text)
                dismiss()
                startActivity(intent)
            }
        }
        return view
    }
}