package com.henriquebarucco.baxoapi.domain.product.gateway

import com.henriquebarucco.baxoapi.domain.product.entity.Product

interface UpdateProductPriceGateway {
    fun update(
        product: Product,
        price: Double,
    ): Product
}
