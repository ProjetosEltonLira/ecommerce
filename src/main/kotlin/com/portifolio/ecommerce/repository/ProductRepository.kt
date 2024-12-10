package com.portifolio.ecommerce.repository

import com.portifolio.ecommerce.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository <UserEntity, UUID> {
}