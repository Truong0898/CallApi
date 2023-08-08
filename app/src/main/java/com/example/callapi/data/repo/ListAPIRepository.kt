package com.example.callapi.data.repo

import com.example.callapi.di.ListAPIService
import org.koin.dsl.module

val lstAPIModule = module {
    factory { ListAPIRepository(get()) }
}

class ListAPIRepository(private val listAPI: ListAPIService) {
    suspend fun getAPI() = listAPI.getAPI()
}