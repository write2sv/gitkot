package com.shaggy.gitkot.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shaggy.gitkot.repository.GitRepoRepository
import com.shaggy.gitkot.viewmodel.HomeViewModel

class GitKotViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(GitRepoRepository()) as T
        }
        throw IllegalArgumentException("GitKot Factory: Unknown ViewModel class")
    }
}