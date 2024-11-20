package ru.netology.nmedia.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.activity.getFormattedLikesNumber
import ru.netology.nmedia.activity.getFormattedSharesNumber
import ru.netology.nmedia.activity.getFormattedViewsNumber
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post

class PostViewHolder(private val binding: CardPostBinding, private val likeCallback: LikeCallback, private  val  shareCallback: ShareCallback) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) = with(binding) {
        tvAuthor.text = post.author
        tvPublished.text = post.published
        tvPostText.text = post.content
        share.isActivated
        shareCounter.text = getFormattedSharesNumber(post.shareCounter)
        likesCounter.text = getFormattedLikesNumber(post.likesCounter)
        viewsCounter.text = getFormattedViewsNumber(post.viewsCounter)
        likes.setImageResource(
            if (post.likeByMe) R.drawable.icons8__30 else R.drawable.favorite_24px
        )

        likes.setOnClickListener {
            likeCallback(post)
        }
        share.setOnClickListener {
            shareCallback(post)
        }
    }
}