package com.henriquebarucco.baxoapi.infra.dataprovider.database.product

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.product.gateway.FindProductByIdGateway
import com.henriquebarucco.baxoapi.infra.dataprovider.database.product.mapper.ProductEntityMapper
import com.henriquebarucco.baxoapi.infra.dataprovider.database.product.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class FindProductByIdDataProvider(
    private val productRepository: ProductRepository,
) : FindProductByIdGateway {
    override fun find(id: UUID): Product? {
        val productEntity = this.productRepository.findById(id).orElse(null)

        return productEntity?.let { ProductEntityMapper.toDomain(it) }
    }
}
