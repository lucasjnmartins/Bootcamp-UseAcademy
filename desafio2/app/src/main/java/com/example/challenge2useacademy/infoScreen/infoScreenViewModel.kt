package com.example.challenge2useacademy.infoScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge2useacademy.movies.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class infoScreenViewModel: ViewModel() {
    private val service: MoviesService = MoviesAPI().createService(MoviesService::class.java)
    private val repository: MoviesRepository = MoviesRepository(service)
    private val _details: MutableLiveData<ResponseMovieDetails> = MutableLiveData()
    val details: LiveData<ResponseMovieDetails> = _details

    fun fetchDetailMovies(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getDetailMovies(id).catch {
                val s = it
            }.collect {
                launch(Dispatchers.Main) {
                    _details.value = it
                }
            }
        }
    }
}