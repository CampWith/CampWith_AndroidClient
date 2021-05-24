package com.example.campwith

object CampTypeConstant {
    const val AUTO_TYPE = 0
    const val NORMAL_TYPE = 1
    const val CARAVEN_TYPE = 2
    const val GLAMPING_TYPE = 3

    fun getTypeName(type: Int): String {
        return when (type) {
            AUTO_TYPE -> "오토캠핑"
            NORMAL_TYPE -> "일반캠핑"
            CARAVEN_TYPE -> "카라반"
            GLAMPING_TYPE -> "글램핑"
            else -> ""
        }
    }
}