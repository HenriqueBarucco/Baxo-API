package com.henriquebarucco.baxoapi.domain.product.interactor

import com.henriquebarucco.baxoapi.domain.product.entity.Product

interface NotifyProductPriceChangeInteractor {
    fun execute(
        product: Product,
        value: Double,
    )
}
