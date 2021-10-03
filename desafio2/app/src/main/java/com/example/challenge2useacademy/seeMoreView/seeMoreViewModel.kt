package com.example.challenge2useacademy.seeMoreView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge2useacademy.Data.Movies
import com.example.challenge2useacademy.Data.RoomConection
import com.example.challenge2useacademy.R
import com.example.challenge2useacademy.seeMore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class seeMoreViewModel : ViewModel() {
    private val _moviesListForYou: MutableLiveData<List<Movies>> = MutableLiveData<List<Movies>>()
    private val _moviesListAction: MutableLiveData<List<Movies>> = MutableLiveData<List<Movies>>()
    private val _moviesListDrama: MutableLiveData<List<Movies>> = MutableLiveData<List<Movies>>()
    val movieListForYou: LiveData<List<Movies>> = _moviesListForYou
    val movieListAction: LiveData<List<Movies>> = _moviesListAction
    val movieListDrama: LiveData<List<Movies>> = _moviesListDrama

    fun fetchMovies(context: seeMore) {
        viewModelScope.launch(Dispatchers.IO) {
            val database = RoomConection(context.requireContext()).db()
            launch(Dispatchers.Main) {
                initList(
                    _moviesListForYou,
                    database.MovieDataDao().getByGenre(context.getString(R.string.for_you))
                )
                initList(
                    _moviesListAction,
                    database.MovieDataDao().getByGenre(context.getString(R.string.action))
                )
                initList(
                    _moviesListDrama,
                    database.MovieDataDao().getByGenre(context.getString(R.string.drama))
                )
            }
        }
    }

    private fun initList(list: MutableLiveData<List<Movies>>, base: List<Movies>) {
        val setListAux: ArrayList<Movies> = arrayListOf()
        for (i in 0 until base.size) {
            setListAux.add(base[i])
        }
        list.postValue(setListAux)
    }
}