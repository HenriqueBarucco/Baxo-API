package com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.jwt

import com.henriquebarucco.baxoapi.domain.user.gateway.FindUserByEmailGateway
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.security.Key
import java.util.Date
import java.util.concurrent.TimeUnit

@Component
class JWTUtil(
    private val findUserByEmailGateway: FindUserByEmailGateway,
) {
    @Value("\${jwt.secret}")
    private lateinit var accessSecret: String

    @Value("\${jwt.expiration}")
    private lateinit var accessExpiration: String

    fun generateToken(email: String): Token =
        Token(
            access = generate(email, accessSecret, accessExpiration),
            expiresIn = Date(System.currentTimeMillis() + parseTimeStringToMillis(accessExpiration)).time,
        )

    private fun generate(
        email: String,
        secret: String,
        expiration: String,
    ): String =
        Jwts
            .builder()
            .subject(email)
            .signWith(getSigningKey(secret))
            .expiration(Date(System.currentTimeMillis() + parseTimeStringToMillis(expiration)))
            .compact()

    fun isValid(jwt: String?): Boolean =
        try {
            Jwts
                .parser()
                .verifyWith(Keys.hmacShaKeyFor(this.accessSecret.toByteArray(StandardCharsets.UTF_8)))
                .build()
                .parseSignedClaims(jwt)

            true
        } catch (e: Exception) {
            false
        }

    fun getAuthentication(jwt: String?): Authentication {
        val email =
            Jwts
                .parser()
                .verifyWith(
                    Keys.hmacShaKeyFor(this.accessSecret.toByteArray()),
                ).build()
                .parseSignedClaims(jwt)
                .payload
                .subject
        val user = this.findUserByEmailGateway.find(email) ?: throw RuntimeException("User not found")
        return UsernamePasswordAuthenticationToken(user.email, null, null)
    }

    private fun getSigningKey(secret: String): Key {
        val keyBytes = secret.toByteArray(StandardCharsets.UTF_8)
        return Keys.hmacShaKeyFor(keyBytes)
    }

    private fun parseTimeStringToMillis(timeString: String): Long {
        val regex = Regex("(\\d+)([dhms])")
        val matchResult = regex.find(timeString)

        if (matchResult != null) {
            val (value, unit) = matchResult.destructured
            val timeValue = value.toLong()

            return when (unit) {
                "d" -> TimeUnit.DAYS.toMillis(timeValue)
                "h" -> TimeUnit.HOURS.toMillis(timeValue)
                "m" -> TimeUnit.MINUTES.toMillis(timeValue)
                "s" -> TimeUnit.SECONDS.toMillis(timeValue)
                else -> throw IllegalArgumentException("Unsupported time unit: $unit")
            }
        } else {
            throw IllegalArgumentException("Invalid time string format: $timeString")
        }
    }
}
