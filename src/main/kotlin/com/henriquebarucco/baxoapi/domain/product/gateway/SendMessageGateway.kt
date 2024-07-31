package com.henriquebarucco.baxoapi.domain.product.gateway

interface SendMessageGateway {
    fun send(
        phone: String,
        message: String,
    )
}
