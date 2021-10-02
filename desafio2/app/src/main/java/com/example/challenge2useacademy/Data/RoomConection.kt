package com.example.challenge2useacademy.Data

import android.content.Context
import androidx.room.Room

class RoomConection(private val context: Context) {
    fun db(): AppDataBase = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "movies-database"
    ).build()
}