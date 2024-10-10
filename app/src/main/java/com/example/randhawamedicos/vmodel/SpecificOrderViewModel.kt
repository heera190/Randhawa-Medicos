package com.example.randhawamedicos.vmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randhawamedicos.api.GetSpecificOrderResponse
import com.example.randhawamedicos.api.RetrofitInstance
import com.example.randhawamedicos.screens.SpecificOrderState
import kotlinx.coroutines.launch
import retrofit2.Response

class SpecificOrderViewModel : ViewModel() {

    val specificOrderState = mutableStateOf("")






    private val _apiResult = MutableLiveData<Response<GetSpecificOrderResponse>>() // Assuming the result is a list of users
    val apiResult: LiveData<Response<GetSpecificOrderResponse>> = _apiResult





    fun getSpecificOrder(
        user_id: String
    ){
        viewModelScope.launch {
            try {
                if (user_id.isNotEmpty()){
                    specificOrderState.value = SpecificOrderState.LOADING.name
                    val result = RetrofitInstance.api.getSpecificOrder(user_id)


                    if (result.isSuccessful){
                        specificOrderState.value = SpecificOrderState.SUCCESS.name
                        _apiResult.value = result
                        Log.d("SpecificOrder", "${result.body().toString()}")
                    }else{
                        specificOrderState.value = SpecificOrderState.ERROR.name
                    }
                    }
                 else{
                     specificOrderState.value = SpecificOrderState.ERROR.name
                 }
                }catch (e: Exception){
                    specificOrderState.value = SpecificOrderState.ERROR.name
                 }
            }




        }




    }
