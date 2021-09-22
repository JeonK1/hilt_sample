package com.example.hilt_sample.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostDao {
    @Insert
    suspend fun insert(post: Post)

    @Query("SELECT * FROM post_table")
    fun getPostList(): LiveData<List<Post>>
}