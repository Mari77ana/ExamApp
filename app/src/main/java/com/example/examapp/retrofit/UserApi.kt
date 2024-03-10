package com.example.examapp.retrofit

import com.example.examapp.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @GET("/user/get-all")
    suspend fun getAllUsers(): List<User>

    @POST("/user/save")
    suspend fun saveUser(@Body user: User): User
}