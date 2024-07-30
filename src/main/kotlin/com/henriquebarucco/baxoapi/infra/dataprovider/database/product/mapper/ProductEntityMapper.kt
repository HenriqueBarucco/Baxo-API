package com.henriquebarucco.baxoapi.infra.dataprovider.database.product.mapper

import com.henriquebarucco.baxoapi.domain.product.dto.CreateProductInput
import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.infra.dataprovider.database.product.entity.ProductEntity
import com.henriquebarucco.baxoapi.infra.dataprovider.database.user.entity.UserEntity
import com.henriquebarucco.baxoapi.infra.dataprovider.database.user.mapper.UserEntityMapper

class ProductEntityMapper {
    companion object {
        fun toEntity(
            input: CreateProductInput,
            userEntity: UserEntity,
        ): ProductEntity =
            ProductEntity(
                name = input.name,
                url = input.url,
                price = null,
                enabled = true,
                user = userEntity,
            )

        fun toDomain(entity: ProductEntity): Product =
            Product(
                id = entity.id!!,
                name = entity.name,
                url = entity.url,
                price = entity.price,
                user = UserEntityMapper.toDomain(entity.user),
                enabled = entity.enabled,
            )
    }
}
