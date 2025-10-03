package com.example.instadev.data.repository

import com.example.instadev.data.repository.response.UserResponse
import com.example.instadev.data.repository.response.toDomain
import com.example.instadev.domain.entity.UserEntity
import com.example.instadev.domain.repository.AuthRepository

class AuthRepositoryImpl(): AuthRepository {

    override fun doLogin(user: String, password: String): UserEntity {

        val userReponse = UserResponse(
            userId = "1",
            name = "John Doe",
            nickName = "johndoe",
            followers = 100,
            following = listOf("2", "3"),
            userType = 0
        )

        return userReponse.toDomain()
    }
}