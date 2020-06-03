package com.example.aula

import com.google.gson.annotations.SerializedName

class PostModel(
    @SerializedName("userId")
    var userId: Int? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("body")
    var body: String? = null


)
