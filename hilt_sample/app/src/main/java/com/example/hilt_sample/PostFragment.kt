package com.example.hilt_sample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hilt_sample.data.Post
import com.example.hilt_sample.data.PostDatabase
import kotlinx.android.synthetic.main.fragment_post.*

class PostFragment : Fragment(R.layout.fragment_post) {
    val db by lazy {
        PostDatabase.getInstance(requireContext())
    }
    lateinit var viewModel: PostViewModel

    val postAdapter = PostAdapter(listOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            PostViewModelFactory(requireActivity().application)
        ).get(PostViewModel::class.java)

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