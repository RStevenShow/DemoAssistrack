package com.example.demoassistrack.api
import com.example.demoassistrack.Model.LoginRequest
import com.example.demoassistrack.Model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
}
