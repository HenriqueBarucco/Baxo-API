package com.henriquebarucco.baxoapi.infra.dataprovider.database.product

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.product.gateway.FindEnabledProductsGateway
import com.henriquebarucco.baxoapi.infra.dataprovider.database.product.mapper.ProductEntityMapper
import com.henriquebarucco.baxoapi.infra.dataprovider.database.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class FindEnabledProductsDataProvider(
    private val productRepository: ProductRepository,
) : FindEnabledProductsGateway {
    override fun find(): List<Product> {
        val productEntityList = this.productRepository.findAllByEnabledTrue()

        return productEntityList.map { ProductEntityMapper.toDomain(it) }
    }
}
