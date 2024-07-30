package com.henriquebarucco.baxoapi.domain.product.usecase

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.product.gateway.FindProductByIdGateway
import com.henriquebarucco.baxoapi.domain.product.interactor.FindProductByIdInteractor
import org.springframework.stereotype.Service
import java.util.*

@Service
class FindProductByIdUseCase(
    private val findProductByIdGateway: FindProductByIdGateway,
) : FindProductByIdInteractor {
    override fun execute(id: UUID): Product = this.findProductByIdGateway.find(id) ?: throw RuntimeException("Product not found")
}
