package com.shaggy.gitkot.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.shaggy.gitkot.repository.GitRepoRepository
import com.shaggy.gitkot.data.remote.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class HomeViewModel(private val gitRepoRepository: GitRepoRepository): ViewModel() {
    fun getRepositories() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))

        try {
            emit(Resource.success(gitRepoRepository.getGitRepos("language:kotlin stars:>=10000")))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Unexpected error"))
        }
    }
}