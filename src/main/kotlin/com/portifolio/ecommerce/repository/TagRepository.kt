package com.portifolio.ecommerce.repository

import com.portifolio.ecommerce.entities.*
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TagRepository : JpaRepository <TagEntity, Long> {
}