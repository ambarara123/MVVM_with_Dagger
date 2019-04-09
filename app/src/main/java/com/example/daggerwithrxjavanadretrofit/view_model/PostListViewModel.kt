package com.example.daggerwithrxjavanadretrofit.view_model

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.example.daggerwithrxjavanadretrofit.networking.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel: BaseViewModel() {

    @Inject
    lateinit var postApi: PostApi

    private lateinit var subscription : Disposable

    val loadingVisibility : MutableLiveData<Int> = MutableLiveData()

    init {
        loadPosts()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadPosts() {
        subscription = postApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{onRetrievePostStart()}
                .doOnTerminate { onRetrievePostFinish() }
                .subscribe({onRetrievePostSuccess()},
                        {onRetrievePostError()})
    }

    private fun onRetrievePostError() {

    }

    private fun onRetrievePostSuccess() {

    }

    private fun onRetrievePostFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostStart() {
        loadingVisibility.value = View.VISIBLE

    }
}