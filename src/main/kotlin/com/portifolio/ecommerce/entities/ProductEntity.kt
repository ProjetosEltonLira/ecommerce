package com.portifolio.ecommerce.entities

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "tb_products")
data class ProductEntity (

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val productId: Long = -1,

    @Column(name = "product_name")
    var productName: String = "",

    @Column(name = "price")
    var price : BigDecimal = BigDecimal.ZERO,

    @ManyToMany
    @JoinTable(
        name = "tb_products_tags",
        joinColumns = [JoinColumn(name = "product_id")], // Coluna da tabela 'tb_products'
        inverseJoinColumns = [JoinColumn(name = "tag_id")], // Coluna da tabela 'tb_tags'
        uniqueConstraints = [UniqueConstraint(columnNames = ["product_id", "tag_id"])]
    )
    var tags : MutableList<TagEntity> = mutableListOf()
)
