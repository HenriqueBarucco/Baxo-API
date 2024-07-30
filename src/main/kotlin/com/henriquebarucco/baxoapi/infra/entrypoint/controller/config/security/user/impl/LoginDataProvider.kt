package com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.user.impl

import com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.jwt.JWTUtil
import com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.jwt.Token
import com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.user.UserDetail
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class LoginDataProvider(
    private val auth: AuthenticationConfiguration,
    private val jwtUtil: JWTUtil,
) : LoginGateway {
    override fun login(
        email: String,
        password: String,
    ): Token {
        try {
            val authenticationToken =
                UsernamePasswordAuthenticationToken(
                    email,
                    password,
                )

            val authentication: Authentication = auth.authenticationManager.authenticate(authenticationToken)
            val user = (authentication.principal as UserDetail).getUser()

            return this.jwtUtil.generateToken(user.email)
        } catch (e: Exception) {
            throw RuntimeException("Usuário ou senha inválidos.")
        }
    }
}
