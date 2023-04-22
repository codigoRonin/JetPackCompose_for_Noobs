package com.example.proyecto_instagram.login.data.network

import com.example.proyecto_instagram.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
   // suspend fun doLogin(user:String, password:String): Response<LoginResponse>
    suspend fun doLogin(): Response<LoginResponse> // Al no tener retrofit los datos se los quitamos para que  no pete
}