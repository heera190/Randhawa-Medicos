package com.example.randhawamedicos.api

data class GetAllProductsModelItem(
    val category: String,
    val id: Int,
    val isActive: Int,
    val name: String,
    val price: Double,
    val stock: Int
)