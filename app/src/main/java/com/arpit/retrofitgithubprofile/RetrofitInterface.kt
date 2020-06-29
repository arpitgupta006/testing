package com.arpit.retrofitgithubprofile

import com.arpit.retrofitgithubprofile.Model
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("arpitgupta006")
    suspend fun getUser():Response<Model>
}