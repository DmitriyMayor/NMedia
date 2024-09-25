package ru.netology.nmedia.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likesCounter: Long = 0,
    val likeByMe: Boolean = false,
    val shareCounter: Long,
    val viewsCounter: Long

)