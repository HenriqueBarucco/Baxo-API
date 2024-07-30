package com.henriquebarucco.baxoapi.infra.entrypoint.controller.auth.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class LoginRequest(
    @field:Email
    val email: String,
    @field:NotBlank @field:Size(min = 6, max = 32)
    val password: String,
)
