package com.bandtec.searchdevelopers.backend.repository

import android.content.Context
import android.widget.Toast
import com.bandtec.searchdevelopers.backend.adapter.LoginAdapter
import com.bandtec.searchdevelopers.backend.configuration.Constants
import com.bandtec.searchdevelopers.backend.configuration.RetrofitGeneric
import com.bandtec.searchdevelopers.backend.model.UsersDto
import com.bandtec.searchdevelopers.backend.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository (val context: Context){

    private val privateRetrofit = RetrofitGeneric.createService(UserService::class.java,Constants.URL.API_GODEV)

    fun login (user: LoginAdapter){
        val call: Call<UsersDto> = privateRetrofit.login(user)

        call.enqueue(object : Callback<UsersDto>{
            override fun onResponse(call: Call<UsersDto>, response: Response<UsersDto>) {
                if (response.code() == 200) {
                    Toast.makeText(context, "Usuário logado.", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(context,"Email ou Senha Inválidos.",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UsersDto>, t: Throwable) {
                Toast.makeText(context, "Servidor fora do ar.", Toast.LENGTH_SHORT).show()
            }
        })
    }

}