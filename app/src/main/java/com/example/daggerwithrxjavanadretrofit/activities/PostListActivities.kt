package com.example.daggerwithrxjavanadretrofit.activities

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.daggerwithrxjavanadretrofit.R
import com.example.daggerwithrxjavanadretrofit.view_model.PostListViewModel
import kotlinx.android.synthetic.main.activity_posts.view.*

class PostListActivities : AppCompatActivity(){
    private  lateinit var binding : com.example.daggerwithrxjavanadretrofit.databinding.ActivityPostsBinding
    private lateinit var viewModel: PostListViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_posts)
        //binding.postList.layout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(PostListViewModel::class.java)
        binding.viewModel = viewModel


    }

}