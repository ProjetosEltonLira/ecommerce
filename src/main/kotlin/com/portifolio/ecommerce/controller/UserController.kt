package com.portifolio.ecommerce.controller

import com.portifolio.ecommerce.controller.dto.CreateUserDto
import com.portifolio.ecommerce.entities.UserEntity
import com.portifolio.ecommerce.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.Objects.isNull
import java.util.Optional
import java.util.UUID

@RestController
@RequestMapping(path = ["/users"])
class UserController (
    private val userService: UserService){

    @PostMapping
    fun createUser(@RequestBody dto: CreateUserDto): ResponseEntity<Void> {

        var user = userService.createUser(dto)

        return ResponseEntity.created(URI.create("/users/${user.id}")).build()
    }

    @GetMapping(path =  ["/{userId}"])
    fun findById (@PathVariable userId: UUID): ResponseEntity<UserEntity>{
        var user : Optional<UserEntity> = userService.findById(userId)

        return if (isNull(userId))
            ResponseEntity.notFound().build()
        else
            ResponseEntity.ok(user.get())

    }

    @DeleteMapping(path =  ["/{userId}"])
    fun deleteById (@PathVariable userId: UUID): ResponseEntity<Void>{

        var deleted : Boolean = userService.deleteById(userId)

        return if (deleted)
            ResponseEntity.noContent().build()
        else
            ResponseEntity.notFound().build()
    }
}