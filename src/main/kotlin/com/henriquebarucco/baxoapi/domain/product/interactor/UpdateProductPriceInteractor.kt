package com.henriquebarucco.baxoapi.domain.product.interactor

import java.util.UUID

interface UpdateProductPriceInteractor {
    fun execute(
        id: UUID,
        price: Double,
    )
}
