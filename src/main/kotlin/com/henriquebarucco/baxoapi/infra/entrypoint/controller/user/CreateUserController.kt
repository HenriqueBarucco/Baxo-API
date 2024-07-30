package com.henriquebarucco.baxoapi.infra.entrypoint.controller.user

import com.henriquebarucco.baxoapi.domain.user.interactor.CreateUserInteractor
import com.henriquebarucco.baxoapi.infra.entrypoint.controller.user.dto.request.CreateUserRequest
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user")
class CreateUserController(
    private val createUserInteractor: CreateUserInteractor,
) {
    @PostMapping
    fun createUser(
        @RequestBody @Valid createUserRequest: CreateUserRequest,
    ): ResponseEntity<Void> {
        val input = CreateUserRequest.toInput(createUserRequest)

        this.createUserInteractor.execute(input)

        return ResponseEntity.noContent().build()
    }
}
