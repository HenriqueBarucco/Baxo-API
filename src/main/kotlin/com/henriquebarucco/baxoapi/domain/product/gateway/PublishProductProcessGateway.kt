package com.henriquebarucco.baxoapi.domain.product.gateway

import com.henriquebarucco.baxoapi.domain.product.dto.PublishProductInput

interface PublishProductProcessGateway {
    fun publish(input: PublishProductInput)
}
