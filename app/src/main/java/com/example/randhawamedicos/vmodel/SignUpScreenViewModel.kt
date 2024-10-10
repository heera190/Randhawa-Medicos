package com.example.randhawamedicos.vmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randhawamedicos.api.GetSignInResponse
import com.example.randhawamedicos.api.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class SignUpScreenViewModel : ViewModel() {

    var signInState = mutableStateOf("")

    init {
        signInState.value = LoginState.DEFAULT.lname
    }

    private val _signInResult = MutableLiveData<Response<GetSignInResponse>>()
    val signInResult : LiveData<Response<GetSignInResponse>> = _signInResult

    fun signIn(
        email: String,
        password: String
    ){

        Log.d("check1", "$email, $password")





    viewModelScope.launch {
        try{

            if (email.isNotEmpty() && password.isNotEmpty()) {

                signInState.value = LoginState.LOADING.lname
                val result = RetrofitInstance.api.signIn(email, password)
                Log.d("check2", result.toString())

                if (result.isSuccessful) {
                    signInState.value = LoginState.SUCCESS.lname
                    _signInResult.value = result
                } else {

                    _signInResult.value=  result
                    signInState.value = LoginState.ERROR.lname

                }
            } else {
                signInState.value = LoginState.EMPTY.lname

            }
        }catch (e: IOException){
            Log.d("check3", e.toString())
            signInState.value = LoginState.FAILED.lname
        }catch (e: HttpException){
            Log.d("check4", e.toString())
            signInState.value = LoginState.FAILED.lname
        }catch (e: Exception){
            Log.d("check5", e.toString())
            signInState.value = LoginState.FAILED.lname
        }
    }
}

    fun setSignInDefault(){
        signInState.value = LoginState.DEFAULT.lname
    }

    var state = mutableStateOf("")

    init {
        state.value = State.DEFAULT.name
    }

    fun setDefault() {
        state.value = State.DEFAULT.name
    }

    fun createUser(
        name: String,
        password: String,
        phone: String,
        email: String,
        pincode: String,
        address: String
    ) {

        if (name.isNotEmpty() && password.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty() && pincode.isNotEmpty() && address.isNotEmpty()) {
            state.value = State.LOADING.name
            viewModelScope.launch {

                val result = RetrofitInstance.api.createUser(
                    name = name,
                    password = password,
                    phone = phone,
                    email = email,
                    pin = pincode,
                    address = address
                )



                Log.d("Result", result.toString())

                if (result.isSuccessful) {
                    if (result.body()?.success == 200) {
                        state.value = State.SUCCESS.name
                    } else {
                        state.value = State.FAILED.name
                    }
                } else {
                    state.value = State.ERROR.name
                }


            }
        } else {
            state.value = State.EMPTY.name
        }
    }
}

sealed class State(var name: String) {
    object DEFAULT : State("Default")
    object LOADING : State("Loading")
    object SUCCESS : State("Success")
    object FAILED : State("Failed")
    object ERROR : State("ERROR")
    object EMPTY : State("Empty")
}

sealed class LoginState(var lname: String){
    object DEFAULT : LoginState("Default")
    object LOADING: LoginState("Loading")
    object SUCCESS : LoginState("Success")
    object FAILED : LoginState("Failed")
    object ERROR : LoginState("ERROR")
    object EMPTY : LoginState("Empty")
}

