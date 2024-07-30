package com.henriquebarucco.baxoapi.domain.product.usecase

import com.henriquebarucco.baxoapi.domain.product.gateway.FindProductByIdGateway
import com.henriquebarucco.baxoapi.domain.product.gateway.UpdateProductPriceGateway
import com.henriquebarucco.baxoapi.domain.product.interactor.UpdateProductPriceInteractor
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UpdateProductPriceUseCase(
    private val findProductByIdGateway: FindProductByIdGateway,
    private val updateProductPriceGateway: UpdateProductPriceGateway,
) : UpdateProductPriceInteractor {
    override fun execute(
        id: UUID,
        price: Double,
    ) {
        val product = this.findProductByIdGateway.find(id) ?: throw RuntimeException("Product not found")

        this.updateProductPriceGateway.update(product, price)
    }
}
