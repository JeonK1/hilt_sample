package com.example.hilt_sample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_post.*

class PostFragment : Fragment(R.layout.fragment_post) {
    var post_list = mutableListOf<Post>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        post_recycler_view.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = PostAdapter(post_list.toList())
        }

        post_button.setOnClickListener {
            post_list.add(
                Post(
                    postNo = post_list.size,
                    postContext = post_message.text.toString(),
                    createdDate = System.currentTimeMillis()
                )
            )
            post_recycler_view.adapter = PostAdapter(post_list.toList())
        }

    }
}