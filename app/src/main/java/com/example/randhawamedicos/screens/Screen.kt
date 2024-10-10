package com.example.randhawamedicos.screens

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    data object SignUp : Screen

    @Serializable
    data object SignIn : Screen

    @Serializable
    data object Home : Screen

    @Serializable
    data object OrderState : Screen

    @Serializable
    data class ViewDetails(
        val name: String,
        val email: String,
        val phone: String,
        val user_id: String,
        val account_status: Int,
        val pin: String,

    ) : Screen

    @Serializable
    data class Profile(
        val name: String,
        val email: String,
        val phone: String,
        val city : String,
        val date : String,
        val pin : String,
        val user_id : String,
        val account_status: Int
    ) : Screen



}