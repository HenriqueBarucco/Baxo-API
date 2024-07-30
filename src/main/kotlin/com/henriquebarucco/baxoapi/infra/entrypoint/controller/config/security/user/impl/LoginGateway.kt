package com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.user.impl

import com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.jwt.Token

interface LoginGateway {
    fun login(
        email: String,
        password: String,
    ): Token
}
