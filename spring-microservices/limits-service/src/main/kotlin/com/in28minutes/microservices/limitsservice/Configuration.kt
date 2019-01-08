package com.in28minutes.microservices.limitsservice

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("limits-service")
class Configuration {

    var minimum: Int = 0
    var maximum: Int = 0
}