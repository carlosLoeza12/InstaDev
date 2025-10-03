package com.example.instadev.data.repository.response

import com.example.instadev.domain.entity.UserEntity
import com.example.instadev.domain.entity.UserType

data class UserResponse(
    val userId: String,
    val name: String,
    val nickName: String,
    val followers: Int,
    val following: List<String>,
    val userType: Int
)

fun UserResponse.toDomain(): UserEntity {

    val userType: UserType = when (this.userType) {

        UserType.REGULAR_USER.value -> UserType.REGULAR_USER
        UserType.CONTENT_CREATOR_USER.value -> UserType.CONTENT_CREATOR_USER
        UserType.COMPANY_USER.value -> UserType.COMPANY_USER
        else -> UserType.REGULAR_USER
    }

    return UserEntity(
        userId = userId,
        name = name,
        nickName = nickName,
        followers = followers,
        following = following,
        userType = userType
    )
}
