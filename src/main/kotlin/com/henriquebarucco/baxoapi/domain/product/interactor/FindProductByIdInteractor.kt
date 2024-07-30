package com.henriquebarucco.baxoapi.domain.product.interactor

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import java.util.UUID

interface FindProductByIdInteractor {
    fun execute(id: UUID): Product
}
