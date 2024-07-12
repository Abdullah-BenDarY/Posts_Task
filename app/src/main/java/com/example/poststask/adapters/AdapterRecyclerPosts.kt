package com.example.poststask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poststask.databinding.ItemPostsBinding
import com.example.poststask.models.Post

class AdapterRecyclerPosts(private val posts: List<Post> = listOf()) : RecyclerView.Adapter<AdapterRecyclerPosts.Holder>() {

    private lateinit var onClick: (String) -> Unit

    fun setOnClick(onClick: (String) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemPostsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount()= posts.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = posts[position]
        holder.bind(data)
    }

    inner class Holder(private val binding: ItemPostsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(postsList: Post) {
            binding.apply {
                txtUserName.text = postsList.postName
                txtPostTime.text = postsList.postThumb
            }
        }
    }
}
