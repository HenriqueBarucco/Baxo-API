package com.henriquebarucco.baxoapi.infra.dataprovider.database.product

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.product.gateway.FindProductsByUserGateway
import com.henriquebarucco.baxoapi.domain.user.entity.User
import com.henriquebarucco.baxoapi.infra.dataprovider.database.product.mapper.ProductEntityMapper
import com.henriquebarucco.baxoapi.infra.dataprovider.database.product.repository.ProductRepository
import com.henriquebarucco.baxoapi.infra.dataprovider.database.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class FindProductsByUserDataProvider(
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository,
) : FindProductsByUserGateway {
    override fun find(user: User): List<Product> {
        val userEntity = this.userRepository.findById(user.id).orElseThrow { RuntimeException("User not found") }
        val productEntityList = this.productRepository.findAllByUser(userEntity)

        return productEntityList.map { ProductEntityMapper.toDomain(it) }
    }
}
