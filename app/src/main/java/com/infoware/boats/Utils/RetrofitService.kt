package com.infoware.boats.Utils

import com.infoware.boats.mainUI.models.boatDetailsModel.BoatDetailsModel
import com.infoware.boats.mainUI.models.BoatsModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

val client = OkHttpClient.Builder().build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("http://dev.infoware.xyz:8000/api/cruise/")
    .client(client)
    .build()

interface ApiService{

    @GET("list-cruises/29723f1f-fd67-4942-916f-b1ab87b6e93b/7")
    @Headers("isGuest:true","Accept-Lang:en")
    fun getCruiseList():Call<BoatsModel>

    @GET("get-cruise/{key}")
    @Headers("isGuest:true","Accept-Lang:en")
    fun getCruiseDetails(@Path("key", encoded = true) key:String):Call<BoatDetailsModel>

}

object RetrofitApiService{
    val retrofitService:ApiService = retrofit.create(ApiService::class.java)
}