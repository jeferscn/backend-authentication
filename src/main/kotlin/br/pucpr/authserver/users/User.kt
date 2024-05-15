package br.pucpr.authserver.users

class User(
    var id: Long? = null,
    val email: String = String(),
    val password: String = String(),
    val name: String = String()
)