package com.in28minutes.microservices.currencyconversionservice

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class CurrencyConversionResource(private val proxy: CurrencyExchangeServiceProxy) {

    val LOGGER: Logger = LoggerFactory.getLogger(CurrencyConversionResource::class.java)

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    @HystrixCommand(fallbackMethod = "fallbackConvertCurrency")
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

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    fun convertCurrencyFeign(@PathVariable from: String, @PathVariable to: String, @PathVariable quantity: BigDecimal): CurrencyConversionBean? {
        val currency: CurrencyConversionBean = proxy.retrieveExchangeValue(from, to)
        LOGGER.info("converting currency {}", currency)
        return CurrencyConversionBean(
                id = currency.id,
                from = from,
                to = to,
                quantity = quantity,
                conversionMultiple = currency.conversionMultiple,
                port = currency.port
        )
    }

    fun fallbackConvertCurrency(@PathVariable from: String, @PathVariable to: String, @PathVariable quantity: BigDecimal): CurrencyConversionBean = CurrencyConversionBean(
            id = 0,
            from = from,
            to = to,
            quantity = quantity,
            conversionMultiple = BigDecimal.ZERO,
            port = 0
    )
}