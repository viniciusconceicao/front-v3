package com.bandtec.searchdevelopers.activities.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.bandtec.searchdevelopers.R
import com.bandtec.searchdevelopers.backend.adapter.CadastrarAdapter
import com.bandtec.searchdevelopers.backend.repository.CadastrarRepository
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.regex.Pattern

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //abaixo estou recebendo o tipo de cadastro (client ou dev) na variavel typeRegister
        val typeRegister  = intent.getStringExtra("typeRegister")
        Toast.makeText(this, "Esse cadastro é de um $typeRegister",
            Toast.LENGTH_SHORT).show()
    }

    var qualquerCoisa: Boolean = false

    var dadosValidos: Boolean = false


    fun registerValidation(v: View) {
        // import dos valores do input
        val edNome: EditText = findViewById(R.id.ed_nome)
        val edNasc: EditText = findViewById(R.id.ed_nasc)
        val edEmail: EditText = findViewById(R.id.ed_email)
        val edTelefone: EditText = findViewById(R.id.ed_telefone)
        val edSenha: EditText = findViewById(R.id.ed_senha)
        val edCpf: EditText = findViewById(R.id.ed_cpf)


        // conversão do valor do input para o tipo correto (strin, boolean, int)
        var nome = edNome.text.toString()
        var nasc = edNasc.text.toString()
        var email = edEmail.text.toString()
        var telefone = edTelefone.text.toString().toInt()
        var senha = edSenha.text.toString()
        var cpf = edCpf.text.toString()
        val checkBox: CheckBox = findViewById(R.id.cb_termo)

        // criação de variaveis para validação do cadastro
        var nomeVld = false
        var nascVld = false
        var emailVld = false
        var telefoneVld = false
        var senhaVld = false
        var cpfVld = isCPF(cpf)
        val validation = nomeVld && nascVld && emailVld &&
                telefoneVld && senhaVld && cpfVld && checkBox.isChecked


        // validação do NOME
        if(!TextUtils.isEmpty(nome)) {
            nomeVld = true
        } else {
            edNome.setError("Favor preencher um nome!")
            edNome.requestFocus()
        }

        // validação da DATA DE NASCIMENTO
//        val s = nasc
//        val df: DateFormat = SimpleDateFormat("dd/MM/yyyy")
//        df.setLenient(false) // aqui o pulo do gato
//        try {
//            df.parse(s)
//            nascVld = true
//        } catch (ex: ParseException) {
//            edNasc.setError("Favor preencher um e-mail Valido!")
//            edNasc.requestFocus()
//        }

        // validação do EMAIL
        if(!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailVld = true
        } else {
            edEmail.setError("Favor preencher um e-mail Valido!")
            edEmail.requestFocus()
        }

        // validação do CPF
        if(!isCPF(cpf)) {
            edCpf.setError("Favor preencher um CPF Valido!")
            edCpf.requestFocus()
        }

        // validação do celular




    }


    fun isCPF(document: String): Boolean {
        if (document.isEmpty()) return false

        val numbers = document.filter { it.isDigit() }.map {
            it.toString().toInt()
        }

        if (numbers.size != 11) return false

        //repeticao
        if (numbers.all { it == numbers[0] }) return false

        //digito 1
        val dv1 = ((0..8).sumOf { (it + 1) * numbers[it] }).rem(11).let {
            if (it >= 10) 0 else it
        }

        val dv2 = ((0..8).sumOf { it * numbers[it] }.let { (it + (dv1 * 9)).rem(11) }).let {
            if (it >= 10) 0 else it
        }

        return numbers[9] == dv1 && numbers[10] == dv2
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
            val intencao = Intent(this, FinishCadastro::class.java)
            intencao.putExtra("qualquercoisa", qualquerCoisa)
            startActivity(intencao)
//            startActivity(Intent(this, CadastroActivity::class.java))
        } else{
            Toast.makeText(this, "FALTOU PREENCHER O CHECKBOX", Toast.LENGTH_SHORT).show()
        }

    }

//    @RequiresApi(Build.VERSION_CODES.O)
//    fun cadastrar (v: View) {
//
//        val et_nome: EditText = findViewById(R.id.ti_nome)
//        val et_cpf: EditText = findViewById(R.id.ti_cpf)
//        val et_birth_date: EditText = findViewById(R.id.ti_nasc)
//        val et_email: EditText = findViewById(R.id.ti_email)
//        val et_password: EditText = findViewById(R.id.ti_senha)
//        val et_phone: EditText = findViewById(R.id.ti_telefone)
//
//        val nameUser: String = et_nome.text.toString()
//        val cpf: String = et_cpf.text.toString()
//
//        // TODO verificar tratamento melhor (yyyy-MM-dd String -> LocalDate)
//        val birthDate: String = et_birth_date.text.toString()
//        val email: String = et_email.text.toString()
//
//        // TODO verificar se é dev ou cliente
//        val role: String = "dev"
//        val password: String = et_password.text.toString()
//        val phone: String = et_phone.text.toString()
//
//        val cadastrarAdapter: CadastrarAdapter = CadastrarAdapter(
//            nameUser,
//            cpf,
//            birthDate,
//            email,
//            password,
//            role,
//            phone
//        )
//
//        val cadastrarRepository: CadastrarRepository = CadastrarRepository(this)
//
//        cadastrarRepository.cadastrar(cadastrarAdapter)
//    }


}