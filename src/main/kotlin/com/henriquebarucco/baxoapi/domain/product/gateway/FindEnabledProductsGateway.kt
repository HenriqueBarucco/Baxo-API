package com.henriquebarucco.baxoapi.domain.product.gateway

import com.henriquebarucco.baxoapi.domain.product.entity.Product

interface FindEnabledProductsGateway {
    fun find(): List<Product>
}
