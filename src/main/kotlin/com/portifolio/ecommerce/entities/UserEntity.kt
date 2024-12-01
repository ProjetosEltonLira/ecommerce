package com.portifolio.ecommerce.entities

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tb_users")
data class UserEntity(

    @Id
    @Column (name = "user_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    val userId: UUID,

    @Column (name = "full_name")
    var fullName:String,

    @OneToOne(fetch = FetchType.EAGER, cascade = [CascadeType.REMOVE,CascadeType.PERSIST]) //FetchTypy EAGER, garante que todas as classes que tem relacionamento sejam carregadas no GET
    @JoinColumn(name = "billing_adress_id")
    var billingAddressEntity: BillingAddressEntity?
){
    constructor() : this(
    userId = UUID.randomUUID(),
    fullName = "",
    billingAddressEntity = null
    )
}

