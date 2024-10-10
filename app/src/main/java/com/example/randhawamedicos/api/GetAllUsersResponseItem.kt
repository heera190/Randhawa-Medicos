package com.example.randhawamedicos.api

data class GetAllUsersResponseItem(
    val address: String,
    val approved: Int,
    val block: Int,
    val date_of_Account_Creation: String,
    val email: String,
    val id: Int,
    val level: Int,
    val name: String,
    val password: String,
    val phone: String,
    val pincode: String,
    val user_id: String
)