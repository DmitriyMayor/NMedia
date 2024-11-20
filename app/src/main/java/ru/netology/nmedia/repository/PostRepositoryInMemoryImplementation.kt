package ru.netology.nmedia.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

class PostRepositoryInMemoryImplementation : PostRepository {

    private var posts = listOf(
        Post(
            id = 1,
            author = "Нетология, университет интернет-профессий будущего",
            content = "Очень длинная строка бла бла бла",
            published = "01.09.2024 14:00",
            shareCounter = 999,
            likesCounter = 999,
            likeByMe = false,
            viewsCounter = 1000
        ),
        Post(
            id = 2,
            author = "Нетология, университет интернет-профессий будущего",
            content = "Очень длинная строка бла бла бла sssssss",
            published = "01.09.2024 15:00",
            shareCounter = 2,
            likesCounter = 3,
            likeByMe = true,
            viewsCounter = 777
        ),
        Post(
            id = 3,
            author = "Нетология, университет интернет-профессий будущего",
            content = "Очень длинная строка бла бла бла sssssss saiuvalviu fivaelfivb sfvsefv",
            published = "01.09.2024 15:00",
            shareCounter = 4,
            likesCounter = 6,
            likeByMe = false,
            viewsCounter = 888
        ),
        Post(
            id = 4,
            author = "Нетология, университет интернет-профессий будущего",
            content = "Очень длинная строка бла бла бла sssssss saiuvalviu fivaelfivb sfvsefv",
            published = "01.09.2024 15:00",
            shareCounter = 4,
            likesCounter = 6,
            likeByMe = false,
            viewsCounter = 888
        ),
        Post(
            id = 5,
            author = "Нетология, университет интернет-профессий будущего",
            content = "Очень длинная строка бла бла бла sssssss saiuvalviu fivaelfivb sfvsefv",
            published = "01.09.2024 15:00",
            shareCounter = 4,
            likesCounter = 6,
            likeByMe = false,
            viewsCounter = 888
        ),
        Post(
            id = 6,
            author = "Нетология, университет интернет-профессий будущего",
            content = "Очень длинная строка бла бла бла sssssss saiuvalviu fivaelfivb sfvsefv",
            published = "01.09.2024 15:00",
            shareCounter = 4,
            likesCounter = 6,
            likeByMe = false,
            viewsCounter = 888
        ),
        Post(
            id = 7,
            author = "Нетология, университет интернет-профессий будущего",
            content = "Очень длинная строка бла бла бла sssssss saiuvalviu fivaelfivb sfvsefv",
            published = "01.09.2024 15:00",
            shareCounter = 4,
            likesCounter = 6,
            likeByMe = false,
            viewsCounter = 888
        ),
        Post(
            id = 8,
            author = "Нетология, университет интернет-профессий будущего",
            content = "Очень длинная строка бла бла бла sssssss saiuvalviu fivaelfivb sfvsefv",
            published = "01.09.2024 15:00",
            shareCounter = 4,
            likesCounter = 6,
            likeByMe = false,
            viewsCounter = 888
        ),
        Post(
            id = 9,
            author = "Нетология, университет интернет-профессий будущего",
            content = "Очень длинная строка бла бла бла sssssss saiuvalviu fivaelfivb sfvsefv",
            published = "01.09.2024 15:00",
            shareCounter = 4,
            likesCounter = 6,
            likeByMe = false,
            viewsCounter = 888
        ),
        Post(
            id = 10,
            author = "Нетология, университет интернет-профессий будущего",
            content = "Очень длинная строка бла бла бла sssssss saiuvalviu fivaelfivb sfvsefv",
            published = "01.09.2024 15:00",
            shareCounter = 4,
            likesCounter = 6,
            likeByMe = false,
            viewsCounter = 888
        )

    )

    private val data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = data

    override fun shareById(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(
                shareCounter = it.shareCounter.plus(1)
            )
        }
        data.value = posts
    }

    override fun likeById(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(
                likeByMe = !it.likeByMe,
                likesCounter = if (it.likeByMe) it.likesCounter - 1 else it.likesCounter + 1
            )
        }

        data.value = posts

    }


}