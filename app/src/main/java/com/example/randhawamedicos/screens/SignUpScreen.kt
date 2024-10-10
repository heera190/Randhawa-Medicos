package com.example.randhawamedicos.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randhawamedicos.R
import com.example.randhawamedicos.ui.theme.Custom1
import com.example.randhawamedicos.vmodel.SignUpScreenViewModel
import com.example.randhawamedicos.vmodel.State

@Composable


fun SignUpScreen(
    onGoToNextScreen: () -> Unit,
    viewModel: SignUpScreenViewModel,
    onGoToHomeScreen: () -> Unit
) {

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {
            Banner()



    val userName = rememberSaveable { mutableStateOf("") }
    val userPassword = rememberSaveable { mutableStateOf("") }
    val userPhoneNumber = rememberSaveable { mutableStateOf("") }
    val userEmail = rememberSaveable { mutableStateOf("") }
    val userPinCode = rememberSaveable { mutableStateOf("") }
    val userAddress = rememberSaveable { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current





    when (viewModel.state.value) {
        State.DEFAULT.name -> {
            LazyColumn(
                modifier = Modifier
                    .padding()
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {


                item {
                    TextField(
                        value = userName.value,
                        onValueChange = {
                            userName.value = it
                        },
                        maxLines = 1,
                        label = { Text(text = "Your Name", modifier = Modifier.padding(start = 6.dp)) },


                        leadingIcon = {
                            Surface(
                                shape = CircleShape,
                                color = Color.White,
                                tonalElevation = 4.dp,
                                shadowElevation = 8.dp,
                                modifier = Modifier.size(50.dp),
                                contentColor = Custom1


                            ){
                                Box(
                                    modifier = Modifier.padding(6.dp)
                                ){
                                    Icon(
                                        Icons.Rounded.Person,
                                        contentDescription = "person",
                                        modifier = Modifier
                                            .size(40.dp)
                                            //.padding(start = 6.dp)
                                            .background(Color.White, CircleShape)
                                    )
                                }
                            }

                        },
                        shape = RoundedCornerShape(50.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedLeadingIconColor = Color.Black,
                            unfocusedLeadingIconColor = Custom1,



                        ),

                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 24.dp)
                            .shadow(3.dp, RoundedCornerShape(50.dp))
                            .background(Color.White, CircleShape),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide() // Hide the keyboard when the "Done" button is pressed
                            }
                        )

                    )

                }

                item {
                    TextField(
                        value = userPhoneNumber.value,
                        onValueChange = {
                            userPhoneNumber.value = it
                        },
                        maxLines = 1,
                        label = { Text(text = "Phone No.", modifier = Modifier.padding(start = 8.dp)) },


                        leadingIcon = {
                            Surface(
                                shape = CircleShape,
                                color = Color.White,
                                tonalElevation = 4.dp,
                                shadowElevation = 8.dp,
                                modifier = Modifier.size(50.dp),
                                contentColor = Custom1


                            ){
                                Box(
                                    modifier = Modifier.padding(6.dp)
                                ){
                                    Icon(
                                        Icons.Rounded.Phone,
                                        contentDescription = "person",
                                        modifier = Modifier
                                            .size(40.dp)
                                            //.padding(start = 6.dp)
                                            .background(Color.White, CircleShape)
                                    )
                                }
                            }


                        },
                        shape = RoundedCornerShape(50.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedLeadingIconColor = Color.Black,
                            unfocusedLeadingIconColor = Custom1,
                            cursorColor = Custom1,


                            ),

                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 24.dp)
                            .shadow(3.dp, RoundedCornerShape(50.dp))
                            .background(Color.White, CircleShape),

                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,




                    )

                }

                item {
                    TextField(
                        value = userEmail.value,
                        onValueChange = {
                            userEmail.value = it
                        },
                        maxLines = 1,
                        label = { Text(text = "Email", modifier = Modifier.padding(start = 8.dp)) },


                        leadingIcon = {
                            Surface(
                                shape = CircleShape,
                                color = Color.White,
                                tonalElevation = 4.dp,
                                shadowElevation = 8.dp,
                                modifier = Modifier.size(50.dp),
                                contentColor = Custom1


                            ){
                                Box(
                                    modifier = Modifier.padding(6.dp)
                                ){
                                    Icon(
                                        Icons.Rounded.Email,
                                        contentDescription = "email",
                                        modifier = Modifier
                                            .size(40.dp)
                                            //.padding(start = 6.dp)
                                            .background(Color.White, CircleShape)
                                    )
                                }
                            }


                        },
                        shape = RoundedCornerShape(50.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedLeadingIconColor = Color.Black,
                            unfocusedLeadingIconColor = Custom1,
                            cursorColor = Custom1,


                            ),

                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 24.dp)
                            .shadow(3.dp, RoundedCornerShape(50.dp))
                            .background(Color.White, CircleShape),

                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide() // Hide the keyboard when the "Done" button is pressed
                            }
                        )
                    )

                }

                item {
                    TextField(
                        value = userPinCode.value,
                        onValueChange = {
                            userPinCode.value = it
                        },
                        maxLines = 1,
                        label = { Text(text = "Pin Code", modifier = Modifier.padding(start = 8.dp)) },


                        leadingIcon = {
                            Surface(
                                shape = CircleShape,
                                color = Color.White,
                                tonalElevation = 4.dp,
                                shadowElevation = 8.dp,
                                modifier = Modifier.size(50.dp),
                                contentColor = Custom1


                            ){
                                Box(
                                    modifier = Modifier.padding(6.dp)
                                ){
                                    Icon(
                                        Icons.Rounded.CheckCircle,
                                        contentDescription = "person",
                                        modifier = Modifier
                                            .size(40.dp)
                                            //.padding(start = 6.dp)
                                            .background(Color.White, CircleShape)
                                    )
                                }
                            }


                        },
                        shape = RoundedCornerShape(50.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedLeadingIconColor = Color.Black,
                            unfocusedLeadingIconColor = Custom1,
                            cursorColor = Custom1,


                            ),

                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 24.dp)
                            .shadow(3.dp, RoundedCornerShape(50.dp))
                            .background(Color.White, CircleShape),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone ={
                            keyboardController?.hide()
                        }
                        )

                    )

                }

                item {
                    TextField(
                        value = userPassword.value,
                        onValueChange = {
                            userPassword.value = it
                        },
                        maxLines = 1,
                        label = { Text(text = "Password", modifier = Modifier.padding(start = 8.dp)) },


                        leadingIcon = {
                            Surface(
                                shape = CircleShape,
                                color = Color.White,
                                tonalElevation = 4.dp,
                                shadowElevation = 8.dp,
                                modifier = Modifier.size(50.dp),
                                contentColor = Custom1


                            ){
                                Box(
                                    modifier = Modifier.padding(6.dp)
                                ){
                                    Icon(
                                        Icons.Rounded.Lock,
                                        contentDescription = "person",
                                        modifier = Modifier
                                            .size(40.dp)
                                            //.padding(start = 6.dp)
                                            .background(Color.White, CircleShape)
                                    )
                                }
                            }


                        },
                        shape = RoundedCornerShape(50.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedLeadingIconColor = Color.Black,
                            unfocusedLeadingIconColor = Custom1,
                            cursorColor = Custom1,


                            ),

                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 24.dp)
                            .shadow(3.dp, RoundedCornerShape(50.dp))
                            .background(Color.White, CircleShape),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = PasswordVisualTransformation(),
                        singleLine = true

                    )

                }

                item {
                    TextField(
                        value = userAddress.value,
                        onValueChange = {
                            userAddress.value = it
                        },
                        maxLines = 1,
                        label = { Text(text = "City", modifier = Modifier.padding(start = 8.dp)) },


                        leadingIcon = {
                            Surface(
                                shape = CircleShape,
                                color = Color.White,
                                tonalElevation = 4.dp,
                                shadowElevation = 8.dp,
                                modifier = Modifier.size(50.dp),
                                contentColor = Custom1


                            ){
                                Box(
                                    modifier = Modifier.padding(6.dp)
                                ){
                                    Icon(
                                        Icons.Rounded.LocationOn,
                                        contentDescription = "person",
                                        modifier = Modifier
                                            .size(40.dp)
                                            //.padding(start = 6.dp)
                                            .background(Color.White, CircleShape)
                                    )
                                }
                            }


                        },
                        shape = RoundedCornerShape(50.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedLeadingIconColor = Color.Black,
                            unfocusedLeadingIconColor = Custom1,
                            cursorColor = Custom1,


                            ),

                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 24.dp)
                            .shadow(3.dp, RoundedCornerShape(50.dp))
                            .background(Color.White, CircleShape),

                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),

                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                            }
                        )

                    )

                }










                item {
                    Button(
                        modifier = Modifier
                            .padding(vertical = 16.dp, horizontal = 16.dp)
                            .fillMaxWidth()
                            .height(55.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Custom1,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(10.dp),
                        onClick = {
                        viewModel.createUser(
                            name = userName.value,
                            password = userPassword.value,
                            phone = userPhoneNumber.value,
                            email = userEmail.value,
                            pincode = userPinCode.value,
                            address = userAddress.value
                        )
                    }) {

                        Text(
                            text = "Sign Up",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                            )

                    }
                }

                item {

                    Row(modifier = Modifier
                        .clickable {
                            onGoToNextScreen()
                        }
                        .padding(vertical = 5.dp)
                    ) {
                        Text(text = "Already an account? ")
                        Text(
                            text = "Login",

                            )
                    }
                }

            }
        }

        State.LOADING.name ->
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center)
        { CircularProgressIndicator() }
        State.FAILED.name ->
            Column {
                Text(text = "Try Again")
                Button(onClick = {
                    viewModel.setDefault()
                }) {

                    Text(text = "Click Here")

                }
            }

        State.ERROR.name ->
            Column {

                Text(text = "Somthing went wrong!")

                Button(onClick = {
                    viewModel.setDefault()
                }) {
                    Text(text = "Click Here")
                }

            }

        State.EMPTY.name ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                //verticalArrangement = Arrangement.Center

            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.error),
                        contentDescription = "error",
                        modifier = Modifier
                            .size(200.dp)
                            .padding(vertical = 20.dp)

                    )
                }
                item {
                    Text(
                        text = "Please fill all the fields!",
                        fontSize = 20.sp,
                    )
                }
                item {
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
                            viewModel.setDefault()
                        }) {
                        Text(
                            text = "Click Here",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

        State.SUCCESS.name ->
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
                    Text(text = "Account Creation Successful!", fontSize = 20.sp)
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
                    onGoToNextScreen()
                }) {
                    Text(text = "Proceed to Login",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold

                    )
                }
            }
            }


    }
}}}