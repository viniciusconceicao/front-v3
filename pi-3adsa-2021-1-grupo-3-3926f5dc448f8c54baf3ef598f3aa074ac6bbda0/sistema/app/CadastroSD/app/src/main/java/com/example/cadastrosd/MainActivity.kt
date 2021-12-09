package com.example.cadastrosd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    fun irTela2(v: View) {
//        startActivity(Intent(this, MainActivity2::class.java))
//    }

    fun souCliente(view: View) {
        startActivity(Intent(this, MainActivity2::class.java))
    }

    fun souProfissional (v: View) {
        startActivity(Intent(this, MainActivity2::class.java))
    }

    fun tenhoCadastro (v: View) {
        Toast.makeText(this, "Você já possui um CADASTRO!!", Toast.LENGTH_SHORT).show()
    }


}