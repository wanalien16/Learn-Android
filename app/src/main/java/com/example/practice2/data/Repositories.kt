package com.example.practice2.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Repositories(
    val author: String,
    val name: String,
    val avatar: String,
    val url: String

)

