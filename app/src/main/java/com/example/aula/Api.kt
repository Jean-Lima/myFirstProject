package com.example.aula

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {
    var url = "https://jsonplaceholder.typicode.com/"

    var retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}