package com.example.mvpexample.network.api

import com.example.mvpexample.network.model.UniversityDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("")
    suspend fun getUniversity(
        @Query("country") country: String
    ): Response<List<UniversityDTO>>
}