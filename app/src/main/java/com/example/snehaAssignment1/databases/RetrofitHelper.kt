package com.example.snehaAssignment1.databases

import retrofit2.Retrofit
import  okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val baseUrl = "https://jsonplaceholder.typicode.com/"

    fun getInstance():Retrofit{
        val logging = HttpLoggingInterceptor()
// set your desired log level
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        // We need to prepare a custom OkHttp client because need to use our custom call interceptor.
        // to be able to authenticate our requests.
        val builder = OkHttpClient.Builder()
        // We add the interceptor to OkHttpClient.
        // It will add authentication headers to every call we make.
//       builder.interceptors().add(AuthenticationInterceptor())
        builder.interceptors().add(logging)
        val client = builder.build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

}