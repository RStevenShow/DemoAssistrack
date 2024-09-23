package com.example.demoassistrack.api
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "https://10.0.2.2:7011/api/Login"

    //https://localhost:7011/api/Login
    //private const val BASE_URL = "https://localhost:7011"

    //private const val BASE_URL = "192.168.13.139"
    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)  // Tiempo de espera de conexión
        .readTimeout(30, TimeUnit.SECONDS)     // Tiempo de espera de lectura
        .writeTimeout(30, TimeUnit.SECONDS)    // Tiempo de espera de escritura
        .build()


    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }



}
