package com.henriquebarucco.baxoapi.domain.product.usecase

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.product.gateway.FindEnabledProductsGateway
import com.henriquebarucco.baxoapi.domain.product.interactor.FetchEnabledProductsInteractor
import org.springframework.stereotype.Service

@Service
class FetchEnabledProductsUseCase(
    private val findEnabledProductsGateway: FindEnabledProductsGateway,
) : FetchEnabledProductsInteractor {
    override fun execute(): List<Product> = this.findEnabledProductsGateway.find()
}
