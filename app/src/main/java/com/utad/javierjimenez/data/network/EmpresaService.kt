package com.utad.javierjimenez.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface EmpresaService {
    @GET("task/{nombre del departamento}")
    suspend fun getHomeWork(
        @Header("Javier")userName: String,
        @Path("empresa")empresa:String
    ): Response<List<EmpresaResponseItem>>
}