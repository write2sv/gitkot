package com.shaggy.gitkot.repository

import com.shaggy.gitkot.data.remote.WebserviceBuilder.webservice

class GitRepoRepository {
    suspend fun getGitRepos(searchTerm: String) = webservice.getGitRepos(searchTerm)
}