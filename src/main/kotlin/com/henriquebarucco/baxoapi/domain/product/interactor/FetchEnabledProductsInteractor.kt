package com.henriquebarucco.baxoapi.domain.product.interactor

import com.henriquebarucco.baxoapi.domain.product.entity.Product

interface FetchEnabledProductsInteractor {
    fun execute(): List<Product>
}
