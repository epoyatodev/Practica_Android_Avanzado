package com.poyatodev.practica_android_avanzado.Data.Mappers


import com.poyatodev.practica_android_avanzado.Data.Local.LocalHeroe
import com.poyatodev.practica_android_avanzado.Data.Remote.GetHeroesResponse
import javax.inject.Inject

class GetHeroesResponseToLocalHeroe @Inject constructor() {
    fun mapFromGetHeroesResponsesToLocalHeroes(getHeroeResponseList: List<GetHeroesResponse>) : List<LocalHeroe>{
        return getHeroeResponseList.map {mapFromGetHeroeResponseToLocalHeroe(it)}
    }

    private  fun mapFromGetHeroeResponseToLocalHeroe(getHeroeResponse: GetHeroesResponse): LocalHeroe {
        return LocalHeroe(getHeroeResponse.id,getHeroeResponse.name,getHeroeResponse.photo, getHeroeResponse.description,getHeroeResponse.favorite)
    }
}