package ru.netology.nmedia.data

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likesCounter: Long = 0,
    var likeByMe: Boolean = false,
    var shareCounter: Long,
    var viewsCounter: Long

)