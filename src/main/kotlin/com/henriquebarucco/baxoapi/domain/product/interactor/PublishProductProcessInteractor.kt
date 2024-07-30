package com.henriquebarucco.baxoapi.domain.product.interactor

import com.henriquebarucco.baxoapi.domain.product.entity.Product

interface PublishProductProcessInteractor {
    fun execute(product: Product)
}
