package com.example.randhawamedicos.screens

sealed class OrderStateClass(var name: String) {
   // data object DEFAULT : OrderStateClass("Default")
    data object LOADING : OrderStateClass("Loading")
    data object SUCCESS : OrderStateClass("Success")
    data object ERROR : OrderStateClass("Error")
}