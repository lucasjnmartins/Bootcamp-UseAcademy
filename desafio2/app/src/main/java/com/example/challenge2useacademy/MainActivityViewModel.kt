package com.example.challenge2useacademy

import android.app.Application
import androidx.lifecycle.*
import com.example.challenge2useacademy.Data.MovieData
import com.example.challenge2useacademy.Data.RoomConection
import com.example.challenge2useacademy.movies.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val service: MoviesService = MoviesAPI().createService(MoviesService::class.java)
    private val repository: MoviesRepository = MoviesRepository(service)
    var list: List<MovieData> = arrayListOf()

    fun checkDatabase(context: MainActivityView) {
        val database = RoomConection(context).db()
        viewModelScope.launch(Dispatchers.Main) {
            list = database.MovieDataDao().getAll()
            if (list.isEmpty()) {
                repository.getMovies().catch {
                    val s = it
                }.collect {
                    launch(Dispatchers.Main) {
                        insertData(it.item, context)
                    }
                }
            }
        }
    }

    private suspend fun insertData(list: List<Movies>, context: MainActivityView) {
        lateinit var movie: MovieData
        val database = RoomConection(context).db()

        for (i in 0 until (list.size - 3) step 3) {
            movie = MovieData(
                list[i].id,
                list[i].title,
                list[i].image,
                list[i].crew,
                list[i].year,
                context.getString(R.string.for_you)
            )
            database.MovieDataDao().insert(movie)
            movie = MovieData(
                list[i + 1].id,
                list[i + 1].title,
                list[i + 1].image,
                list[i + 1].crew,
                list[i + 1].year,
                context.getString(R.string.action)
            )
            database.MovieDataDao().insert(movie)
            movie = MovieData(
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