package com.henriquebarucco.baxoapi.domain.user.gateway

import com.henriquebarucco.baxoapi.domain.user.entity.User

interface FindUserByEmailGateway {
    fun find(email: String): User?
}
