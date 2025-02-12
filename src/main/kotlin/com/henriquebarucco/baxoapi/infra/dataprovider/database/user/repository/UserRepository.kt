package com.henriquebarucco.baxoapi.infra.dataprovider.database.user.repository

import com.henriquebarucco.baxoapi.infra.dataprovider.database.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface UserRepository : JpaRepository<UserEntity, UUID> {
    fun findByEmail(email: String): Optional<UserEntity>
}
