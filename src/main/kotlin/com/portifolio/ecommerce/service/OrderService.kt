package com.portifolio.ecommerce.service

import com.portifolio.ecommerce.controller.dto.CreateUserDto
import com.portifolio.ecommerce.entities.BillingAddressEntity
import com.portifolio.ecommerce.entities.UserEntity
import com.portifolio.ecommerce.repository.BillingAddressRepository
import com.portifolio.ecommerce.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService (private val userRepository: UserRepository,
                   private val billingAddressRepository: BillingAddressRepository) {


    fun  createUser(dto : CreateUserDto): UserEntity {

        var billingAddress = BillingAddressEntity().apply {
            address = dto.address
            number = dto.number
            complement = dto.complement
        }
        //var savedBillingAddress= billingAddressRepository.save(billingAddress)

        var userEntity = UserEntity().apply{
            fullName = dto.fullName
            //billingAddressEntity = savedBillingAddress
            billingAddressEntity = billingAddress
        }

        return userRepository.save(userEntity)
    }

    fun findById(userId: UUID): Optional<UserEntity> {
        return userRepository.findById(userId)
    }

    fun deleteById(userId: UUID): Boolean {

        //Pra funcionar, precisamos primeiro apagar o billingAddress e depois o usuário, pois existe uma dependencia entre as tabelas
        var user = userRepository.findById(userId)
        if (user.isPresent) {
            userRepository.deleteById(userId)
            //user.get().billingAddressEntity?.let { billingAddressRepository.deleteById(it.id) }
            //Com o CASCADE.ALL configurado, o JPA trata de fazer deleção da tabela filha.
        }
        return user.isPresent
    }
}