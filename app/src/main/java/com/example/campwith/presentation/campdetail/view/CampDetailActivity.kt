package com.example.campwith.presentation.campdetail.view

import android.animation.Animator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.campwith.CampTypeConstant.getTypeName
import com.example.campwith.R
import com.example.campwith.data.bookmark.request.BookmarkRequest
import com.example.campwith.data.camp.response.CampResponseItem
import com.example.campwith.databinding.ActivityCampDetailBinding
import com.example.campwith.presentation.base.BaseActivity
import com.example.campwith.presentation.campdetail.viewmodel.CampDetailViewModel
import com.example.campwith.presentation.campdetail.viewmodel.CampDetailViewModel.Companion.ADD_BOOKMARK
import com.example.campwith.presentation.campdetail.viewmodel.CampDetailViewModel.Companion.DELETE_BOOKMARK
import com.example.campwith.presentation.binding.setBookmarkImage
import com.google.android.material.tabs.TabLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class CampDetailActivity :
    BaseActivity<ActivityCampDetailBinding, CampDetailViewModel>(R.layout.activity_camp_detail) {
    override val viewModel: CampDetailViewModel by viewModel()
    lateinit var id: String
    lateinit var campItem: CampResponseItem
    var isBookmark: Boolean = false
    val campReviewFragment = CampReviewFragment()
    val campMapFragment = CampMapFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        id = intent.getStringExtra("id").toString()
        viewModel.campDetailLiveData.observe(
            this,
            {
                campItem = it.result.campsite
                isBookmark = it.result.is_favorite
                setBookmarkImage(binding.ivBookmark, isBookmark)
                binding.itemCamp = campItem
                binding.tvCampType.text = getTypeName(campItem.category)
                Glide.with(this)
                    .load(campItem.firstImageUrl)
                    .into(binding.ivCampDetail)
                val bundle = Bundle()
                bundle.putParcelable("campItem", campItem)
                campMapFragment.arguments = bundle
                campReviewFragment.arguments = bundle
                campReviewFragment.addReviews(it.result.reviews)
                campReviewFragment.getData()
            }
        )

        binding.containerCall.setOnClickListener {
            if (campItem.tel.isNotEmpty()) {
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + campItem.tel)))
            } else {
                Toast.makeText(this, "전화번호 준비중입니다.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.containerHome.setOnClickListener {
            Toast.makeText(this, "홈페이지 준비중입니다.", Toast.LENGTH_SHORT).show()
        }

        binding.ivBookmark.setOnClickListener {
            if (isBookmark) {
                viewModel.deleteBookmark(BookmarkRequest(campItem._id))
            } else {
                viewModel.addBookmark(BookmarkRequest(campItem._id))
            }
        }

        viewModel.event.observe(this, {
            it.getContentIfNotHandled()?.let { evnet ->
                when (evnet) {
                    ADD_BOOKMARK -> addBookmarkImg()
                    DELETE_BOOKMARK -> deleteBookmarkImg()
                }
            }
        })

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

    private fun addBookmarkImg() {
        isBookmark = true
        setBookmarkImage(binding.ivBookmark, isBookmark)
        binding.lottieBookmark.run {
            visibility = View.VISIBLE
            bringToFront()
            playAnimation()
            addAnimatorListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {}
                override fun onAnimationEnd(animation: Animator?) {
                    visibility = View.INVISIBLE
                }

                override fun onAnimationCancel(animation: Animator?) {}
                override fun onAnimationRepeat(animation: Animator?) {}
            })
        }
    }

    private fun deleteBookmarkImg() {
        isBookmark = false
        setBookmarkImage(binding.ivBookmark, isBookmark)
    }

    override fun onResume() {
        super.onResume()
        getCampDetail()
    }

    fun getCampDetail() {
        viewModel.getCampDetail(id)
    }
}