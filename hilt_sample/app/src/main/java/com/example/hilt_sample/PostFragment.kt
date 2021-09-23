package com.example.hilt_sample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_post.*

@AndroidEntryPoint
class PostFragment : Fragment(R.layout.fragment_post) {
    val viewModel: PostViewModel by viewModels()
    val postAdapter = PostAdapter(listOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        post_recycler_view.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = postAdapter
        }

        viewModel.postList.observe(viewLifecycleOwner) { postList ->
            postAdapter.setPostList(postList)
        }

        post_button.setOnClickListener {
            viewModel.addPost(post_message.text.toString())
        }
    }
}