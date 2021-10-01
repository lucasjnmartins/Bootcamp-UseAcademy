package com.example.challenge2useacademy.movies

import com.example.challenge2useacademy.GlobalVariables
import kotlinx.coroutines.flow.Flow
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService {
    @GET("/API/Top250Movies/{apiKey}/")
    suspend fun all(@Path("apiKey")apikey: String): ResponseMovies

    @GET("/API/Title/{apiKey}/{id}/")
    suspend fun getDetailMovies(@Path("apiKey")apikey: String, @Path("id")id: String): ResponseMovieDetails
}