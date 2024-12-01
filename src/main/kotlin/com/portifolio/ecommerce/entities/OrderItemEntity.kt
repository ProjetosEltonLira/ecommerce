package com.portifolio.ecommerce.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "tb_order_item")
data class OrderItemEntity(

    @EmbeddedId //indica chave primária composta.
    var id: OrderItemId = OrderItemId(),

    @Column(name = "sale_price")
    var salePrice: BigDecimal = BigDecimal.ZERO,

    @Column(name = "quantity")
    var quantity: Int = 0
)