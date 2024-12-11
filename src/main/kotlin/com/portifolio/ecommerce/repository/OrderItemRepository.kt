package com.portifolio.ecommerce.repository

import com.portifolio.ecommerce.entities.OrderItemEntity
import com.portifolio.ecommerce.entities.OrderItemId
import com.portifolio.ecommerce.entities.ProductEntity
import com.portifolio.ecommerce.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface OrderItemRepository : JpaRepository <OrderItemEntity, OrderItemId> {
}