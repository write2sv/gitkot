package com.shaggy.gitkot.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebserviceBuilder {
    val webservice: Webservice = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(Webservice::class.java)
}
