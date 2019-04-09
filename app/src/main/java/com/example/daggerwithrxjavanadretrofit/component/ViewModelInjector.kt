package com.example.daggerwithrxjavanadretrofit.component

import com.example.daggerwithrxjavanadretrofit.module.NetworkModule
import com.example.daggerwithrxjavanadretrofit.view_model.PostListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(postListViewModel: PostListViewModel)

    @Component.Builder
    interface Builder{
        fun build() : ViewModelInjector

        fun networkModule(networkModule: NetworkModule) : Builder
    }

}