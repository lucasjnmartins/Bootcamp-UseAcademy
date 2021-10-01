package com.example.challenge2useacademy.movies

import com.example.challenge2useacademy.GlobalVariables
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MoviesRepository(private val moviesService: MoviesService) {
    suspend fun getDetailMovies(id: String): Flow<ResponseMovies> =
        flow {
            emit(moviesService.getDetailMovies(GlobalVariables.api, id))
        }

    suspend fun getMovies(): Flow<ResponseMovies> =
        flow {
            emit(moviesService.all(GlobalVariables.api))
        }
}