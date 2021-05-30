package com.example.campwith.data.camptool.response

import android.annotation.SuppressLint
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import com.example.campwith.data.camptool.model.CampToolModel

@SuppressLint("ParcelCreator")
@Parcelize
data class CampToolResponseItem(
    val _id: String,
    val img: String,
    val info: String,
    val title: String
) : Parcelable

fun CampToolResponseItem.toModel(): CampToolModel {
    return CampToolModel(
        img = img,
        info = info,
        title = title,
        isFront = true
    )
}