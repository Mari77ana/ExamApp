package com.example.examapp.retrofit

import com.example.examapp.model.UserUiState
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {

    @GET("/user/get-all")
    suspend fun getAllUsers(): List<UserUiState>

    @GET("/user/get/{userId}")
    suspend fun getUserById(@Path("userId") userId: Int): UserUiState

    @POST("/user/save")
    suspend fun saveUser(@Body user: UserUiState): UserUiState


}