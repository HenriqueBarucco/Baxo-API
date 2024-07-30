package com.henriquebarucco.baxoapi.domain.product.usecase

import com.henriquebarucco.baxoapi.domain.product.dto.PublishProductInput
import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.product.gateway.PublishProductProcessGateway
import com.henriquebarucco.baxoapi.domain.product.interactor.PublishProductProcessInteractor
import org.springframework.stereotype.Service

@Service
class PublishProductProcessUseCase(
    private val publishProductProcessGateway: PublishProductProcessGateway,
) : PublishProductProcessInteractor {
    override fun execute(product: Product) {
        val input = PublishProductInput.fromDomain(product)
        this.publishProductProcessGateway.publish(input)
    }
}
