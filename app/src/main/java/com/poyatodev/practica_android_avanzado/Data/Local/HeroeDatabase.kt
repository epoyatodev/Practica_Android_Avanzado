package com.poyatodev.practica_android_avanzado.Data.Local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalHeroe::class], version = 1)
abstract class HeroeDatabase :RoomDatabase(){
    abstract fun heroeDao(): HeroeDAO
}