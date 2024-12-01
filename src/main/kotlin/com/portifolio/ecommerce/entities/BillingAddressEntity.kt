package com.portifolio.ecommerce.entities

import jakarta.persistence.*


@Entity
@Table(name = "tb_billing_adress")
data class BillingAddressEntity(

    @Id
    @Column(name = "billing_adress_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,

    @Column(name = "address")
    var address: String = "",

    @Column(name = "number")
    var number: String = "",

    @Column(name = "complement")
    var complement: String = "",

    //Esse mapeamento se chama BIDIRECIONAL, na pratica poucas vezes é utilizado, pois gera o problema do looping.
    //Com essas 2 linhas cria o looping no json, pois a billianAdress também tem usuário
    //@OneToOne(mappedBy = "billingAddressEntity") //Aqui diz que o dono da relação está na tabela de User, esse campo é opcional.
    //var user: UserEntity?

) {
    // Construtor vazio
    constructor() : this(
        id = -1,
        address = "",
        number = "",
        complement = "",
        //user = null
    )
}

