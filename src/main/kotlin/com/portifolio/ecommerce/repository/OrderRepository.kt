package com.portifolio.ecommerce.repository

import com.portifolio.ecommerce.entities.OrderEntity
import com.portifolio.ecommerce.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface OrderRepository : JpaRepository <OrderEntity, Long> {
}