package com.henriquebarucco.baxoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BaxoApiApplication

fun main(args: Array<String>) {
    runApplication<BaxoApiApplication>(*args)
}
