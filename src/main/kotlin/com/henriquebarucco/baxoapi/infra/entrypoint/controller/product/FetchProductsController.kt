package com.henriquebarucco.baxoapi.infra.entrypoint.controller.product

import com.henriquebarucco.baxoapi.domain.product.interactor.FetchProductsInteractor
import com.henriquebarucco.baxoapi.infra.entrypoint.controller.AbstractUserContext
import com.henriquebarucco.baxoapi.infra.entrypoint.controller.product.dto.response.ProductResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/products")
class FetchProductsController(
    private val fetchProductsInteractor: FetchProductsInteractor,
) : AbstractUserContext() {
    @GetMapping
    fun fetchProducts(): ResponseEntity<List<ProductResponse>> {
        val products = this.fetchProductsInteractor.execute(user)

        val response = products.map { ProductResponse.fromDomain(it) }
        return ResponseEntity.ok(response)
    }
}
