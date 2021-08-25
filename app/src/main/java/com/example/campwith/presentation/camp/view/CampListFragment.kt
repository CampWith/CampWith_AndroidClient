package com.example.campwith.presentation.camp.view

import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.campwith.CampTypeConstant.getTypeName
import com.example.campwith.R
import com.example.campwith.databinding.FragmentCampListBinding
import com.example.campwith.presentation.base.BaseFragment
import com.example.campwith.presentation.camp.adapter.CampListAdapter
import com.example.campwith.presentation.camp.viewmodel.CampListViewModel
import com.example.campwith.presentation.main.view.MainActivity
import com.example.campwith.presentation.main.view.MainActivity.Companion.HOME
import com.example.campwith.presentation.main.view.MainActivity.Companion.MY_PAGE
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

        if (region != null) {
            viewModel.getCampList(region!!)
            currentActivity.runOnUiThread {
                binding.toolbarActivityCampList.run {
                    setBackBtnVisible(true)
                    setCancleBtnVisible(false)
                    setLogoVisible(false)
                    setTitle(region!!)
                    setBackBtnClick {
                        currentActivity.replaceFragmentType(HOME, "")
                    }
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
                    setBackBtnClick {
                        currentActivity.replaceFragmentType(HOME, "")
                    }
                }
            }
        } else {
            viewModel.getBookmarkCampList()
            currentActivity.runOnUiThread {
                binding.toolbarActivityCampList.run {
                    setBackBtnVisible(true)
                    setCancleBtnVisible(false)
                    setLogoVisible(false)
                    setTitle("즐겨찾기")
                    setBackBtnClick {
                        currentActivity.replaceFragmentType(MY_PAGE, "")
                    }
                }
            }
        }

        val campListAdapter = CampListAdapter(currentActivity)
        binding.rvCampList.adapter = campListAdapter

        viewModel.campListLiveData.observe(viewLifecycleOwner,
            {
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