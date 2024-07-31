package com.henriquebarucco.baxoapi.infra.entrypoint.controller.product

import com.henriquebarucco.baxoapi.domain.product.interactor.CreateProductInteractor
import com.henriquebarucco.baxoapi.domain.product.interactor.PublishProductProcessInteractor
import com.henriquebarucco.baxoapi.infra.entrypoint.controller.AbstractUserContext
import com.henriquebarucco.baxoapi.infra.entrypoint.controller.product.dto.request.CreateProductRequest
import com.henriquebarucco.baxoapi.infra.entrypoint.controller.product.dto.response.CreateProductResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/products")
class CreateProductController(
    private val createProductInteractor: CreateProductInteractor,
    private val publishProductProcessInteractor: PublishProductProcessInteractor,
) : AbstractUserContext() {
    @PostMapping
    fun createProduct(
        @RequestBody @Valid createProductRequest: CreateProductRequest,
    ): ResponseEntity<CreateProductResponse> {
        val input = CreateProductRequest.toInput(createProductRequest)

        val product = this.createProductInteractor.execute(user, input)

        this.publishProductProcessInteractor.execute(product)

        val response = CreateProductResponse.fromDomain(product)
        return ResponseEntity.ok(response)
    }
}
