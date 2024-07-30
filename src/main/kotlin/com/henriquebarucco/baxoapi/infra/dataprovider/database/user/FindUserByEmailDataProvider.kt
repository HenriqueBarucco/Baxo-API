package com.henriquebarucco.baxoapi.infra.dataprovider.database.user

import com.henriquebarucco.baxoapi.domain.user.entity.User
import com.henriquebarucco.baxoapi.domain.user.gateway.FindUserByEmailGateway
import com.henriquebarucco.baxoapi.infra.dataprovider.database.user.mapper.UserEntityMapper
import com.henriquebarucco.baxoapi.infra.dataprovider.database.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class FindUserByEmailDataProvider(
    private val userRepository: UserRepository,
) : FindUserByEmailGateway {
    override fun find(email: String): User? {
        val userEntity = this.userRepository.findByEmail(email)
        return userEntity.map { UserEntityMapper.toDomain(it) }.orElse(null)
    }
}
