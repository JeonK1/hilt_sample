package com.example.hilt_sample

import java.text.SimpleDateFormat

data class Post(
    val postNo: Int,
    val postContext: String,
    val createdDate: Long
) {
    val createdDate_formatted
        get() = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createdDate)
}