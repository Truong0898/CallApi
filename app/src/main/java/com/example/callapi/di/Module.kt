package com.example.callapi.di

import com.example.callapi.MyConstans
import com.example.callapi.data.entity.API
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

val networkModule = module {
    factory { provideListAPI(get()) }
    single { provideRetrofit() }

}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder().baseUrl(MyConstans.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}

interface ListAPIService {
    @Headers("Accept: application/json")
    @GET("9f84d8c9-6c66-448b-84d0-146d8c75e9fc")
    suspend fun getAPI(): API
}

fun provideListAPI(retrofit: Retrofit): ListAPIService = retrofit.create(ListAPIService::class.java)