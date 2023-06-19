package com.poyatodev.practica_android_avanzado.Data

import com.poyatodev.practica_android_avanzado.Data.Local.LocalDataSource
import com.poyatodev.practica_android_avanzado.Data.Mappers.GetHeroesResponseToHeroe
import com.poyatodev.practica_android_avanzado.Data.Mappers.GetHeroesResponseToLocalHeroe
import com.poyatodev.practica_android_avanzado.Data.Mappers.GetLocationsResponseToLocations
import com.poyatodev.practica_android_avanzado.Data.Mappers.LocalHeroeToHeroe
import com.poyatodev.practica_android_avanzado.Data.Remote.RemoteDataSource
import com.poyatodev.practica_android_avanzado.UI.MainActivity.Model.Heroe
import com.poyatodev.practica_android_avanzado.UI.MainActivity.Model.Location
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource : RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val getHeroesResponseToHeroe: GetHeroesResponseToHeroe,
    private val localHeroeToHeroe: LocalHeroeToHeroe,
    private val getHeroesResponseToLocalHeroe: GetHeroesResponseToLocalHeroe,
    private val getLocationsResponseToLocations: GetLocationsResponseToLocations
): Repository
{
    //Remote methods
    override suspend fun performLogin(loginData: String): String{
        return remoteDataSource.performLogin(loginData)
    }

    override suspend fun getHeroes(): List<Heroe>{
        if(localDataSource.getHeroes().isEmpty()){
            localDataSource.insertHeroes(getHeroesResponseToLocalHeroe.mapFromGetHeroesResponsesToLocalHeroes(remoteDataSource.getHeroes()))
            return getHeroesResponseToHeroe.mapFromGetHeroesResponsesToHeroes(remoteDataSource.getHeroes())
        }
        return localHeroeToHeroe.mapFromLocalHeroesToHeroes(localDataSource.getHeroes())
    }

    override suspend fun getHeroe(id: String): Heroe {
        return localHeroeToHeroe.mapFromLocalHeroeToHeroe(localDataSource.getHeroe(id))
    }

    override suspend fun updateHeroeFavStateLocalAndRemote(id: String, isFav: Boolean) {
        //Local
        localDataSource.updateHeroeFavStateLocal(id, isFav)
        //Remote
        remoteDataSource.updateHeroeFavStateRemote(id, isFav)
    }

    override suspend fun retrieveHeroeLocations(id: String): List<Location> {
        return getLocationsResponseToLocations
            .mapFromGetLocationsResponseToLocations(remoteDataSource.retrieveHeroeLocations(id))
    }

}