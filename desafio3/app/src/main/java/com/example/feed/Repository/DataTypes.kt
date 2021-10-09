package com.example.feed.Repository

data class Comment(
    val name: String,
    val text: String
)

data class Post(
    val name: String,
    val text: String,
    val commentsList: ArrayList<Comment> = arrayListOf()
)

data class User(
    val name: String,
    val lastName: String,
    val username: String,
    val password: String
)

