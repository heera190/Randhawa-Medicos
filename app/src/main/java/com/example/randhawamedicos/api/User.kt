package com.example.randhawamedicos.api

data class User(
    val approved: Int,
    val blocked: Int,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val pincode: String,
    val user_id: String
)