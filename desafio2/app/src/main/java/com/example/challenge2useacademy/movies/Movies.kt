package com.example.challenge2useacademy.movies

import com.example.challenge2useacademy.Data.Movies
import com.google.gson.annotations.SerializedName

data class Actor(
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("asCharacter")
    val asCharacter: String?
)

data class ResponseMovies(
    @SerializedName("items")
    val item: List<Movies>,
    @SerializedName("errorMessage")
    val error: String?
)

data class ResponseMovieDetails(
    @SerializedName("image")
    var image: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("stars")
    var stars: String?,
    @SerializedName("plot")
    var plot: String?,
    @SerializedName("actorList")
    var actorList: List<Actor>
)