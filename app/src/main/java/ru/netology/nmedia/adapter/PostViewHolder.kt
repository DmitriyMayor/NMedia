package ru.netology.nmedia.adapter

import android.annotation.SuppressLint
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.activity.getFormattedLikesNumber
import ru.netology.nmedia.activity.getFormattedSharesNumber
import ru.netology.nmedia.activity.getFormattedViewsNumber
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post

class PostViewHolder(private val binding: CardPostBinding, private val onInterActionListener: onInterActionListener) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("ResourceType")
    fun bind(post: Post) = with(binding) {
        tvAuthor.text = post.author
        tvPublished.text = post.published
        tvPostText.text = post.content
        share.isActivated
        likes.isChecked = post.likeByMe
        likes.text = getFormattedLikesNumber(post.likesCounter)
        share.text = getFormattedSharesNumber(post.shareCounter)
        views.text = getFormattedViewsNumber(post.viewsCounter)

        likes.setOnClickListener {
            onInterActionListener.onLike(post)
        }
        share.setOnClickListener {
            onInterActionListener.onShare(post)
        }
        menu.setOnClickListener{
            PopupMenu(it.context, it).apply {
                inflate(R.menu.menu_options)
                setOnMenuItemClickListener {
                    when(it.itemId){
                        R.id.remove -> {
                            onInterActionListener.onRemove(post)
                            true
                        }

                        R.id.edit -> {
                            onInterActionListener.onEdit(post)
                            true
                        }

                        else -> false
                    }
                }
            }.show()
        }
    }
}
