package com.example.challenge2useacademy.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.challenge2useacademy.movies.Movies


@Dao
interface MovieDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg movie: MovieData)



    @Query("SELECT * FROM moviedata")
    suspend fun getAll(): List<MovieData>

//    @Query("DELETE from * WHERE ")
//    suspend fun deleteAll()


}