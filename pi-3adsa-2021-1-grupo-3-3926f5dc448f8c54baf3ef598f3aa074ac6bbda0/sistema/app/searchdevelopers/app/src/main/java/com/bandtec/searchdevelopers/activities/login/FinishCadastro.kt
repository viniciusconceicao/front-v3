package com.bandtec.searchdevelopers.activities.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bandtec.searchdevelopers.R

class FinishCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_cadastro)
    }

    val dados = intent.extras
    val nome = dados!!.getString("qualquercoisa")
    var teste = nome.toBoolean()

    fun verificarCadastro(v:View) {
        if(true) {

        } else {
            val ivBackground: ImageView = findViewById(R.id.iv_background)
            val btBotao: Button = findViewById(R.id.bt_botao)
            val tvTexto: TextView = findViewById(R.id.tv_texto)

            ivBackground.setImageResource(R.drawable.fail)
            btBotao.setText("Voltar ao início")

            tvTexto.setText("Erro ao cadastrar seus dados!\n" +
                    "Tente novamente mais tarde.")
        }
    }


    fun rotaBotao(v:View) {
        val btBotao: Button = findViewById(R.id.bt_botao)
        if(btBotao.text.equals("Entrar")) {
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }

}