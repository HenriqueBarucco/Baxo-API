package com.henriquebarucco.baxoapi.infra.entrypoint.controller

import com.henriquebarucco.baxoapi.domain.user.entity.User
import com.henriquebarucco.baxoapi.domain.user.gateway.FindUserByEmailGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder

abstract class AbstractUserContext {
    @Autowired
    private lateinit var findUserByEmailGateway: FindUserByEmailGateway

    protected val user: User
        get() = fetchUser()

    private fun fetchUser(): User {
        val email = SecurityContextHolder.getContext().authentication.name
        return this.findUserByEmailGateway.find(email) ?: throw RuntimeException("Not authenticated")
    }
}
