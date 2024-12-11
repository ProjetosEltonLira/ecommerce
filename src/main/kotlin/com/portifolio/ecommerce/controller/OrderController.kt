package com.portifolio.ecommerce.controller

import com.portifolio.ecommerce.controller.dto.ApiResponse
import com.portifolio.ecommerce.controller.dto.CreateOrderDto
import com.portifolio.ecommerce.controller.dto.OrderSummaryDto
import com.portifolio.ecommerce.controller.dto.PaginationResponse
import com.portifolio.ecommerce.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(path = ["/orders"])
class OrderController (
    private val orderService: OrderService){

    @PostMapping
    fun createUser(@RequestBody dto: CreateOrderDto): ResponseEntity<Void> {

        var order = orderService.createOrder(dto)

        return ResponseEntity.created(URI.create("/orders/${order.orderId}")).build()
    }

    @GetMapping
    fun listOfOrder (@RequestParam(name = "page", defaultValue = "0") page : Int,
                     @RequestParam(name = "pageSize", defaultValue = "10") pageSize : Int): ResponseEntity<ApiResponse<OrderSummaryDto>>{

        var resp = orderService.findAll(page,pageSize)


        return ResponseEntity.ok(
            ApiResponse(
                data = resp.content,
                pagination = PaginationResponse(
                    page = resp.number,
                    pageSize= resp.size,
                    totalElements = resp.totalElements,
                    totalPages = resp.totalPages )
            ))
    }
}