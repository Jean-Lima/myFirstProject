package com.example.aula

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getList() : Call<List<PostModel>>
}