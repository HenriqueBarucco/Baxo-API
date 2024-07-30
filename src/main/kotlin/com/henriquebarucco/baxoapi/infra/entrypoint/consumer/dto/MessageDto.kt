package com.henriquebarucco.baxoapi.infra.entrypoint.consumer.dto

import java.util.UUID

data class MessageDto(
    val id: UUID,
    val value: Double,
)
