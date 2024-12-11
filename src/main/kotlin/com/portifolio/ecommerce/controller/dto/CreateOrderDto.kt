package com.portifolio.ecommerce.controller.dto

import java.util.UUID


//Simplicamos o objeto, ao invés de criar um DTO BillingAdress e um User, os DTOs podem ter classes dentro de classes.
data class CreateOrderDto(
    val userId : UUID,
    val items : MutableList<OrderItemDto>,
)
