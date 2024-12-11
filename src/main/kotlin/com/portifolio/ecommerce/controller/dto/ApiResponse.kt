package com.portifolio.ecommerce.controller.dto

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class OrderSummaryDto(
    val orderId: Long,
    val orderDate : LocalDateTime,
    val userId : UUID,
    val total : BigDecimal
)
