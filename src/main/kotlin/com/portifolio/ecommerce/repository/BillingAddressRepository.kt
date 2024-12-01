package com.portifolio.ecommerce.repository

import com.portifolio.ecommerce.entities.BillingAddressEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BillingAddressRepository : JpaRepository <BillingAddressEntity,Long> {
}