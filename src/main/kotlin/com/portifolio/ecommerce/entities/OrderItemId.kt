package com.portifolio.ecommerce.entities

import jakarta.persistence.Embeddable
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Embeddable
data class OrderItemId(

    @ManyToOne
    @JoinColumn(name = "order_id")
    var order: OrderEntity? = null, //Ideal para valores financeiros

    @ManyToOne
    @JoinColumn(name = "product_id")
    var product: ProductEntity? = null
)