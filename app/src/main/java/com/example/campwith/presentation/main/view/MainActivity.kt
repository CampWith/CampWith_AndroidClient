package com.example.campwith.presentation.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.campwith.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ll_container.setOnClickListener {
            val cityDialogFragment = CityDialogFragment()
            cityDialogFragment.show(supportFragmentManager, "dialog")
        }

    }
}