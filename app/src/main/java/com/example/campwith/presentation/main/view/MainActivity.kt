package com.example.campwith.presentation.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.campwith.R
import com.example.campwith.databinding.ActivityMainBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.campcar.view.CampCarListFragment
import com.example.campwith.presentation.camp.view.CampFragment
import com.example.campwith.presentation.camp.view.CampListFragment
import com.example.campwith.presentation.camptip.view.CampTipFragment
import com.example.campwith.presentation.main.viewmodel.MainViewModel
import com.example.campwith.presentation.mypage.view.MyPageFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.bottomNavigationMain.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.main_camp -> bottomNavigationReplaceFragment(CampFragment())
                R.id.main_camp_car -> bottomNavigationReplaceFragment(CampCarListFragment())
                R.id.main_camp_tip -> bottomNavigationReplaceFragment(CampTipFragment())
                R.id.main_mypage -> bottomNavigationReplaceFragment(MyPageFragment())
                else -> false
            }
        }
        binding.bottomNavigationMain.selectedItemId = R.id.main_camp
    }

    private fun bottomNavigationReplaceFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(binding.frame.id, fragment).commit()
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.frame.id, fragment).commit()
    }

    fun replaceFragmentType(type: String, param: Any) {
        when (type) {
            REGION_CAMP -> replaceFragment(CampListFragment.newInstance(param as String))
            TYPE_CAMP -> replaceFragment(CampListFragment.newInstance(param as Int))
            BOOKMARK_CAMP -> replaceFragment(CampListFragment())
            HOME -> replaceFragment(CampFragment())
            MY_PAGE -> replaceFragment(MyPageFragment())
        }
    }

    companion object {
        const val REGION_CAMP = "REGION"
        const val TYPE_CAMP = "TYPE"
        const val BOOKMARK_CAMP = "BOOKMARK_CAMP"
        const val HOME = "HOME"
        const val MY_PAGE = "MY_PAGE"
    }
}