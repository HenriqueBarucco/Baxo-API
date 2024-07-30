package com.henriquebarucco.baxoapi.infra.dataprovider.database.user.mapper

import com.henriquebarucco.baxoapi.domain.user.dto.CreateUserInput
import com.henriquebarucco.baxoapi.domain.user.entity.User
import com.henriquebarucco.baxoapi.infra.dataprovider.database.user.entity.UserEntity

class UserEntityMapper {
    companion object {
        fun toEntity(input: CreateUserInput): UserEntity =
            UserEntity(
                name = input.name,
                email = input.email,
                password = input.password,
                phone = input.phone,
            )

        fun toDomain(entity: UserEntity): User =
            User(
                id = entity.id!!,
                name = entity.name,
                email = entity.email,
                phone = entity.phone,
            )
    }
}
