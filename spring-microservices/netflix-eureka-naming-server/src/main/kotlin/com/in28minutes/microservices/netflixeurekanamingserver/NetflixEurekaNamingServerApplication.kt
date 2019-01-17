package com.in28minutes.microservices.netflixeurekanamingserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class NetflixEurekaNamingServerApplication

fun main(args: Array<String>) {
    runApplication<NetflixEurekaNamingServerApplication>(*args)
}

