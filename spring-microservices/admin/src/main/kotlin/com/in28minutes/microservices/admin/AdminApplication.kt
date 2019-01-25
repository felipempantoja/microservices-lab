package com.in28minutes.microservices.admin

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableAdminServer
class AdminApplication

fun main(args: Array<String>) {
    runApplication<AdminApplication>(*args)
}

