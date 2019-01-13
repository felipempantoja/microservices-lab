package com.in28minutes.microservices.springcloudconfigserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCloudConfigServerApplication

fun main(args: Array<String>) {
	runApplication<SpringCloudConfigServerApplication>(*args)
}

