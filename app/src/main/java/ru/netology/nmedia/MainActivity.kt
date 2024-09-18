package ru.netology.nmedia

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity

import ru.netology.nmedia.data.Post
import ru.netology.nmedia.databinding.ActivityMainBinding
import kotlin.math.ln
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var post = Post(
            id = 1,
            author = "Нетология, университет интернет-профессий будущего",
            content = "Очень длинная строка бла бла бла",
            published = "01.09.2024 14:00",
            shareCounter = 999,
            likesCounter = 999,
            likeByMe = false,
            viewsCounter = 1000
        )
        with(binding) {
            tvAuthor.text = post.author
            tvPublished.text = post.published
            tvPostText.text = post.content
            share.isActivated
            shareCounter.text = getFormattedSharesNumber(post.shareCounter)
            likesCounter.text = getFormattedLikesNumber(post.likesCounter)
            viewsCounter.text = getFormattedViewsNumber(post.viewsCounter)

            likes.setOnClickListener {
                post.likeByMe = !post.likeByMe
                Log.d("Dima", "likes clicked")

                likes.setImageResource(
                    if (post.likeByMe) {
                        R.drawable.icons8__30
                    } else {
                        R.drawable.favorite_24px
                    }
                )
                if (post.likeByMe) {
                    post.likesCounter++
                } else {
                    post.likesCounter--
                }
                likesCounter.text = getFormattedLikesNumber(post.likesCounter)
            }
            share.setOnClickListener {
                post.shareCounter++
                shareCounter.text = getFormattedViewsNumber(post.viewsCounter)
            }
            root.setOnClickListener {
                Log.d("Dima", "root clicked")
            }
            imageView2.setOnClickListener {
                Log.d("Dima", "avatar clicked")
            }
        }

    }

    fun getFormattedLikesNumber(likes: Long): String {
        if (likes < 1000) return "" + likes
        val exp = (ln(likes.toDouble()) / ln(1000.0)).toInt()
        return String.format("%.1f %c", likes / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
    }

    fun getFormattedSharesNumber(shares: Long): String {
        if (shares < 1000) return "" + shares
        val exp = (ln(shares.toDouble()) / ln(1000.0)).toInt()
        return String.format("%.1f %c", shares / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
    }

    fun getFormattedViewsNumber(views: Long): String {
        if (views < 1000) return "" + views
        val exp = (ln(views.toDouble()) / ln(1000.0)).toInt()
        return String.format("%.1f %c", views / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
    }
}

