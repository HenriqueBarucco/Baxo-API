package com.henriquebarucco.baxoapi.domain.product.gateway

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import java.util.UUID

interface FindProductByIdGateway {
    fun find(id: UUID): Product?
}
