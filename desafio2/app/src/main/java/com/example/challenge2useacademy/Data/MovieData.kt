package com.example.challenge2useacademy.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.challenge2useacademy.movies.Actor
import java.lang.reflect.Constructor

@Entity
data class Movies(
    @PrimaryKey
    var id: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "crew")
    val crew: String,

    @ColumnInfo(name = "year")
    val year: String,

    @ColumnInfo(name = "genre")
    var genre: String
)