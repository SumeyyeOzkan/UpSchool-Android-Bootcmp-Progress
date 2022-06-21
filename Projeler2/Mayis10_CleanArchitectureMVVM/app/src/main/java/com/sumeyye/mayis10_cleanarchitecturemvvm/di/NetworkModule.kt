package com.sumeyye.mayis10_cleanarchitecturemvvm.di

import com.sumeyye.mayis10_cleanarchitecturemvvm.data.repository.ReatherRepositoryImp
import com.sumeyye.mayis10_cleanarchitecturemvvm.data.source.remote.ApiService
import com.sumeyye.mayis10_cleanarchitecturemvvm.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory):Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://api.weatherbit.io/v2.0/current/")
            .addConverterFactory(gsonConverterFactory)
            .build();
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(apiService: ApiService): WeatherRepository{
        return ReatherRepositoryImp(apiService)
    }

}