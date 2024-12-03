package ru.netology.nmedia.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import ru.netology.nmedia.R

import ru.netology.nmedia.adapter.PostsAdapter
import ru.netology.nmedia.adapter.onInterActionListener

import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post

import ru.netology.nmedia.viewmodel.PostViewModel
import kotlin.math.ln
import kotlin.math.pow


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        val adapter = PostsAdapter(object : onInterActionListener {
            override fun onLike(post: Post) {
                viewModel.likeById(post.id)
            }

            override fun onShare(post: Post) {
                viewModel.shareById(post.id)
            }

            override fun onRemove(post: Post) {
                viewModel.removeById(post.id)
            }

            override fun onEdit(post: Post) {
                viewModel.edit(post)
            }

        })
        binding.container.adapter = adapter
        viewModel.data.observe(this) { posts ->
            val new = adapter.currentList.size < posts.size
            adapter.submitList(posts) {
                if (new) {
                    binding.container.smoothScrollToPosition(0)
                }
            }
        }

        viewModel.edited.observe(this) {
            if (it.id != 0L) {
                binding.editGroup.visibility = Group.VISIBLE
                binding.editField.setText(it.content)

                binding.content.setText(it.content)
                binding.content.requestFocus()
            } else binding.editGroup.visibility = Group.GONE
        }
        binding.cancel.setOnClickListener {
            viewModel.cancelEditing()
            binding.editGroup.visibility = Group.GONE
            binding.content.setText("")
            binding.content.clearFocus()

        }

        binding.save.setOnClickListener {
            val text = binding.content.text.toString()

            if (text.isBlank()) {
                Toast.makeText(this, R.string.nmedia, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            viewModel.saveContent(text)
            binding.content.setText("")
            binding.content.clearFocus()


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



