package com.poyatodev.practica_android_avanzado.Data.Remote

import com.squareup.moshi.Json

data class GetHeroesResponse(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "favorite") val favorite: Boolean,
    @Json(name = "description") val description: String,
    @Json(name = "photo") val photo: String,
)
