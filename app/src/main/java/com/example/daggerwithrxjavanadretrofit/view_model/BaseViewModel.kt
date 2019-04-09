package com.example.daggerwithrxjavanadretrofit.view_model

import android.arch.lifecycle.ViewModel
import com.example.daggerwithrxjavanadretrofit.component.DaggerViewModelInjector
import com.example.daggerwithrxjavanadretrofit.component.ViewModelInjector
import com.example.daggerwithrxjavanadretrofit.module.NetworkModule
import dagger.internal.DaggerCollections

abstract class BaseViewModel :ViewModel(){

    private val injector : ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when(this){
            is PostListViewModel -> injector.inject(this)
        }
    }

}