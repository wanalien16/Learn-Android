package com.example.practice2.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Developers(val username: String,
                      val name: String?,
                      val avatar: String,
                      val url: String)
