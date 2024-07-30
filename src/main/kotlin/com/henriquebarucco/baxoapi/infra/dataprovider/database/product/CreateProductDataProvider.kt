package com.henriquebarucco.baxoapi.infra.dataprovider.database.product

import com.henriquebarucco.baxoapi.domain.product.dto.CreateProductInput
import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.product.gateway.CreateProductGateway
import com.henriquebarucco.baxoapi.domain.user.entity.User
import com.henriquebarucco.baxoapi.infra.dataprovider.database.product.mapper.ProductEntityMapper
import com.henriquebarucco.baxoapi.infra.dataprovider.database.product.repository.ProductRepository
import com.henriquebarucco.baxoapi.infra.dataprovider.database.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class CreateProductDataProvider(
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository,
) : CreateProductGateway {
    override fun create(
        user: User,
        input: CreateProductInput,
    ): Product {
        val userEntity = this.userRepository.findById(user.id).orElseThrow { RuntimeException("User not found") }

        val productEntity =
            ProductEntityMapper.toEntity(
                input = input,
                userEntity = userEntity,
            )

        val productEntityCreated = this.productRepository.save(productEntity)

        return ProductEntityMapper.toDomain(productEntityCreated)
    }
}
