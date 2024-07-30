package com.henriquebarucco.baxoapi.domain.product.interactor

import com.henriquebarucco.baxoapi.domain.product.dto.CreateProductInput
import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.user.entity.User

interface CreateProductInteractor {
    fun execute(
        user: User,
        input: CreateProductInput,
    ): Product
}
