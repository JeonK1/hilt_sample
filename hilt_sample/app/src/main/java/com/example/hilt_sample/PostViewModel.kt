package com.example.hilt_sample

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt_sample.data.Post
import com.example.hilt_sample.data.PostDao
import com.example.hilt_sample.data.PostDatabase
import kotlinx.coroutines.launch

class PostViewModel(application: Application): ViewModel() {
    private val postDao: PostDao by lazy {
        PostDatabase.getInstance(application).postDao()
    }

    val postList: LiveData<List<Post>> by lazy {
        postDao.getPostList()
    }

    fun insertPost(post: Post) = viewModelScope.launch {
        postDao.insert(post)
    }

    fun addPost(message: String){
        insertPost(
            Post(
                postNo = 0,
                postContext = message
            )
        )
    }

}