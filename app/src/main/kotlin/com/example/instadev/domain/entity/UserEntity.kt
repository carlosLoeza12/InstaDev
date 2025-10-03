package com.example.instadev.domain.entity

data class UserEntity(
    val userId: String,
    val name: String,
    val nickName: String,
    val followers: Int,
    val following: List<String>,
    val userType: UserType
)

enum class UserType(val value: Int) {
    REGULAR_USER(0),
    CONTENT_CREATOR_USER(1),
    COMPANY_USER(2)
}
