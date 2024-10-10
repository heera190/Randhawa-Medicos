package com.example.randhawamedicos.api

data class GetSpecificOrderResponseItem(
    val order_date: String,
    val order_id: Int,
    val price: Double,
    val product_name: String,
    val quantity: Int,
    val user_id: String
)