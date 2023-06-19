package com.poyatodev.practica_android_avanzado.Data

import com.poyatodev.practica_android_avanzado.UI.MainActivity.Model.Location
import com.poyatodev.practica_android_avanzado.UI.MainActivity.Model.Heroe

interface Repository {
    suspend fun performLogin(loginData: String): String
    suspend fun getHeroes(): List<Heroe>

    suspend fun  getHeroe(id:String): Heroe

    suspend fun  updateHeroeFavStateLocalAndRemote(id: String, isFav:Boolean)

    suspend fun retrieveHeroeLocations(id: String): List<Location>
}