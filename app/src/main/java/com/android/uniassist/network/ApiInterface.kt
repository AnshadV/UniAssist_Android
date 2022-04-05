package com.android.uniassist.network

import com.android.uniassist.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("users/save")
    fun addUser(@Body userData: User): Call<User>

}