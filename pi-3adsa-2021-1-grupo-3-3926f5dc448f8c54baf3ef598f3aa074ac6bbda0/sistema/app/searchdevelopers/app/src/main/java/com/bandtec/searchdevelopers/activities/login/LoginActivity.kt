package com.bandtec.searchdevelopers.activities.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import com.bandtec.searchdevelopers.R
import com.bandtec.searchdevelopers.backend.adapter.LoginAdapter
import com.bandtec.searchdevelopers.backend.repository.LoginRepository


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginTela(view: View) {
        val et_imput_email: EditText = findViewById(R.id.inputEmail)
        val et_imput_password: EditText = findViewById(R.id.inputSenha)

        val email: String = et_imput_email.text.toString()
        val password: String = et_imput_password.text.toString()

        val loginAdapter: LoginAdapter = LoginAdapter(
            email,
            password
        )

        val loginResitory: LoginRepository = LoginRepository(this)

        loginResitory.login(loginAdapter)
    }


}