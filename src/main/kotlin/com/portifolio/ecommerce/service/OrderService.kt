package com.portifolio.ecommerce.service

import com.portifolio.ecommerce.controller.dto.CreateOrderDto
import com.portifolio.ecommerce.controller.dto.OrderItemDto
import com.portifolio.ecommerce.controller.dto.OrderSummaryDto
import com.portifolio.ecommerce.entities.*
import com.portifolio.ecommerce.exception.CreateOrderException
import com.portifolio.ecommerce.repository.OrderItemRepository
import com.portifolio.ecommerce.repository.OrderRepository
import com.portifolio.ecommerce.repository.ProductRepository
import com.portifolio.ecommerce.repository.UserRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import java.util.function.Supplier

@Service
class OrderService (private val userRepository: UserRepository,
                    private val orderRepository: OrderRepository,
                    private val productRepository: ProductRepository) {

    fun  createOrder(dto : CreateOrderDto): OrderEntity {

        val order = OrderEntity(
            userEntity = null,
            item = null
        )
        // validar se o usuário existe.
        var user = validateUser(dto)

        // validar que os item existem na base.
        var listOrderItem = validateOrderItem(order, dto)

        // calcular o valor total do produto.
        var total = calculateOrderTotal(listOrderItem)

        // Map to entity
        order.orderData = LocalDateTime.now()
        order.userEntity = user
        order.total =  total
        order.item = listOrderItem

        return orderRepository.save(order)

    }

    private fun calculateOrderTotal(items: MutableList<OrderItemEntity>): BigDecimal {
        return items.sumOf { it.salePrice.multiply(BigDecimal.valueOf(it.quantity.toLong())) }
    }

    private fun validateOrderItem(order: OrderEntity, dto: CreateOrderDto): MutableList<OrderItemEntity> {

        if(dto.items.isEmpty()){
            throw CreateOrderException("Ordem items is empty")
        }

        return dto.items
            .stream()
            .map { orderItemDto -> getOrderItem(order, orderItemDto) }
            .toList()
    }

    fun getOrderItem(order: OrderEntity, orderItemDto: OrderItemDto): OrderItemEntity{

        var productFound = getProduct(orderItemDto.productId)
        val orderItemId = OrderItemId(order, productFound)

        var orderItemEntity = OrderItemEntity(orderItemId, productFound!!.price, orderItemDto.quantity )

        return orderItemEntity
    }

    fun getProduct(productId: Long): ProductEntity? {

        return productRepository.findById(productId)
            .orElseThrow(Supplier { CreateOrderException("product not found") })
    }

    fun validateUser(dto: CreateOrderDto): UserEntity{

        return userRepository.findById(dto.userId)
            .orElseThrow { CreateOrderException("user not found") }
    }

    fun findAll(page: Int, pageSize: Int): Page<OrderSummaryDto> {
        return orderRepository.findAll(PageRequest.of(page,pageSize))
            .map( { OrderSummaryDto(it.orderId,it.orderData,it.userEntity!!.userId,it.total)})
        
    }

}