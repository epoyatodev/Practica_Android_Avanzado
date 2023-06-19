package com.poyatodev.practica_android_avanzado

import com.poyatodev.practica_android_avanzado.Data.Remote.DragonBallApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class BaseNetworkMockTest {
    lateinit var api: DragonBallApi
    private lateinit var mockWebServer: MockWebServer
    private val moshi =  Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()


    @Before
    fun setup(){
        //SetUp mockwebserver
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = DragonBallApiMockDispatcher()
        mockWebServer.start()
        //Setup API call
        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()
            .create(DragonBallApi::class.java)
    }

    @After
    fun tearDown(){
        //Remove the mockserver to save resources.
        mockWebServer.shutdown()
    }

}