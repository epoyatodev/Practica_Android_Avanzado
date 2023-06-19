package com.poyatodev.practica_android_avanzado

import com.poyatodev.practica_android_avanzado.Data.Remote.GetHeroesResponse
import com.poyatodev.practica_android_avanzado.Data.Remote.GetLocationsResponse
import com.poyatodev.practica_android_avanzado.Data.Remote.RemoteDataSource


class FakeRemoteDataSource: RemoteDataSource {
    override suspend fun performLogin(loginData: String): String {
        return generateFakeToken()
    }

    override suspend fun getHeroes(): List<GetHeroesResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun updateHeroeFavStateRemote(id: String, isFav: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun retrieveHeroeLocations(id: String): List<GetLocationsResponse> {
        TODO("Not yet implemented")
    }

}