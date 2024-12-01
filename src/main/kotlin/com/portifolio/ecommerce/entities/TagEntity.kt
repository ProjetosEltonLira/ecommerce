package com.portifolio.ecommerce.entities

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tb_tags")
data class TagEntity(

    @Id
    @Column (name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val tagId: Long,

    @Column (name = "tag_name", unique = true)
    var tagName:String,
)

