package com.example.cadastrosd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun voltarHome (v: View) {

    }

    fun cliqueiJuridica(v: View) {
        val cbFisica: CheckBox = findViewById(R.id.cb_fisica)
        val cbJuridica: CheckBox = findViewById(R.id.cb_juridica)

        cbFisica.setChecked(false)
        cbJuridica.setChecked(cbJuridica.isChecked)
    }

    fun cliqueiFisica(v: View) {
        val cbFisica: CheckBox = findViewById(R.id.cb_fisica)
        val cbJuridica: CheckBox = findViewById(R.id.cb_juridica)

        cbFisica.setChecked(cbFisica.isChecked)
        cbJuridica.setChecked(false)
    }


    fun handleCheckBox(v: View) {
        val checkBox: CheckBox = findViewById(R.id.cb_termo)
        val cbFisica: CheckBox = findViewById(R.id.cb_fisica)
        val cbJuridica: CheckBox = findViewById(R.id.cb_juridica)

        if(checkBox.isChecked && cbFisica.isChecked || cbJuridica.isChecked) {
            Toast.makeText(this, "CADASTRO FEITO COM SUCESSO", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
        } else{
            Toast.makeText(this, "FALTOU PREENCHER O CHECKBOX", Toast.LENGTH_SHORT).show()
        }

    }


}