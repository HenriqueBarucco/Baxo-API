package com.henriquebarucco.baxoapi.infra.entrypoint.controller.auth.dto.response

import com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.jwt.Token

data class LoginResponse(
    val access: String,
    val expiresIn: Long,
) {
    companion object {
        fun fromDomain(token: Token) =
            LoginResponse(
                access = token.access,
                expiresIn = token.expiresIn,
            )
    }
}
