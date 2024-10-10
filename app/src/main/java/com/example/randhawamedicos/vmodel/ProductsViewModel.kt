package com.example.randhawamedicos.vmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randhawamedicos.api.GetAllProductsModel
import com.example.randhawamedicos.api.GetSignInResponse
import com.example.randhawamedicos.api.RetrofitInstance
import kotlinx.coroutines.launch

import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class ProductsViewModel : ViewModel() {

    private val _products = MutableLiveData<Response<GetAllProductsModel>>()
    val products : LiveData<Response<GetAllProductsModel>> = _products




    init {
        getProducts()
    }

  fun getProducts()  {
        viewModelScope.launch {

            try {
                val getProducts = RetrofitInstance.api.getAllProduct()

                if (getProducts != null) {
                    Log.d("Products1", getProducts.body().toString())
                    _products.value = getProducts
                }
                else{
                    _products.value = getProducts
                    Log.d("Products2", getProducts.toString())
                }
            }catch (e: IOException){
                    Log.d("Check1", e.toString())
            }catch (e: HttpException){
                Log.d("Check2", e.toString())
            }catch (e: Exception){
                Log.d("Check3", e.toString())
            }

        }



    }


}