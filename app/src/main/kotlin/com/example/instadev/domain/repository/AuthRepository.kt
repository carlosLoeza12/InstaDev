package com.example.instadev.domain.repository

import com.example.instadev.domain.entity.UserEntity

interface AuthRepository {

    fun doLogin(user: String, password: String): UserEntity
}