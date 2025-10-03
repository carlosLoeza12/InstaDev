package com.example.instadev.domain.usecase

import com.example.instadev.domain.entity.UserEntity
import com.example.instadev.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(val authRepository: AuthRepository) {

    operator fun invoke(user: String, password: String) {

        val response: UserEntity = this.authRepository.doLogin(user = user, password = password)
    }
}