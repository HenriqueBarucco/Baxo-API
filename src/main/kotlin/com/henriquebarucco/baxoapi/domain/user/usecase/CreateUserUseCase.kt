package com.henriquebarucco.baxoapi.domain.user.usecase

import com.henriquebarucco.baxoapi.domain.user.dto.CreateUserInput
import com.henriquebarucco.baxoapi.domain.user.gateway.CreateUserGateway
import com.henriquebarucco.baxoapi.domain.user.interactor.CreateUserInteractor
import org.springframework.stereotype.Service

@Service
class CreateUserUseCase(
    private val createUserGateway: CreateUserGateway,
) : CreateUserInteractor {
    override fun execute(input: CreateUserInput) {
        this.createUserGateway.create(input)
    }
}
