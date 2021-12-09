package com.bandtec.searchdevelopers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.view.View
import com.bandtec.searchdevelopers.activities.login.CadastroActivity
import com.bandtec.searchdevelopers.activities.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    fun goToRegister(botao: View) {
        //cria uma variavel para guardar o tipo de cadastro(dev ou client) e envia pelo puExtra
        var register = ""
        when (botao.id) {
            R.id.bt_cliente -> register = "client"
            R.id.bt_profissional -> register = "dev"
        }
        val cadastro = (Intent(this, CadastroActivity::class.java))
        cadastro.putExtra("typeRegister", register)
        startActivity(cadastro)
    }

    fun tenhoCadastro (v: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }




}