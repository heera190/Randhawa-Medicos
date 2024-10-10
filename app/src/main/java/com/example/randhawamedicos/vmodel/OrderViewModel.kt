package com.example.randhawamedicos.vmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randhawamedicos.api.RetrofitInstance
import com.example.randhawamedicos.screens.OrderStateClass
import kotlinx.coroutines.launch

class OrderViewModel : ViewModel() {

    val orderState = mutableStateOf("")



    fun createOrder(
        productName: String,
        price: String,
        quantity: String,
        user_id: String
    ) {

        Log.d("check1", "$productName, $price, $quantity, $user_id")

        viewModelScope.launch {
            try {
                if (productName.isNotEmpty() && price.isNotEmpty() && quantity.isNotEmpty() && user_id.isNotEmpty()) {
                    orderState.value = OrderStateClass.LOADING.name
                    val result = RetrofitInstance.api.createOrder(
                        user_id,
                        productName,
                        price.toFloat(),
                        quantity.toInt()
                    )

                    if (result.isSuccessful){
                        orderState.value = OrderStateClass.SUCCESS.name
                    }else{
                        orderState.value = OrderStateClass.ERROR.name
                    }
                } else {
                    orderState.value = OrderStateClass.ERROR.name
                    }

                }catch (e: Exception){
                    Log.d("check2", e.toString())
                    orderState.value = OrderStateClass.ERROR.name
                }
            }
        }

    }



