package com.example.campwith.presentation.campdetail.view

import android.animation.Animator
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.campwith.CampTypeConstant.getTypeName
import com.example.campwith.R
import com.example.campwith.data.camp.response.CampDetailResponse
import com.example.campwith.databinding.ActivityCampDetailBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.campdetail.viewmodel.CampDetailViewModel
import com.google.android.material.tabs.TabLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class CampDetailActivity :
    BaseActivity<ActivityCampDetailBinding, CampDetailViewModel>(R.layout.activity_camp_detail) {
    override val viewModel: CampDetailViewModel by viewModel()
    lateinit var id: String
    lateinit var campItem: CampDetailResponse
    val campReviewFragment = CampReviewFragment()
    val campMapFragment = CampMapFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        id = intent.getStringExtra("id").toString()

        viewModel.getCampDetail(id)
        viewModel.campDetailLiveData.observe(
            this,
            {
                campItem = it
                binding.itemCamp = campItem
                binding.tvCampType.text = getTypeName(campItem.category)
                Glide.with(this)
                    .load(campItem.firstImageUrl)
                    .into(binding.ivCampDetail)
                val bundle = Bundle()
                bundle.putParcelable("campItem", campItem)
                campMapFragment.arguments = bundle
                campReviewFragment.arguments = bundle
                campReviewFragment.addReviews(campItem.reviews)
                campReviewFragment.getData()
            }
        )

        binding.ivBookmark.setOnClickListener {
            binding.ivBookmark.setImageResource(R.drawable.ic_heart_2)
            binding.lottieBookmark.run {
                bringToFront()
                playAnimation()
                addAnimatorListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator?) {}
                    override fun onAnimationEnd(animation: Animator?) {
                        visibility = View.GONE
                    }

                    override fun onAnimationCancel(animation: Animator?) {}
                    override fun onAnimationRepeat(animation: Animator?) {}
                })
            }
        }

        this.runOnUiThread {
            binding.toolbarActivityCampDetail.run {
                setBackBtnVisible(true)
                setCancleBtnVisible(false)
                setLogoVisible(false)
                setBackBtnClick { finish() }
            }
        }

        supportFragmentManager.beginTransaction().add(R.id.container_detail, campReviewFragment)
            .commit()

        binding.containerTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            lateinit var selectedFragment: Fragment
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> selectedFragment = campReviewFragment
                    1 -> selectedFragment = campMapFragment
                }
                supportFragmentManager.beginTransaction().replace(
                    R.id.container_detail,
                    selectedFragment
                ).commit()
            }
        })
    }
}