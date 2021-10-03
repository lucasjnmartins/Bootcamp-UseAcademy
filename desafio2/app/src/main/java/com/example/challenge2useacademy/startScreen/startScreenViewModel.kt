package com.example.challenge2useacademy.startScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge2useacademy.Data.Movies
import com.example.challenge2useacademy.Data.RoomConection
import com.example.challenge2useacademy.R
import com.example.challenge2useacademy.movies.MoviesAPI
import com.example.challenge2useacademy.movies.MoviesRepository
import com.example.challenge2useacademy.movies.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class startScreenViewModel : ViewModel() {
    private val _moviesListForYou: MutableLiveData<List<Movies>> = MutableLiveData<List<Movies>>()
    private val _moviesListAction: MutableLiveData<List<Movies>> = MutableLiveData<List<Movies>>()
    private val _moviesListDrama: MutableLiveData<List<Movies>> = MutableLiveData<List<Movies>>()
    val movieListForYou: LiveData<List<Movies>> = _moviesListForYou
    val movieListAction: LiveData<List<Movies>> = _moviesListAction
    val movieListDrama: LiveData<List<Movies>> = _moviesListDrama
    val release: MutableLiveData<Movies> = MutableLiveData<Movies>()
    var list: List<Movies> = arrayListOf()
    private val service: MoviesService = MoviesAPI().createService(MoviesService::class.java)
    private val repository: MoviesRepository = MoviesRepository(service)

    fun fetchMovies(context: startScreen, elements: Int) {
        val database = RoomConection(context.requireContext()).db()
        viewModelScope.launch(Dispatchers.IO) {

            list = database.MovieDataDao().getAll()
            if (list.isEmpty()) {
                repository.getMovies().catch {
                    val s: String
                }.collect {
                    launch(Dispatchers.Main) {
                        insertData(it.item, context)
                        initList(
                            _moviesListForYou,
                            database.MovieDataDao().getByGenre(context.getString(R.string.for_you)),
                            elements
                        )
                        initList(
                            _moviesListAction,
                            database.MovieDataDao().getByGenre(context.getString(R.string.action)),
                            elements
                        )
                        initList(
                            _moviesListDrama,
                            database.MovieDataDao().getByGenre(context.getString(R.string.drama)),
                            elements
                        )
                        release.postValue(database.MovieDataDao().getAll()[0])
                    }
                }
            } else {
                initList(
                    _moviesListForYou,
                    database.MovieDataDao().getByGenre(context.getString(R.string.for_you)),
                    elements
                )
                initList(
                    _moviesListAction,
                    database.MovieDataDao().getByGenre(context.getString(R.string.action)),
                    elements
                )
                initList(
                    _moviesListDrama,
                    database.MovieDataDao().getByGenre(context.getString(R.string.drama)),
                    elements
                )
                release.postValue(database.MovieDataDao().getAll()[0])
            }
        }
    }

    private fun initList(list: MutableLiveData<List<Movies>>, base: List<Movies>, count: Int) {
        val ListAux: ArrayList<Movies> = arrayListOf()
        for (i in 0 until count) {
            ListAux.add(base[i])
        }
        list.postValue(ListAux)
    }

    private suspend fun insertData(list: List<Movies>, context: startScreen) {
        lateinit var movie: Movies
        val database = RoomConection(context.requireContext()).db()

        for (i in 0 until (list.size - 3) step 3) {
            movie = Movies(
                list[i].id,
                list[i].title,
                list[i].image,
                list[i].crew,
                list[i].year,
                context.getString(R.string.for_you)
            )
            database.MovieDataDao().insert(movie)
            movie = Movies(
                list[i + 1].id,
                list[i + 1].title,
                list[i + 1].image,
                list[i + 1].crew,
                list[i + 1].year,
                context.getString(R.string.action)
            )
            database.MovieDataDao().insert(movie)
            movie = Movies(
                list[i + 2].id,
                list[i + 2].title,
                list[i + 2].image,
                list[i + 2].crew,
                list[i + 2].year,
                context.getString(R.string.drama)
            )
            database.MovieDataDao().insert(movie)
        }
    }
}