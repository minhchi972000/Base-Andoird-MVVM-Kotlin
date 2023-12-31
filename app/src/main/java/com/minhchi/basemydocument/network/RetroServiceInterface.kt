package com.minhchi.basemydocument.network

import com.minhchi.basemydocument.model.RepositoriesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

    @GET("repositories")
    fun getDataFromAPI(@Query("q") query: String): Call<RepositoriesList>
}