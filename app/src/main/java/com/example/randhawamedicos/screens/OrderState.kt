package com.example.randhawamedicos.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randhawamedicos.R
import com.example.randhawamedicos.ui.theme.Custom1
import com.example.randhawamedicos.vmodel.OrderViewModel
import com.example.randhawamedicos.vmodel.State

@Composable
fun OrderState(
    orderViewModel: OrderViewModel,
    onGoBack: () -> Boolean,
    onGoToViewDetails: () -> Unit
){
    val orderState = rememberSaveable { mutableStateOf("") }

    orderState.value = orderViewModel.orderState.value

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ){

            Banner()

    when(orderState.value){

        OrderStateClass.LOADING.name -> {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )  {

                CircularProgressIndicator()

            }

        }

        OrderStateClass.SUCCESS.name -> {

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                item {
                    Image(
                        painter = painterResource(R.drawable.congratulation),
                        contentDescription = "congratulation"
                    )
                }
                item {
                    Text(
                        text = "Order Placed Successfully!",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(20.dp),
                        textAlign = TextAlign.Center
                    )
                }
                item{
                    Button(
                        modifier = Modifier
                            .padding(vertical = 20.dp, horizontal = 16.dp)
                            .fillMaxWidth()
                            .height(55.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Custom1,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(10.dp),
                        onClick = {
                            onGoBack()
                        }) {
                        Text(text = "Go Back",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold

                        )
                    }
                }
            }

        }

        OrderStateClass.ERROR.name -> {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )  {

                Text(text = "Error Occurred")
                Button(onClick = { onGoToViewDetails() }) {
                    
                }

            }

        }


    }


}
        }}