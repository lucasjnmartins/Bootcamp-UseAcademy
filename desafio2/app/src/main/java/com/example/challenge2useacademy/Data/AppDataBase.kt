package com.example.challenge2useacademy.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieData::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun MovieDataDao(): MovieDataDao

}