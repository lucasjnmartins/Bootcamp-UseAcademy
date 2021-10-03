package com.example.challenge2useacademy.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Movies::class], version = 2)
abstract class AppDataBase: RoomDatabase() {
    abstract fun MovieDataDao(): MovieDataDao
}