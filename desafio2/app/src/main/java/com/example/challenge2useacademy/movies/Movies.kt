package com.example.challenge2useacademy.movies

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("id")
    val id: String,
    @SerializedName("rank")
    val rank: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("fullTitle")
    val fullTitle: String?,
    @SerializedName("year")
    val year: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("crew")
    val crew: String?,
    @SerializedName("imDbRating")
    val imDbRating: String?,
    @SerializedName("imDbRatingCount")
    val imDbRatingCount: String?
)

data class Actor(
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("asCharacter")
    val asCharacter: String
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