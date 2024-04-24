package com.example.fiapp.domain.model

data class User(
    val id: UserId,
)

data class UserId(
    val value: Int,
)