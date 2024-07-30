package com.henriquebarucco.baxoapi.domain.user.dto

data class CreateUserInput(
    val name: String,
    val email: String,
    val password: String,
    val phone: String,
)
