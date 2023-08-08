package com.example.callapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.callapi.data.repo.ListAPIRepository
import com.example.callapi.utils.Resource
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val viewModelModule = module {
    factory { ViewModelAPI(get()) }
}

class ViewModelAPI (private val lstAPIRepository: ListAPIRepository): ViewModel() {
    val getAPI = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = lstAPIRepository.getAPI()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }

    }
}