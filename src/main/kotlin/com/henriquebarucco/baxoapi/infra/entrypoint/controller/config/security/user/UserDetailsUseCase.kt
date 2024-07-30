package com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.user

import com.henriquebarucco.baxoapi.domain.user.gateway.FindUserByEmailGateway
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsUseCase(
    private val findUserByEmailGateway: FindUserByEmailGateway,
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user =
            this.findUserByEmailGateway.find(username ?: throw RuntimeException("Usuário não encontrado."))
                ?: throw RuntimeException("Usuário não encontrado.")

        return UserDetail(user)
    }
}
