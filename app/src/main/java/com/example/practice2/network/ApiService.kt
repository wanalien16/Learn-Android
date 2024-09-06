package com.example.practice2.network

import com.example.practice2.data.Developers
import com.example.practice2.data.Repositories
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("developers")
   suspend fun getDevelopers(@Query("language")language: String): List<Developers>

   @GET("repositories")
   suspend fun getRepositories(@Query("language") language: String): List<Repositories>
}