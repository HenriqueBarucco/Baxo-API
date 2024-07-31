package com.henriquebarucco.baxoapi.infra.dataprovider.http.easywhatsapp.dto

data class MessageDto(
    val token: String,
    val phone: String,
    val message: String,
)
