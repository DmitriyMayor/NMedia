package ru.netology.nmedia.activity

import android.os.Bundle
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity

import ru.netology.nmedia.adapter.PostsAdapter

import ru.netology.nmedia.databinding.ActivityMainBinding

import ru.netology.nmedia.viewmodel.PostViewModel
import kotlin.math.ln
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        val adapter = PostsAdapter ({
            viewModel.likeById(it.id)}
        ) {
            viewModel.shareById(it.id)
        }
        binding.container.adapter = adapter
        viewModel.data.observe(this) { posts ->
            adapter.submitList(posts)


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



