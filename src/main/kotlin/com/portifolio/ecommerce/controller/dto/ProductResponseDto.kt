package com.portifolio.ecommerce.controller.dto

import com.portifolio.ecommerce.entities.ProductEntity
import com.portifolio.ecommerce.entities.TagEntity


data class ProductResponseDto(
    val productId: Long ,
    var productName: String,
    var tags: List<TagResponseDto>
) {
    companion object {

        fun fromEntity(product: ProductEntity?): ProductResponseDto {
            return ProductResponseDto(
                productId = product!!.productId,
                productName = product.productName,
                tags = getTags(product.tags))
        }

        fun getTags(tags: List<TagEntity>): MutableList<TagResponseDto> {
            return tags.map { TagResponseDto.fromEntity(it) }.toMutableList()

        }
    }
}
