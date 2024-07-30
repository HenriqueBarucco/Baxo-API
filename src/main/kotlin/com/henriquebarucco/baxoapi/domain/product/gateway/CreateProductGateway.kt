package com.henriquebarucco.baxoapi.domain.product.gateway

import com.henriquebarucco.baxoapi.domain.product.dto.CreateProductInput
import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.user.entity.User

interface CreateProductGateway {
    fun create(
        user: User,
        input: CreateProductInput,
    ): Product
}
