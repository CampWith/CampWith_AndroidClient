package com.example.campwith.presentation.camplist.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.campwith.CampTypeConstant.getTypeName
import com.example.campwith.R
import com.example.campwith.databinding.FragmentCampListBinding
import com.example.campwith.presentation.base.BaseFragment
import com.example.campwith.presentation.camplist.adapter.CampListAdapter
import com.example.campwith.presentation.camplist.viewmodel.CampListViewModel
import com.example.campwith.presentation.main.view.MainActivity
import kotlinx.android.synthetic.main.fragment_camp_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CampListFragment :
    BaseFragment<FragmentCampListBinding, CampListViewModel>(R.layout.fragment_camp_list) {
    override val viewModel: CampListViewModel by viewModel()
    private var region: String? = null
    private var type: Int? = null
    private lateinit var currentActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        currentActivity = activity as MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            region = it.getString(ARG_PARAM1)
            type = it.getInt(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val campListAdapter = CampListAdapter(currentActivity)

        if (region != null) {
            viewModel.getCampList(region!!)
            currentActivity.runOnUiThread {
                binding.toolbarActivityCampList.run {
                    setBackBtnVisible(true)
                    setCancleBtnVisible(false)
                    setLogoVisible(false)
                    setTitle(region!!)
                    setBackBtnClick(View.OnClickListener {
                        currentActivity.replaceFragment(
                            null,
                            null
                        )
                    })
                }
            }
        } else if (type != null) {
            viewModel.getTypeCampList(type!!)
            currentActivity.runOnUiThread {
                binding.toolbarActivityCampList.run {
                    setBackBtnVisible(true)
                    setCancleBtnVisible(false)
                    setLogoVisible(false)
                    setTitle(getTypeName(type!!))
                    setBackBtnClick(View.OnClickListener {
                        currentActivity.replaceFragment(
                            null,
                            null
                        )
                    })
                }
            }
        }

        rv_camp_list.adapter = campListAdapter

        viewModel.campListLiveData.observe(viewLifecycleOwner,
            Observer {
                campListAdapter.addAll(it)
            })
    }

    companion object {
        private const val ARG_PARAM1 = "REGION"
        private const val ARG_PARAM2 = "TYPE"

        @JvmStatic
        fun newInstance(param: String) =
            CampListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param)
                }
            }

        @JvmStatic
        fun newInstance(param: Int) =
            CampListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM2, param)
                }
            }

    }
}