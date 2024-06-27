package com.example.mvpretrofitgrid.network

import com.example.mvpretrofitgrid.model.PicsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/list")
    fun getPictures():Call<PicsResponse>
}