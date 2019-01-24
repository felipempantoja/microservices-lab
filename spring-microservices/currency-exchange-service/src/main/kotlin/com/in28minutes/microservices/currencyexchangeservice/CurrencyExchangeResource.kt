package com.in28minutes.microservices.currencyexchangeservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CurrencyExchangeResource(
        private val repository: ExchangeValueRepository,
        private val env: Environment) {

    val LOGGER: Logger = LoggerFactory.getLogger(CurrencyExchangeResource::class.java)

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    fun retrieveExchangeValue(@PathVariable from: String, @PathVariable to: String): ExchangeValue {
        LOGGER.info("Retrieving exchange value from {} to {}", from, to)
        val value = repository.findByFromAndTo(from, to)
        value.port = env.getProperty("server.port")!!.toInt()
        LOGGER.info("Value found: {}", value)
        return value
    }
}