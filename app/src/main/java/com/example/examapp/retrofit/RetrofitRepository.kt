package com.example.examapp.retrofit

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Creating singleton,  instance with object -> don't have to instantiate when I use it
// Retrofit Instance,

// lazy -> creates only when it is calling



    object RetrofitInstance {
        //private val urlAddress = "http://localhost:9000"
         private val urlAddress = "http://192.168.50.253:9000" //from home
       // private val urlAddress = "http://193.181.32.10:9000" // from Google search
        val userApi: UserApi by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(urlAddress)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(UserApi::class.java)
        }


    }



/*
class RetrofitRepository {
    companion object {
        private val urlAddress = "http://10.0.1.249:9000"

        fun createUserApi(): UserApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(urlAddress)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(UserApi::class.java)

        }

    }
}

 */






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


