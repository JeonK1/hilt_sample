package com.example.hilt_sample.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat

@Entity(tableName = "post_table")
data class Post(
    @PrimaryKey(autoGenerate = true) val postNo: Int,
    val postContext: String,
    val createdDate: Long = System.currentTimeMillis()
) {
    val createdDate_formatted
        get() = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createdDate)
}