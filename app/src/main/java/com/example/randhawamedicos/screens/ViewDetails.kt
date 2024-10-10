package com.example.randhawamedicos.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randhawamedicos.ui.theme.Custom1
import com.example.randhawamedicos.vmodel.ProductsViewModel
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.randhawamedicos.vmodel.OrderViewModel
import com.example.randhawamedicos.vmodel.SpecificOrderViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewDetails(
    name: String,
    email: String,
    phone: String,
    onGoBack: () -> Unit,
    productsViewModel: ProductsViewModel,
    onGoToProfile: () -> Unit,
    user_id: String,
    account_status: Int,
    pin: String,
    orderViewModel: OrderViewModel,
    onGoToOrderState: () -> Unit,
    specificOrderViewModel: SpecificOrderViewModel


) {


    val bottomNavItemList = listOf(
        BottomNavItems("Dashboard", Icons.Default.List),
        //BottomNavItems("Sales", Icons.Default.ThumbUp),
        BottomNavItems("Orders", Icons.Default.ShoppingCart),
        BottomNavItems("Profile", Icons.Default.Person),

        )

    var state = rememberSaveable { mutableStateOf(BottomNavSealed.Dashboard.name) }

    val specificOrderResult = rememberSaveable { mutableStateOf("") }
    val apiResult = specificOrderViewModel.apiResult.observeAsState()

    val orders = apiResult.value?.body()

    // state.value = BottomNavSealed.Dashboard.name


    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
            ) {
                bottomNavItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(


                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                            if (index == 0) {
                                state.value = BottomNavSealed.Dashboard.name
                            } //else if (index == 1) {
                            //state.value = BottomNavSealed.Sales.name }
                            else if (index == 1) {
                                state.value = BottomNavSealed.Orders.name
                                specificOrderViewModel.getSpecificOrder(user_id = user_id)

                            } else {
                                state.value = BottomNavSealed.Profile.name
                            }
                        },
                        icon = {


                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = "Icon",
                                tint = Custom1,

                                )

                        },
                        label = {
                            Text(
                                text = navItem.label,
                                color = Custom1
                            )
                        },
                        interactionSource = remember { MutableInteractionSource() }, // Disable ripple effect
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color(0xFFE0E0E0) // Remove the highlight color
                        )
                    )
                }

            }
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        )
        {
            Banner()
            when (state.value) {
                BottomNavSealed.Dashboard.name -> {


                    val getProducts = productsViewModel.products.observeAsState()

                    val getProductResponse = getProducts.value?.body()
                    val productName: List<String>? = getProductResponse?.map { it.name }
                    val productPrice: List<Double>? = getProductResponse?.map { it.price }


                    Log.d("ViewDetails1", getProducts.value?.body().toString())

                    val selectedText = rememberSaveable { mutableStateOf("Select Product") }
                    val selectedPrice = rememberSaveable { mutableStateOf(0.0) }
                    val expanded = rememberSaveable { mutableStateOf(false) }

                    val productQuantity = rememberSaveable { mutableStateOf("") }


                    ElevatedCard(modifier = Modifier.padding(8.dp)) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = Color.White)
                                .padding(horizontal = 20.dp, vertical = 10.dp)
                                .verticalScroll(rememberScrollState())


                        )

                        {

                            Text(
                                text = "Welcome, $name",
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp
                            )

                            Text(
                                text = "Your registered phone: $phone",
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontSize = 18.sp
                            )
                            Text(
                                text = "Please select the product you wish to purchase from the dropdown and proceed with your order.",
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontSize = 18.sp
                            )


                            ExposedDropdownMenuBox(
                                expanded = expanded.value,
                                onExpandedChange = { expanded.value = !expanded.value },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = Color.White)
                            ) {

                                TextField(
                                    modifier = Modifier
                                        .padding(bottom = 10.dp, start = 24.dp, end = 24.dp)
                                        .shadow(3.dp, RoundedCornerShape(50.dp))
                                        .background(Color.White, CircleShape)
                                        .menuAnchor(),

                                    shape = RoundedCornerShape(50.dp),
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = Color.Transparent,
                                        unfocusedBorderColor = Color.Transparent,
                                        unfocusedLeadingIconColor = Custom1,
                                        cursorColor = Custom1,
                                    ),

                                    value = selectedText.value,
                                    onValueChange = { selectedText.value = it },
                                    readOnly = true,
                                    trailingIcon = {
                                        ExposedDropdownMenuDefaults.TrailingIcon(
                                            expanded = expanded.value
                                        )
                                    })

                                ExposedDropdownMenu(
                                    expanded = expanded.value,
                                    onDismissRequest = { expanded.value = false },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(color = Color.White)
                                ) {

                                    productName?.forEachIndexed { index, text ->
                                        DropdownMenuItem(
                                            { Text(text = text) },
                                            onClick = {
                                                selectedText.value = productName[index]
                                                selectedPrice.value = productPrice!![index]
                                                expanded.value = false
                                            },
                                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                        )
                                    }

                                }


                            }

                            TextField(
                                value = productQuantity.value,
                                onValueChange = { productQuantity.value = it },
                                maxLines = 1,
                                label = {
                                    Text(
                                        text = "Quantity",
                                        modifier = Modifier.padding(start = 6.dp)
                                    )
                                },
                                shape = RoundedCornerShape(50.dp),
                                colors = OutlinedTextFieldDefaults.colors(

                                    focusedBorderColor = Color.Transparent,
                                    unfocusedBorderColor = Color.Transparent

                                ),
                                modifier = Modifier
                                    .padding(bottom = 10.dp, start = 24.dp, end = 24.dp)
                                    .shadow(3.dp, RoundedCornerShape(50.dp))
                                    .background(Color.White, CircleShape),
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Done
                                ),

                                )



                            Text(
                                text = "Total amount:  ${(productQuantity.value.toDoubleOrNull() ?: 0.0) * selectedPrice.value}",
                                fontSize = 22.sp,

                                modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
                            )

                            Button(
                                modifier = Modifier
                                    .padding(
                                        top = 20.dp,
                                        bottom = 10.dp,
                                        start = 24.dp,
                                        end = 24.dp
                                    )
                                    .fillMaxWidth()
                                    .height(55.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Custom1,
                                    contentColor = Color.White
                                ),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {

                                    orderViewModel.createOrder(
                                        productName = selectedText.value,
                                        price = selectedPrice.value.toString(),
                                        quantity = productQuantity.value,
                                        user_id = user_id


                                    )
                                    onGoToOrderState()


                                }) {

                                Text(
                                    text = "Place Order",
                                    color = Color.White,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }


                        }
                    }


                }

                BottomNavSealed.Orders.name -> {
                    if (orders != null) {
                        LazyColumn {
                            items(orders) {

                                OrderItems(orders = it)

                            }
                        }
                    }

                }

                BottomNavSealed.Profile.name -> {
                    ElevatedCard(modifier = Modifier.padding(8.dp)) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = Color.White)
                                .padding(horizontal = 20.dp, vertical = 10.dp)
                                .verticalScroll(rememberScrollState())


                        )

                        {

                            Text(
                                text = "Your Profile",
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp
                            )

                            Text(
                                text = "Name: $name",
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontSize = 18.sp
                            )

                            Text(
                                text = "User Id: $user_id",
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontSize = 18.sp
                            )

                            Text(
                                text = "Email Id: $email",
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontSize = 18.sp
                            )

                            Text(
                                text = "Phone Number: $phone",
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontSize = 18.sp
                            )

                            Text(
                                text = "Pin: $pin",
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontSize = 18.sp
                            )
                            Text(
                                text = "Account Status: ${if (account_status == 0) "Active" else "Inactive"}",
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontSize = 18.sp
                            )


                        }
                    }
                }

            }
        }
    }
}


