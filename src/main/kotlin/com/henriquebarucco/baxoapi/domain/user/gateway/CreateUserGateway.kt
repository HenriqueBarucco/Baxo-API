package com.henriquebarucco.baxoapi.domain.user.gateway

import com.henriquebarucco.baxoapi.domain.user.dto.CreateUserInput
import com.henriquebarucco.baxoapi.domain.user.entity.User

interface CreateUserGateway {
    fun create(input: CreateUserInput): User
}
