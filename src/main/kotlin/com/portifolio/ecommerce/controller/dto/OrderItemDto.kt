package com.portifolio.ecommerce.controller.dto


//Simplicamos o objeto, ao invés de criar um DTO BillingAdress e um User, os DTOs podem ter classes dentro de classes.
data class OrderItemDto(
    val quantity: Int,
    val productId : Long
)
