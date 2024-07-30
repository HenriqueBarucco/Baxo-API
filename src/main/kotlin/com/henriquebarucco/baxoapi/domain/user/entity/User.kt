package com.henriquebarucco.baxoapi.domain.user.entity

import java.util.UUID

data class User(
    val id: UUID,
    val name: String,
    val email: String,
    val phone: String,
)
