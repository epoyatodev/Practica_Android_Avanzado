package com.poyatodev.practica_android_avanzado.Data.Remote

import com.poyatodev.practica_android_avanzado.Data.Remote.GetHeroesResponse
import com.poyatodev.practica_android_avanzado.Data.Remote.GetLocationsResponse

interface RemoteDataSource {
    suspend fun performLogin(loginData:String): String

    suspend fun getHeroes(): List<GetHeroesResponse>

    suspend fun updateHeroeFavStateRemote(id:String, isFav: Boolean)

    suspend fun retrieveHeroeLocations(id: String): List<GetLocationsResponse>

}