package com.henriquebarucco.baxoapi.domain.user.interactor

import com.henriquebarucco.baxoapi.domain.user.dto.CreateUserInput

interface CreateUserInteractor {
    fun execute(input: CreateUserInput)
}
