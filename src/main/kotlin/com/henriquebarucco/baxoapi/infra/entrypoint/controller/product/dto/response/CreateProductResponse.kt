package com.henriquebarucco.baxoapi.infra.entrypoint.controller.product.dto.response

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import java.util.UUID

data class CreateProductResponse(
    val id: UUID,
    val name: String,
    val url: String,
    val price: Double?,
    val enabled: Boolean,
) {
    companion object {
        fun fromDomain(product: Product): CreateProductResponse =
            CreateProductResponse(
                id = product.id,
                name = product.name,
                url = product.url,
                price = product.price,
                enabled = product.enabled,
            )
    }
}
