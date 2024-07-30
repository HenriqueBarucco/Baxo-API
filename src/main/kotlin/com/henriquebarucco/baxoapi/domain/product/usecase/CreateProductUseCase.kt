package com.henriquebarucco.baxoapi.domain.product.usecase

import com.henriquebarucco.baxoapi.domain.product.dto.CreateProductInput
import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.product.gateway.CreateProductGateway
import com.henriquebarucco.baxoapi.domain.product.interactor.CreateProductInteractor
import com.henriquebarucco.baxoapi.domain.user.entity.User
import org.springframework.stereotype.Service

@Service
class CreateProductUseCase(
    private val createProductGateway: CreateProductGateway,
) : CreateProductInteractor {
    override fun execute(
        user: User,
        input: CreateProductInput,
    ): Product = this.createProductGateway.create(user, input)
}
