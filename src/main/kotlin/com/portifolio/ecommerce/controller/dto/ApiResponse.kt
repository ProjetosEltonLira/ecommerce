package com.portifolio.ecommerce.controller.dto

data class ApiResponse<T>(
    val data : MutableList<T>,
    val pagination: PaginationResponse
)

