package com.example.campwith.presentation.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.campwith.R
import com.example.campwith.databinding.ActivityMainBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.campcarlist.view.CampCarListFragment
import com.example.campwith.presentation.camplist.view.CampFragment
import com.example.campwith.presentation.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation_main.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.main_camp -> bottomNavigationReplaceFragment(CampFragment())
                R.id.main_camp_car -> bottomNavigationReplaceFragment(CampCarListFragment())
                else -> false
            }
        }
        bottom_navigation_main.selectedItemId = R.id.main_camp
    }

    private fun bottomNavigationReplaceFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(binding.frame.id, fragment).commit()
        return true
    }
}