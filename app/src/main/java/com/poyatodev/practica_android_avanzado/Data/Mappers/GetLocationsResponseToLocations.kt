package com.poyatodev.practica_android_avanzado.Data.Mappers

import com.poyatodev.practica_android_avanzado.Data.Remote.GetLocationsResponse
import com.poyatodev.practica_android_avanzado.UI.MainActivity.Model.Location
import javax.inject.Inject

class GetLocationsResponseToLocations @Inject constructor() {
    fun mapFromGetLocationsResponseToLocations(getLocationsResponseList: List<GetLocationsResponse>) : List<Location>{
        return getLocationsResponseList.map {mspFromGetLocationResponseToLocation(it)}
    }

    private  fun mspFromGetLocationResponseToLocation(getLocationResponse: GetLocationsResponse): Location {
        return Location(getLocationResponse.id, getLocationResponse.dateShow,getLocationResponse.latitud,getLocationResponse.longitud)
    }

}