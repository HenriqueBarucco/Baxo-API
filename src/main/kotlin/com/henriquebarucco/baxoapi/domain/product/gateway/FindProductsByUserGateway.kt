package com.henriquebarucco.baxoapi.domain.product.gateway

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.user.entity.User

interface FindProductsByUserGateway {
    fun find(user: User): List<Product>
}
