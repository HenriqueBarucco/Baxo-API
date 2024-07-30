package com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.jwt

data class Token(
    val access: String,
    val expiresIn: Long,
)
