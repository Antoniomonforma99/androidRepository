package com.antoniomontero.listadoactores.retrofit

import com.antoniomontero.listadoactores.poko.ActorResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ActorService {

    @GET("actor")
    fun getActorList(@Query("offset") paramOffset : String,
                       @Query("limit") paramLimit: String) : Call<ActorResponse>
}