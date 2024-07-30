package com.henriquebarucco.baxoapi.domain.product.interactor

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.user.entity.User

interface FetchProductsInteractor {
    fun execute(user: User): List<Product>
}
