package com.bandtec.searchdevelopers.backend.adapter

data class CadastrarAdapter (

    val nameUser: String,
    // TODO verificar cpf e cnpj
    val cpf: String,
//    val cnpj: String,
    // TODO verificar tratamento melhor
    val birthDate: String,
    val email: String,
    val password: String,
    val role: String,
    val phone: String,

)