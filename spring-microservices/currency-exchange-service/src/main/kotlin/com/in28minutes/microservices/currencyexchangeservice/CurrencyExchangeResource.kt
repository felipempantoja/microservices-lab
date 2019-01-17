package com.in28minutes.microservices.currencyexchangeservice

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CurrencyExchangeResource(
        private val repository: ExchangeValueRepository,
        private val env: Environment) {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    fun retrieveExchangeValue(@PathVariable from: String, @PathVariable to: String): ExchangeValue {
        val value = repository.findByFromAndTo(from, to)
        value.port = env.getProperty("server.port")!!.toInt()
        return value
//        )
    }
}