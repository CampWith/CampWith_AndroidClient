package com.example.campwith.presentation.camptip.view

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.campwith.R
import com.example.campwith.data.camptool.model.CampToolModel
import com.google.accompanist.glide.rememberGlidePainter

@ExperimentalAnimationApi
@Composable
fun CampToolScreen(campTools: List<CampToolModel>) {
    LazyColumn(
        contentPadding = PaddingValues(top = 8.dp)
    ) {
        items(campTools) { camptool ->
            CampToolColumn(campTool = camptool)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun CampToolColumn(campTool: CampToolModel) {
    var isFront by remember { mutableStateOf(campTool.isFront) }

    Card(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Box {
            Image(
                painter = rememberGlidePainter(
                    request = campTool.img,
                    previewPlaceholder = R.drawable.ic_baseline_image_24
                ),
                contentDescription = campTool.title,
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.DarkGray, BlendMode.Multiply),
                modifier = Modifier.fillMaxWidth()
            )
            IconButton(
                onClick = {
                    campTool.isFront = !campTool.isFront
                    isFront = !isFront
                },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = null,
                    tint = Color.White,
                )
            }
            AnimatedVisibility(
                visible = isFront,
                modifier = Modifier
                    .align(Alignment.Center),
                enter = slideInVertically(
                    initialOffsetY = { -40 }
                ) + expandVertically(
                    expandFrom = Alignment.Top
                ) + fadeIn(initialAlpha = 0.3f),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                Text(
                    text = campTool.title,
                    color = Color.White,
                    style = typography.h6,
                    fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold))
                )
            }
            AnimatedVisibility(
                visible = !isFront,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(20.dp),
                enter = slideInVertically(
                    initialOffsetY = { -40 }
                ) + expandVertically(
                    expandFrom = Alignment.Top
                ) + fadeIn(initialAlpha = 0.3f),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                Text(
                    text = campTool.info,
                    color = Color.White,
                    style = typography.body2,
                    fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium)),
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun PreviewCampToolScreen() {
    val campTools = mutableListOf<CampToolModel>()
    for (i in 1..5) {
        campTools.add(
            CampToolModel(
                "https://search.pstatic.net/common/?src=http%3A%2F%2Fcafefiles.naver.net%2FMjAyMTAzMTBfMjUx%2FMDAxNjE1MzEyODY5MjIy.al8mLXaAXrVfYclG9rKZWbyr6nZtatcyoG9PTczkJ2gg.OvXCpB9sdoP5wE9oDKb1I7haZvJBjMGZszVac7hG72Eg.JPEG%2F4aa9d9972805fbce0f8bcb1390cf1cdf19e02247e1bca39590c9054ae2af.jpg&type=sc960_832",
                "아주 좋아요!",
                "여름용 텐트",
                true
            )
        )
    }
    CampToolScreen(campTools)
}