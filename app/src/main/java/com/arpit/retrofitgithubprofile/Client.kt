package com.arpit.retrofitgithubprofile

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Client {

    val gson = GsonBuilder().create()

    val retrofit= Retrofit.Builder().baseUrl("https://api.github.com/users").addConverterFactory(GsonConverterFactory.create(gson)).build()

    val api = retrofit.create(RetrofitInterface::class.java)
}