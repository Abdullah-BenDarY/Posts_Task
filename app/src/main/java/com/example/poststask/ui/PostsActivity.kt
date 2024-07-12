package com.example.poststask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poststask.adapters.AdapterRecyclerPosts
import com.example.poststask.databinding.ActivityPostsBinding
import com.example.poststask.models.Post

class PostsActivity : AppCompatActivity() {
    private var _binding: ActivityPostsBinding? = null
    private val binding get() = _binding!!

    private lateinit var posts: MutableList<Post>
    private lateinit var adapterPosts: AdapterRecyclerPosts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addInitialPosts()
        setAdapter(posts)
    }

    private fun setAdapter(posts: List<Post>) {
        adapterPosts = AdapterRecyclerPosts(posts)
        binding.recyclerPosts.adapter = adapterPosts
    }

    private fun addInitialPosts() {
        posts = mutableListOf()
        for (i in 1..100) {
            posts.add(Post(postName = "mohammed $i", postThumb = "post $i"))
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
