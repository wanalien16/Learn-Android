package com.example.practice2.network

import com.example.practice2.data.Developers
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("developers")
   suspend fun getDevelopers(@Query("language")language: String): List<Developers>
}