package com.bandtec.searchdevelopers.backend.service

import com.bandtec.searchdevelopers.backend.adapter.CadastrarAdapter
import com.bandtec.searchdevelopers.backend.adapter.LoginAdapter
import com.bandtec.searchdevelopers.backend.configuration.Constants
import com.bandtec.searchdevelopers.backend.model.UsersDto
import retrofit2.Call
import retrofit2.http.*

interface UserService {

    @Headers(Constants.HEADERS.JSON)
    @POST("api/users/authenticate")
    fun login (@Body login: LoginAdapter): Call<UsersDto>

    @Headers(Constants.HEADERS.JSON)
    @POST("api/users/")
    fun postUser (@Body user: CadastrarAdapter): Call<Void>

    @Headers(Constants.HEADERS.JSON)
    @GET("api/users/")
    fun getAllUser (@Body user: UsersDto): Call<List<UsersDto>>

    @Headers(Constants.HEADERS.JSON)
    @GET("api/users/{id}")
    fun getIdUser (@Path("id") id: Int): Call<UsersDto>

}