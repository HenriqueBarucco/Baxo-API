package com.henriquebarucco.baxoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@EnableFeignClients
@EnableScheduling
@SpringBootApplication
class BaxoApiApplication

fun main(args: Array<String>) {
    runApplication<BaxoApiApplication>(*args)
}
