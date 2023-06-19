package com.poyatodev.practica_android_avanzado.Data.Mappers


import com.poyatodev.practica_android_avanzado.Data.Local.LocalHeroe
import com.poyatodev.practica_android_avanzado.UI.MainActivity.Model.Heroe
import javax.inject.Inject

class LocalHeroeToHeroe @Inject constructor() {
    fun mapFromLocalHeroesToHeroes(getLocalHeroeList: List<LocalHeroe>) : List<Heroe>{
        return getLocalHeroeList.map {mapFromLocalHeroeToHeroe(it)}
    }

    fun mapFromLocalHeroeToHeroe(getLocalHeroe: LocalHeroe): Heroe {
        return Heroe(getLocalHeroe.id,getLocalHeroe.name,getLocalHeroe.photo, getLocalHeroe.description,getLocalHeroe.favorite)
    }

}