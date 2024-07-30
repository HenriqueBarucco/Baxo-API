package com.henriquebarucco.baxoapi.infra.entrypoint.controller.user.dto.request

import com.henriquebarucco.baxoapi.domain.user.dto.CreateUserInput
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateUserRequest(
    @field:NotBlank @field:Size(min = 3, max = 100)
    val name: String,
    @field:Email
    val email: String,
    @field:NotBlank @field:Size(min = 6, max = 32)
    val password: String,
    @field:NotBlank @field:Size(min = 13)
    val phone: String,
) {
    companion object {
        fun toInput(request: CreateUserRequest) =
            CreateUserInput(
                name = request.name,
                email = request.email,
                password = request.password,
                phone = request.phone,
            )
    }
}
