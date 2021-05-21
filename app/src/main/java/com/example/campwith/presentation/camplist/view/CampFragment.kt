package com.example.campwith.presentation.camplist.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenResumed
import androidx.viewpager2.widget.ViewPager2
import com.example.campwith.R
import com.example.campwith.data.camp.model.BannerItem
import com.example.campwith.databinding.FragmentCampBinding
import com.example.campwith.presentation.base.BaseFragment
import com.example.campwith.presentation.camplist.adapter.ViewPagerAdapter
import com.example.campwith.presentation.camplist.viewmodel.CampViewModel
import com.example.campwith.presentation.main.view.CityDialogFragment
import kotlinx.android.synthetic.main.fragment_camp.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CampFragment : BaseFragment<FragmentCampBinding, CampViewModel>(R.layout.fragment_camp),
    Interaction {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private var isRunning = true

    override val viewModel: CampViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setBannerItems(
            listOf(
                BannerItem(R.drawable.banner1),
                BannerItem(R.drawable.banner2)
            )
        )

        binding.llContainer.setOnClickListener {
            val cityDialogFragment = CityDialogFragment()
            cityDialogFragment.setStyle(
                DialogFragment.STYLE_NO_TITLE,
                android.R.style.Theme_Holo_Light
            );
            activity?.let { it1 -> cityDialogFragment.show(it1.supportFragmentManager, "dialog") }
        }
        initViewPager2()
        subscribeObservers()
        autoScrollViewPager()
    }

    private fun initViewPager2() {
        vp_banner.apply {
            viewPagerAdapter = ViewPagerAdapter(this@CampFragment)
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    isRunning = true
                    tv_page_number.text = "${position + 1}"

                    //직접 유저가 스크롤했을 떄!
                    viewModel.setCurrentPosition(position)
                }
            })
        }
    }

    private fun subscribeObservers() {
        viewModel.bannerItemList.observe(this, Observer { bannerItemList ->
            viewPagerAdapter.submitList(bannerItemList)
        })
        viewModel.currentPosition.observe(this, Observer { currentPosition ->
            vp_banner.currentItem = currentPosition
        })
    }

    private fun autoScrollViewPager() {
        lifecycleScope.launch {
            whenResumed {
                while (isRunning) {
                    delay(3000)
                    viewModel.getcurrentPosition()?.let {
                        viewModel.setCurrentPosition((it.plus(1)) % 5)
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        isRunning = false
    }

    override fun onResume() {
        super.onResume()
        isRunning = true
    }

    override fun onBannerItemClicked(bannerItem: BannerItem) {
        //startActivity
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}