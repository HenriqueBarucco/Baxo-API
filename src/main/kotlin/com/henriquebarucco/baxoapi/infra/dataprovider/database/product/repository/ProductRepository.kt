package com.henriquebarucco.baxoapi.infra.dataprovider.database.product.repository

import com.henriquebarucco.baxoapi.infra.dataprovider.database.product.entity.ProductEntity
import com.henriquebarucco.baxoapi.infra.dataprovider.database.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProductRepository : JpaRepository<ProductEntity, UUID> {
    fun findAllByUser(user: UserEntity): List<ProductEntity>

    fun findAllByEnabledTrue(): List<ProductEntity>
}
