package com.portifolio.ecommerce.controller.dto


//Simplicamos o objeto, ao invés de criar um DTO BillingAdress e um User, os DTOs podem ter classes dentro de classes.
data class CreateUserDto(
    val fullName : String,
    val address : String,
    val number : String,
    val complement : String)
