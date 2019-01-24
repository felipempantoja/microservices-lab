package com.in28minutes.microservices.limitsservice

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException

@RestController
class LimitsConfigurationResource(val configuration: Configuration) {

    @GetMapping("/limits")
    fun retrieveLimitsFromConfigurations(): LimitConfiguration {
        return LimitConfiguration(configuration.minimum, configuration.maximum)
    }

    @GetMapping("/limits-out")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveLimitsFromConfigurations")
    // it should delegate to fallbackRetrieveLimitsFromConfigurations method in case of error
    fun fallback(): LimitConfiguration {
        throw RuntimeException("not available")
    }

    fun fallbackRetrieveLimitsFromConfigurations(): LimitConfiguration = LimitConfiguration(10, 100)
}