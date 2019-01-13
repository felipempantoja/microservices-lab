package com.in28minutes.microservices.currencyconversionservice

import java.math.BigDecimal

data class CurrencyConversionBean(
        val id: Long,
        val from: String,
        val to: String,
        val conversionMultiple: BigDecimal,
        val quantity: BigDecimal = BigDecimal.ZERO,
        val port: Int
) {
    val totalCalculatedAmount: BigDecimal
        get() = quantity.multiply(conversionMultiple)
}
