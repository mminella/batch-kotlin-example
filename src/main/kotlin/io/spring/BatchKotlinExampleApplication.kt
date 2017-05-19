package io.spring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class BatchKotlinExampleApplication

fun main(args: Array<String>) {
    SpringApplication.run(BatchKotlinExampleApplication::class.java, *args)
}
