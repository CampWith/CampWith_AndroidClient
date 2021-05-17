package com.example.campwith.presentation.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.campwith.R
import com.example.campwith.presentation.campcarlist.view.CampCarListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ll_container.setOnClickListener {
            val cityDialogFragment = CityDialogFragment()
            cityDialogFragment.show(supportFragmentManager, "dialog")
        }
        btn_campingcar.setOnClickListener {
            val intent = Intent(this, CampCarListActivity::class.java)
            startActivity(intent)
        }
    }
}