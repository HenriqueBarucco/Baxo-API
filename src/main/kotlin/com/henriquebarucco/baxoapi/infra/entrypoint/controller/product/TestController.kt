package com.henriquebarucco.baxoapi.infra.entrypoint.controller.product

import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/products")
class TestController {
    @GetMapping
    fun createProduct(): ResponseEntity<Void> {
        val email = SecurityContextHolder.getContext().authentication.name

        println(email)

        return ResponseEntity.noContent().build()
    }
}
