package com.portifolio.ecommerce.controller.dto

import com.portifolio.ecommerce.entities.TagEntity
import com.portifolio.ecommerce.entities.UserEntity
import org.hibernate.query.Order
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.LongSummaryStatistics
import java.util.UUID


data class TagResponseDto(
    var tagId: Long,
    var name: String
) {
    companion object {
        fun fromEntity(entity: TagEntity): TagResponseDto {
            return TagResponseDto(
                tagId = entity.tagId,
                name = entity.tagName
            )
        }
    }

}
