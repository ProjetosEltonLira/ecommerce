package com.portifolio.ecommerce.controller.dto

import java.util.*

data class ApiResponse<T>(
    val data : MutableList<T>,
    val pagination: PagitionResponse
)

