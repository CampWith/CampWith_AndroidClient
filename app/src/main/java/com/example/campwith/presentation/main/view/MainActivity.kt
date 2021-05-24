package com.example.campwith.presentation.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.campwith.R
import com.example.campwith.databinding.ActivityMainBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.campcarlist.view.CampCarListFragment
import com.example.campwith.presentation.camplist.view.CampFragment
import com.example.campwith.presentation.camplist.view.CampListFragment
import com.example.campwith.presentation.camptip.view.CampTipFragment
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
                R.id.main_camp_tip -> bottomNavigationReplaceFragment(CampTipFragment())
                else -> false
            }
        }
        bottom_navigation_main.selectedItemId = R.id.main_camp
    }

    private fun bottomNavigationReplaceFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(binding.frame.id, fragment).commit()
        return true
    }

    fun replaceFragment(region: String?, type: Int?) {
        if (region != null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.frame.id, CampListFragment.newInstance(region)).commit()
        } else if (type != null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.frame.id, CampListFragment.newInstance(type)).commit()
        } else {
            supportFragmentManager.beginTransaction().replace(binding.frame.id, CampFragment())
                .commit()
        }

    }
}