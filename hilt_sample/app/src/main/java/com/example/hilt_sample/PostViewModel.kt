package com.example.hilt_sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt_sample.data.Post
import com.example.hilt_sample.data.PostDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postDao: PostDao,
): ViewModel() {
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