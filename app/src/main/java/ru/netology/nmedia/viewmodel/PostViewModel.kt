package ru.netology.nmedia.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryInMemoryImplementation

private val empty = Post(
    id = 0,
    author = "",
    content = "",
    published = "",
    shareCounter = 0,
    likesCounter = 0,
    likeByMe = false,
    viewsCounter = 0

)

class PostViewModel : ViewModel() {

    private val repository: PostRepository = PostRepositoryInMemoryImplementation()

    val data = repository.getAll()
    val edited = MutableLiveData(empty)

    fun saveContent(content: String){
        edited.value?.let {
           repository.save(it.copy(content = content))
        }

        edited.value = empty
    }
    fun cancelEditing(){
        edited.value = empty
    }
    fun likeById(id: Long) = repository.likeById(id)
    fun shareById(id: Long) = repository.shareById(id)
    fun removeById(id: Long) = repository.removeById(id)
    fun save(post: Post) = repository.save(post)
    fun edit(post: Post){
        edited.value = post
    }
}