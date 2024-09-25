package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

class PostRepositoryInMemoryImplementation: PostRepository {

    private var post = Post(
        id = 1,
        author = "Нетология, университет интернет-профессий будущего",
        content = "Очень длинная строка бла бла бла",
        published = "01.09.2024 14:00",
        shareCounter = 999,
        likesCounter = 999,
        likeByMe = false,
        viewsCounter = 1000
    )

    private val data = MutableLiveData(post)

    override fun get() = data
    override fun like() {
        post = post.copy(likeByMe = !post.likeByMe)
    }

}