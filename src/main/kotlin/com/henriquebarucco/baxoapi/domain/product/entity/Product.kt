package com.henriquebarucco.baxoapi.domain.product.entity

import com.henriquebarucco.baxoapi.domain.user.entity.User
import java.util.UUID

data class Product(
    val id: UUID,
    val name: String,
    val url: String,
    val price: Double?,
    val user: User,
    val enabled: Boolean,
)
