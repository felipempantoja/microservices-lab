package com.in28minutes.microservices.limitsservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LimitsConfigurationResource(val configuration: Configuration) {

    @GetMapping("/limits")
    fun retrieveLimitsFromConfigurations(): LimitConfiguration {
        return LimitConfiguration(configuration.minimum, configuration.maximum)
    }
}