package com.shaggy.gitkot.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shaggy.gitkot.R
import com.shaggy.gitkot.data.remote.utils.Status
import com.shaggy.gitkot.databinding.ActivityHomeBinding
import com.shaggy.gitkot.viewmodel.HomeViewModel
import com.shaggy.gitkot.viewmodel.factory.GitKotViewModelFactory

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var repositoryListAdapter: RepositoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, GitKotViewModelFactory()).get(HomeViewModel::class.java)
        repositoryListAdapter = RepositoryListAdapter()

        binding.recyclerViewRepoList.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewRepoList.adapter = repositoryListAdapter

        observeForDataChanges()
    }

    private fun observeForDataChanges() {
        viewModel.getRepositories().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.ERROR -> {
                        binding.isLoading = false
                    }
                    Status.LOADING -> {
                        binding.isLoading = true
                    }
                    Status.SUCCESS -> {
                        binding.isLoading = false

                        resource.data?.let { gitRepoList -> repositoryListAdapter.setData(gitRepoList.items)  }
                    }
                }
            }
        })
    }



}
