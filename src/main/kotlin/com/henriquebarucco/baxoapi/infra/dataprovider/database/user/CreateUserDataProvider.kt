package com.henriquebarucco.baxoapi.infra.dataprovider.database.user

import com.henriquebarucco.baxoapi.domain.user.dto.CreateUserInput
import com.henriquebarucco.baxoapi.domain.user.entity.User
import com.henriquebarucco.baxoapi.domain.user.gateway.CreateUserGateway
import com.henriquebarucco.baxoapi.infra.dataprovider.database.user.mapper.UserEntityMapper
import com.henriquebarucco.baxoapi.infra.dataprovider.database.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class CreateUserDataProvider(
    private val userRepository: UserRepository,
) : CreateUserGateway {
    override fun create(input: CreateUserInput): User {
        val userEntity = UserEntityMapper.toEntity(input)
        val savedUserEntity = this.userRepository.save(userEntity)

        return UserEntityMapper.toDomain(savedUserEntity)
    }
}
