package com.example.hilt_sample

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class PostViewModelFactory(application: Application): ViewModelProvider.Factory {
    private val application by lazy {
        application
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PostViewModel::class.java)){
            return PostViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}