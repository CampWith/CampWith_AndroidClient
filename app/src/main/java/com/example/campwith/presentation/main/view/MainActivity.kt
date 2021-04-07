package com.example.campwith.presentation.main.view

import android.os.Bundle
import com.example.campwith.R
import com.example.campwith.databinding.ActivityMainBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.main.view.CityDialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        button.setOnClickListener {
            val cityDialogFragment =
                CityDialogFragment()
            cityDialogFragment.show(supportFragmentManager, "dialog")
        }

    }
}