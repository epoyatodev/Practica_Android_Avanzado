package com.poyatodev.practica_android_avanzado.Data.Mappers

import com.poyatodev.practica_android_avanzado.Data.Remote.GetHeroesResponse
import com.poyatodev.practica_android_avanzado.UI.MainActivity.Model.Heroe
import javax.inject.Inject

class GetHeroesResponseToHeroe @Inject constructor() {
    fun mapFromGetHeroesResponsesToHeroes(getHeroeResponseList: List<GetHeroesResponse>) : List<Heroe>{
        return getHeroeResponseList.map {mapFromGetHeroeResponseToHeroe(it)}
    }

    private  fun mapFromGetHeroeResponseToHeroe(getHeroeResponse: GetHeroesResponse): Heroe {
        return Heroe(getHeroeResponse.id,getHeroeResponse.name,getHeroeResponse.photo, getHeroeResponse.description,getHeroeResponse.favorite)
    }
}