package com.portifolio.ecommerce.controller.dto

data class PaginationResponse(
    val page : Int,
    val pageSize : Int,
    val totalElements : Long,
    val totalPages : Int
)

