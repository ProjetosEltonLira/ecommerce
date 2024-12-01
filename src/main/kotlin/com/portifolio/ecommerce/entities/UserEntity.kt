package com.portifolio.ecommerce.entities

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tb_users")
data class UserEntity(

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID ,

    @Column (name = "full_name")
    var fullName:String ,



    @OneToOne(fetch = FetchType.EAGER, cascade = [CascadeType.REMOVE,CascadeType.PERSIST]) //FetchTypy EAGER, garante que todas as classes que tem relacionamento sejam carregadas no GET
    @JoinColumn(name = "billing_adress_id")
    var billingAddressEntity: BillingAddressEntity?
){
    constructor() : this(
    id = UUID.randomUUID(),
    fullName = "",
    billingAddressEntity = null
    )
}

