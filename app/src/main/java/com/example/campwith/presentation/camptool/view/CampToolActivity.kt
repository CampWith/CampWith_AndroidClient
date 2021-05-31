package com.example.campwith.presentation.camptool.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.graphics.Color
import com.example.campwith.presentation.camptool.viewmodel.CampToolViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CampToolActivity : ComponentActivity() {
    private val viewModel: CampToolViewModel by viewModel()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCampTool()
        viewModel.campToolLiveData.observe(this,
            {
                setContent {
                    Surface {
                        Column() {
                            TopAppBar(
                                title = { Text(text = "") },
                                backgroundColor = Color.White,
                                navigationIcon = {
                                    IconButton(onClick = { finish() }) {
                                        Icon(
                                            Icons.Filled.Close,
                                            contentDescription = null,
                                            tint = Color.Black,
                                        )
                                    }
                                }
                            )
                            CampToolScreen(campTools = it)
                        }
                    }
                }
            }
        )
    }
}