package com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security

import com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.jwt.JWTAuthenticationFilter
import com.henriquebarucco.baxoapi.infra.entrypoint.controller.config.security.jwt.JWTUtil
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtUtil: JWTUtil,
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.invoke {
            csrf { disable() }
            cors { disable() }
            authorizeRequests {
                authorize("/swagger-ui/**", permitAll)
                authorize("/actuator/**", permitAll)
                authorize("/v3/api-docs/**", permitAll)
                authorize(HttpMethod.POST, "/v1/auth/**", permitAll)
                authorize(anyRequest, authenticated)
            }
            addFilterBefore<UsernamePasswordAuthenticationFilter>(JWTAuthenticationFilter(jwtUtil = jwtUtil))
            sessionManagement {
                sessionCreationPolicy = SessionCreationPolicy.STATELESS
            }
            headers { frameOptions { disable() } }
        }
        return http.build()
    }

    @Bean
    fun encoder(): PasswordEncoder? = BCryptPasswordEncoder()
}
