package com.shaggy.gitkot.data.remote

import com.shaggy.gitkot.data.model.GitRepoList
import retrofit2.http.GET
import retrofit2.http.Query

interface Webservice {
    @GET("search/repositories")
    suspend fun getGitRepos(@Query("q") searchTerm: String): GitRepoList
}