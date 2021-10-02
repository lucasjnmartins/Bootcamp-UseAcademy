package com.example.challenge2useacademy.startScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge2useacademy.movies.Movies
import com.example.challenge2useacademy.movies.MoviesAPI
import com.example.challenge2useacademy.movies.MoviesRepository
import com.example.challenge2useacademy.movies.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class startScreenViewModel: ViewModel() {
    private val service: MoviesService = MoviesAPI().createService(MoviesService::class.java)
    private val repository: MoviesRepository = MoviesRepository(service)
    private val _moviesListForYou: MutableLiveData<List<Movies>> = MutableLiveData<List<Movies>>()
    private val _moviesListAction: MutableLiveData<List<Movies>> = MutableLiveData<List<Movies>>()
    private val _moviesListDrama: MutableLiveData<List<Movies>> = MutableLiveData<List<Movies>>()
    val movieListForYou: LiveData<List<Movies>> = _moviesListForYou
    val movieListAction: LiveData<List<Movies>> = _moviesListAction
    val movieListDrama: LiveData<List<Movies>> = _moviesListDrama
    val release: MutableLiveData<Movies> = MutableLiveData<Movies>()

    fun fetchMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMovies().catch {
                val s = it
            }.collect {
                launch(Dispatchers.Main) {
                    initList(_moviesListForYou, it.item, 0, 10)
                    initList(_moviesListAction, it.item, 50, 60)
                    initList(_moviesListDrama, it.item, 100, 110)
                    release.value = it.item[0]
                }
            }
        }
    }

    private fun initList(list: MutableLiveData<List<Movies>>, base: List<Movies>, start: Int, end: Int) {
        val setListAux: ArrayList<Movies> = arrayListOf()
        for(i in start until end){
            setListAux.add(base[i])
        }
        list.value = setListAux
    }

}