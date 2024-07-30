package com.henriquebarucco.baxoapi.infra.entrypoint.controller.auth

import com.henriquebarucco.baxoapi.infra.entrypoint.controller.auth.dto.request.LoginRequest
import com.henriquebarucco.baxoapi.infra.entrypoint.controller.auth.dto.response.LoginResponse
import com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.user.impl.LoginGateway
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/auth")
class LoginController(
    private val loginGateway: LoginGateway,
) {
    @PostMapping("/login")
    fun login(
        @RequestBody @Valid loginRequest: LoginRequest,
    ): ResponseEntity<LoginResponse> {
        val (email, password) = loginRequest
        val login = this.loginGateway.login(email, password)

        return ResponseEntity.ok(LoginResponse.fromDomain(login))
    }
}
