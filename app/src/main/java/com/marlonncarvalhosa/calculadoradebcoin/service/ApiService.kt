package com.marlonncarvalhosa.calculadoradebcoin.service

import com.marlonncarvalhosa.calculadoradebcoin.responce.CoinResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("countries")
    fun list(): Call<List<CoinResponse>>
}