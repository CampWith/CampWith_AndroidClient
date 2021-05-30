package com.example.campwith.presentation.camptip.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.campwith.data.camp.response.CampToolResponse
import com.example.campwith.data.camp.response.CampToolResponseItem
import androidx.compose.foundation.lazy.items
import com.example.campwith.R
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun CampToolScreen(campTools: CampToolResponse) {
    LazyColumn(
        contentPadding = PaddingValues(top = 8.dp)
    ) {
        items(campTools) { camptool ->
            CampToolColumn(campTool = camptool)
        }
    }

}

@Composable
fun CampToolColumn(campTool: CampToolResponseItem) {
    Column {
        Image(
            painter = rememberGlidePainter(
                request = campTool.img,
                previewPlaceholder = R.drawable.ic_baseline_image_24
            ),
            contentDescription = campTool.title
        )
        Text(campTool.title)
        Text(campTool.info)
    }
}

@Preview
@Composable
fun PreviewCampToolScreen() {
    val campTools = CampToolResponse()
    for (i in 1..5) {
        campTools.add(
            CampToolResponseItem(
                "1",
                "https://search.pstatic.net/common/?src=http%3A%2F%2Fcafefiles.naver.net%2FMjAyMTAzMTBfMjUx%2FMDAxNjE1MzEyODY5MjIy.al8mLXaAXrVfYclG9rKZWbyr6nZtatcyoG9PTczkJ2gg.OvXCpB9sdoP5wE9oDKb1I7haZvJBjMGZszVac7hG72Eg.JPEG%2F4aa9d9972805fbce0f8bcb1390cf1cdf19e02247e1bca39590c9054ae2af.jpg&type=sc960_832",
                "아주 좋아요!",
                "여름용 텐트"
            )
        )
    }
    CampToolScreen(campTools)
}