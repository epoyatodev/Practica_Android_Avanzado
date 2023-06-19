package com.poyatodev.practica_android_avanzado.DI

import com.poyatodev.practica_android_avanzado.Data.Local.LocalDataSource
import com.poyatodev.practica_android_avanzado.Data.Local.LocalDataSourceImpl
import com.poyatodev.practica_android_avanzado.Data.Remote.RemoteDataSource
import com.poyatodev.practica_android_avanzado.Data.Remote.RemoteDataSourceImpl
import com.poyatodev.practica_android_avanzado.Data.Repository
import com.poyatodev.practica_android_avanzado.Data.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract  fun bindsRepository(repositoryImpl: RepositoryImpl): Repository


    @Binds
    abstract fun bindsLocalDataSource(localdataSource: LocalDataSourceImpl): LocalDataSource


    @Binds
    abstract fun bindsRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}