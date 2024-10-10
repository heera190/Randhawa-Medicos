package com.example.randhawamedicos.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.randhawamedicos.api.GetSpecificOrderResponseItem
import com.example.randhawamedicos.ui.theme.Custom1

@Composable
fun OrderItems(
    orders: GetSpecificOrderResponseItem
) {

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .height(220.dp)
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 10.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {

                Text(
                    text = "Product Name",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = orders.product_name,
                    modifier = Modifier.padding(start = 10.dp)
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {

                Text(
                    text = "Price",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = orders.price.toString(),
                    modifier = Modifier.padding(start = 10.dp)
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {

                Text(
                    text = "Quantity",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = orders.quantity.toString(),
                    modifier = Modifier.padding(start = 10.dp)
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {

                Text(
                    text = "Order Date",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = orders.order_date,
                    modifier = Modifier.padding(start = 10.dp)
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {

                Text(
                    text = "Order Id",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = orders.order_id.toString(),
                    modifier = Modifier.padding(start = 10.dp)
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {

                Text(
                    text = "Total Price",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = (orders.price * orders.quantity.toDouble()).toString(),
                    modifier = Modifier.padding(start = 10.dp)
                )


            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center
            )
            {
                ElevatedButton(
                    onClick = { },
                    modifier = Modifier.width(150.dp).height(50.dp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(Custom1),

                    ) {

                    Text(text = "Cancel Order")

                }
            }


        }

    }

}