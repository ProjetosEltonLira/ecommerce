package com.portifolio.ecommerce.controller.dto

import com.portifolio.ecommerce.entities.OrderItemEntity
import com.portifolio.ecommerce.entities.UserEntity
import org.hibernate.query.Order
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID


data class OrderItemResponseDto(

    var salePrice: BigDecimal,
    var quantity: Int,
    var product: ProductResponseDto
){
    companion object {
        fun fromEntity(entity: OrderItemEntity) : OrderItemResponseDto{
            return OrderItemResponseDto(
                entity.salePrice,
                entity.quantity,
                ProductResponseDto.fromEntity(entity.id.product)
            )
        }
    }
}
