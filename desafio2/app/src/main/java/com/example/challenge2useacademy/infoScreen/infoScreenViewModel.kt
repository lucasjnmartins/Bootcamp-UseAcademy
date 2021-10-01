package com.example.challenge2useacademy.infoScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge2useacademy.movies.MoviesAPI
import com.example.challenge2useacademy.movies.MoviesRepository
import com.example.challenge2useacademy.movies.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class infoScreenViewModel: ViewModel() {
    private val service: MoviesService = MoviesAPI().createService(MoviesService::class.java)
    private val repository: MoviesRepository = MoviesRepository(service)

//    fun fetchDetailMovies(id: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.getDetailMovies(id).catch {
//                val s = it
//            }.collect {
//                launch(Dispatchers.Main) {
//                    _moviesList.value = it.item
//                }
//            }
//        }
//    }
}