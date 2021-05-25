package com.example.campwith.presentation.main.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.campwith.R
import com.example.campwith.databinding.FragmentCityDialogBinding
import com.example.campwith.presentation.base.BaseDialogFragment
import com.example.campwith.presentation.main.viewmodel.CityDialogViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityDialogFragment :
    BaseDialogFragment<FragmentCityDialogBinding, CityDialogViewModel>(R.layout.fragment_city_dialog) {
    override val viewModel: CityDialogViewModel by viewModel()
    private lateinit var currentActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        currentActivity = activity as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentActivity.runOnUiThread {
            binding.toolbarFragmentCityDialog.run {
                setBackBtnVisible(false)
                setCancleBtnVisible(true)
                setLogoVisible(false)
                setCenterTitle("지역을 선택해 주세요")
                setCancleBtnClick(View.OnClickListener { dismiss() })
            }
        }

        for (i in 1..8) {
            val resName = "btn_region"
            val resId = resources.getIdentifier(resName + i, "id", activity?.packageName)
            val btn = view.findViewById<Button>(resId)
            btn.setOnClickListener {
                currentActivity.replaceFragment(btn.text.toString(), null)
                dismiss()
            }
        }
    }
}