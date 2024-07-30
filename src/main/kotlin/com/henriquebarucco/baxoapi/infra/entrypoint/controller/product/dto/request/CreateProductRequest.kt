package com.henriquebarucco.baxoapi.infra.entrypoint.controller.product.dto.request

import com.henriquebarucco.baxoapi.domain.product.dto.CreateProductInput
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.URL

data class CreateProductRequest(
    @field:NotBlank @field:Size(min = 3, max = 100)
    val name: String,
    @field:URL
    val url: String,
) {
    companion object {
        fun toInput(request: CreateProductRequest): CreateProductInput =
            CreateProductInput(
                name = request.name,
                url = request.url,
            )
    }
}
