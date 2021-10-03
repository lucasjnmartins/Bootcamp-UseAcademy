package com.example.challenge2useacademy.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MovieDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg movie: Movies)

    @Query("SELECT * FROM Movies")
    suspend fun getAll(): List<Movies>

    @Query("SELECT * FROM movies WHERE genre=(:genreString)")
    suspend fun getByGenre(genreString: String): List<Movies>

}