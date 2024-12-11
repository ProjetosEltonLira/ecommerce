package com.portifolio.ecommerce.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "tb_orders")
data class OrderEntity(

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderId: Long = -1,

    @Column(name = "total")
    var total: BigDecimal = BigDecimal.ZERO,

    @Column(name = "order_data")
    var orderData: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "user_id")
    var userEntity: UserEntity?,

    @OneToMany(mappedBy = "id.order", cascade = [CascadeType.ALL]) //Dentro do OrderitemEntity, tem o id, e dentro do id tem o order.
    var item: MutableList<OrderItemEntity>?

)