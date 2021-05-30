package com.example.campwith.presentation.camptip.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.campwith.presentation.camptip.viewmodel.CampToolViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CampToolActivity : ComponentActivity() {
    private val viewModel: CampToolViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCampTool()
        viewModel.campToolLiveData.observe(this,
            {
                setContent {
                    Surface {
                        CampToolScreen(campTools = it)
                    }
                }
            }
        )
    }
}