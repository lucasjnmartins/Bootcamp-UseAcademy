package com.example.feed.PostsRepository

data class Post (
    val name: String,
    val text: String,
    val comenntList: ArrayList<Comment> = arrayListOf()
)
