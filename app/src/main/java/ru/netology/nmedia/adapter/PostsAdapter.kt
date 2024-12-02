package ru.netology.nmedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post

//typealias LikeCallback = (Post) -> Unit
//typealias ShareCallback = (Post) -> Unit
//typealias RemoveCallback = (Post) -> Unit


interface onInterActionListener {
    fun onLike(post: Post)
    fun onShare(post: Post)
    fun onRemove(post: Post)
    fun onEdit(post: Post)
}
class PostsAdapter(private val onInterActionListener: onInterActionListener) :
    ListAdapter<Post, PostViewHolder>(PostDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            CardPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onInterActionListener
        )

    }


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}