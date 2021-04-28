package com.example.practica_clase_3

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface DogApi {

    @GET("/api/breeds/image/random")
    fun getDog() : Call<Dog>

    @POST
    fun setDog(dog : Dog) : Call<Dog>
}