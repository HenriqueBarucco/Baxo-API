package com.henriquebarucco.baxoapi.infra.dataprovider.database.product.entity

import com.henriquebarucco.baxoapi.infra.dataprovider.database.user.entity.UserEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.NotFound
import org.hibernate.annotations.NotFoundAction
import org.hibernate.annotations.SQLRestriction
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "products")
@SQLRestriction(value = "deleted_at IS NULL")
data class ProductEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val name: String,
    val url: String,
    val price: Double?,
    val enabled: Boolean,
    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false, updatable = false)
    val user: UserEntity,
    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime? = null,
    @Column(name = "deleted_at")
    val deletedAt: LocalDateTime? = null,
)
