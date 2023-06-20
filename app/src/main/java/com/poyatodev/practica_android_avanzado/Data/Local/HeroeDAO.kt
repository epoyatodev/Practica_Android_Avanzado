package com.poyatodev.practica_android_avanzado.Data.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeroeDAO {
    @Query("SELECT * FROM heroes")
    fun getAll():List<LocalHeroe>

    @Query("SELECT * FROM heroes WHERE id = :heroeID")
    fun getHeroe(heroeID: String): LocalHeroe

    @Insert
    fun insertAllHeroes(heroesList: List<LocalHeroe>)

    //    @Update
    @Query("UPDATE heroes SET favorite=:isFav WHERE id=:herieId")
    fun updateHeroeFavStateLocal(herieId: String, isFav:Boolean)
}