package com.example.randhawamedicos.screens

sealed class BottomNavSealed(var name: String) {

    object Dashboard: BottomNavSealed("Dashboard")
    //object Sales: BottomNavSealed("Sales")
    object Orders: BottomNavSealed("Orders")
    object Profile: BottomNavSealed("Profile")

}