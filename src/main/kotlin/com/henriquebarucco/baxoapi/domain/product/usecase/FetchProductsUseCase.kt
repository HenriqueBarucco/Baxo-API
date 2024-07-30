package com.henriquebarucco.baxoapi.domain.product.usecase

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.product.gateway.FindProductsByUserGateway
import com.henriquebarucco.baxoapi.domain.product.interactor.FetchProductsInteractor
import com.henriquebarucco.baxoapi.domain.user.entity.User
import org.springframework.stereotype.Service

@Service
class FetchProductsUseCase(
    private val findProductsByUserGateway: FindProductsByUserGateway,
) : FetchProductsInteractor {
    override fun execute(user: User): List<Product> = this.findProductsByUserGateway.find(user)
}
