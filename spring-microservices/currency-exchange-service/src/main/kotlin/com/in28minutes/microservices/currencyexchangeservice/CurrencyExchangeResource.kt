package com.in28minutes.microservices.currencyexchangeservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CurrencyExchangeResource(
        private val repository: ExchangeValueRepository) {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    fun retrieveExchangeValue(@PathVariable from: String, @PathVariable to: String): ExchangeValue {
        return repository.findByFromAndTo(from, to)
//        )
    }
}