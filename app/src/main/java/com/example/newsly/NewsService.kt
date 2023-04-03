package com.example.newsly

import android.telecom.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=8997b4d55d5e427a910ec43150c1fedc

const val baseUrl="https://newsapi.org"
const val apiKey="8997b4d55d5e427a910ec43150c1fedc"

interface NewsInterface{

    @GET("/v2/top-headlines?apiKey=$apiKey")
    fun getHeadlines(@Query("country") country:String,@Query("page") page:Int): retrofit2.Call<News>
    //https://newsapi.org/v2/top-headlines?apiKey=8997b4d55d5e427a910ec43150c1fedc&country=in&page=1
}

object NewsService{
    val NewsInstance:NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        NewsInstance = retrofit.create(NewsInterface::class.java)
    }
}