package com.example.randhawamedicos.screens

sealed class SpecificOrderState(var name: String) {

    data object LOADING : SpecificOrderState("Loading")
    data object SUCCESS : SpecificOrderState("Success")
    data object ERROR : SpecificOrderState("Error")
}