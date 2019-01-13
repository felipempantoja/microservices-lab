package com.in28minutes.microservices.currencyconversionservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class CurrencyConversionResource(private val proxy: CurrencyExchangeServiceProxy) {

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    fun convertCurrency(@PathVariable from: String, @PathVariable to: String, @PathVariable quantity: BigDecimal): CurrencyConversionBean? {
        val currency: CurrencyConversionBean = proxy.retrieveExchangeValue(from, to)
        return CurrencyConversionBean(
                id = currency.id,
                from = from,
                to = to,
                quantity = quantity,
                conversionMultiple = currency.conversionMultiple,
                port = currency.port
        )
    }
}