package com.henriquebarucco.baxoapi.infra.dataprovider.database.product

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.product.gateway.UpdateProductPriceGateway
import com.henriquebarucco.baxoapi.infra.dataprovider.database.product.mapper.ProductEntityMapper
import com.henriquebarucco.baxoapi.infra.dataprovider.database.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class UpdateProductPriceDataProvider(
    private val productRepository: ProductRepository,
) : UpdateProductPriceGateway {
    override fun update(
        product: Product,
        price: Double,
    ): Product {
        val productEntity = this.productRepository.findById(product.id).orElseThrow { RuntimeException("Product not found") }

        productEntity.price = price
        val productEntityUpdated = this.productRepository.save(productEntity)

        return ProductEntityMapper.toDomain(productEntityUpdated)
    }
}
