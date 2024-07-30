package com.henriquebarucco.baxoapi.infra.entrypoint.controller.auth

import com.henriquebarucco.baxoapi.domain.user.interactor.CreateUserInteractor
import com.henriquebarucco.baxoapi.infra.entrypoint.controller.auth.dto.request.RegisterRequest
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/auth")
class RegisterController(
    private val createUserInteractor: CreateUserInteractor,
) {
    @PostMapping("/register")
    fun register(
        @RequestBody @Valid registerRequest: RegisterRequest,
    ): ResponseEntity<Void> {
        val input = RegisterRequest.toInput(registerRequest)

        this.createUserInteractor.execute(input)

        return ResponseEntity.noContent().build()
    }
}
