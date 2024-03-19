package com.example.examapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Creating singleton,  instance with object -> don't have to instantiate when I use it
// Retrofit Instance,

// lazy -> creates only when it is calling


    object RetrofitInstance {
        private val urlAddress = "http://192.168.50.253:9000"
        val userApi: UserApi by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(urlAddress)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(UserApi::class.java)
        }


    }






    /*

    private val urlAddress = "http://192.168.50.253:9000"
    private lateinit var retrofit: Retrofit
    private lateinit var userApi: UserApi

    fun retrofitService(): Retrofit {

        initializeRetrofit()
       userApi = retrofit.create(UserApi::class.java)
        return retrofit
    }

    private fun initializeRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl(urlAddress)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

     */


