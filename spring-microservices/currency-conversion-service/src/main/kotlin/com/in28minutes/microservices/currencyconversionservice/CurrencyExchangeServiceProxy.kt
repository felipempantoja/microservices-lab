package com.in28minutes.microservices.currencyconversionservice

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Service
@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    fun retrieveExchangeValue(
            @PathVariable("from") from: String,
            @PathVariable("to") to: String
    ): CurrencyConversionBean
}