package com.example.campwith.presentation.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.campwith.R
import com.example.campwith.databinding.ItemCustomToolbarBinding

class CustomToolbar : ConstraintLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )

    private val binding: ItemCustomToolbarBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.item_custom_toolbar,
        this,
        true
    )

    fun setLogoVisible(visible: Boolean) {
        when (visible) {
            true -> binding.ivToolbarLogo.visibility = View.VISIBLE
            false -> binding.ivToolbarLogo.visibility = View.INVISIBLE
        }
    }

    fun setBackBtnVisible(visible: Boolean) {
        when (visible) {
            true -> binding.ivToolbarBack.visibility = View.VISIBLE
            false -> binding.ivToolbarBack.visibility = View.GONE
        }
    }

    fun setCancleBtnVisible(visible: Boolean) {
        when (visible) {
            true -> binding.ivToolbarCancle.visibility = View.VISIBLE
            false -> binding.ivToolbarCancle.visibility = View.GONE
        }
    }

    fun setTitle(title: String) {
        binding.tvToolbarTitle.text = title
    }

    fun setCenterTitle(title: String) {
        binding.tvToolbarCenterTitle.text = title
    }

    fun setBackBtnClick(onClickListener: OnClickListener) {
        binding.ivToolbarBack.setOnClickListener(onClickListener)
    }

    fun setCancleBtnClick(onClickListener: OnClickListener) {
        binding.ivToolbarCancle.setOnClickListener(onClickListener)
    }
}