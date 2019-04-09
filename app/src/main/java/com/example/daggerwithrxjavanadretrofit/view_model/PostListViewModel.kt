package com.example.daggerwithrxjavanadretrofit.view_model

import com.example.daggerwithrxjavanadretrofit.networking.PostApi
import javax.inject.Inject

class PostListViewModel: BaseViewModel() {

    @Inject
    lateinit var postApi: PostApi
}