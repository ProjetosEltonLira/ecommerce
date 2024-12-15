package com.portifolio.ecommerce.controller.dto

import com.portifolio.ecommerce.entities.OrderEntity
import com.portifolio.ecommerce.entities.OrderItemEntity
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*


data class OrderResponseDto(
    val orderId: Long ,
    var total: BigDecimal,
    var orderData: LocalDateTime ,
    var user: UUID,
    var items : MutableList<OrderItemResponseDto>
){

    companion object {
        fun fromEntity(entity: Optional<OrderEntity>): OrderResponseDto {
            return OrderResponseDto(
                orderId = entity.get().orderId,
                total = entity.get().total,
                orderData = entity.get().orderData,
                user = entity.get().userEntity!!.userId,
                items = getItems(entity.get().item)
            )
        }

        private fun getItems(items: MutableList<OrderItemEntity>?): MutableList<OrderItemResponseDto> {
            return items?.map { OrderItemResponseDto.fromEntity(it) }?.toMutableList() ?: mutableListOf()
        }
    }
}
