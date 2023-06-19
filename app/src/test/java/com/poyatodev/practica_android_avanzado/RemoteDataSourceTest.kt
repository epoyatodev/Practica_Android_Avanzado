package com.poyatodev.practica_android_avanzado

import com.poyatodev.practica_android_avanzado.Data.Remote.RemoteDataSourceImpl
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RemoteDataSourceTest: BaseNetworkMockTest() {

    @Test
    fun `WHEN performing performLogin EXPECT successful response AND a token`() = runTest {
        //GIVEN:
        val remoteDataSource = RemoteDataSourceImpl(api)

        //WHEN:
        val token = remoteDataSource.performLogin("Basic ....")

        //Expect
        assert(token.isNotEmpty())
    }

    @Test
    fun `When retrieving locations Expect successful response And a locations list`() = runTest {
        //Given:
        val remoteDataSource = RemoteDataSourceImpl(api)
        remoteDataSource.token = "ajsjaskajs"

        //When:
        val locations = remoteDataSource.retrieveHeroeLocations("adkahduhadwawjdhnal")

        //Expect:
        assert(locations.size == 2)
        assert(locations[0].id.isNotEmpty())
    }
}