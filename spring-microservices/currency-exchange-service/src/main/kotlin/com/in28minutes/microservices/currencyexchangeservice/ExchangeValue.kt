package com.in28minutes.microservices.currencyexchangeservice

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class ExchangeValue(
        @Id val id: Long = 0,
        @Column(name = "currency_from") val from: String = "",
        @Column(name = "currency_to") val to: String = "",
        val conversionMultiple: BigDecimal = BigDecimal.ZERO,
        val port: Int = 0
)
