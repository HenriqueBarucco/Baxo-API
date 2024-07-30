package com.henriquebarucco.baxoapi.domain.product.dto

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import java.util.UUID

data class PublishProductInput(
    val id: UUID,
    val url: String,
) {
    companion object {
        fun fromDomain(product: Product): PublishProductInput =
            PublishProductInput(
                id = product.id,
                url = product.url,
            )
    }
}
