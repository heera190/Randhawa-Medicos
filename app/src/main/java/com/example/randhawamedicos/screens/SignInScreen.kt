import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randhawamedicos.R
import com.example.randhawamedicos.api.User
import com.example.randhawamedicos.screens.Banner
import com.example.randhawamedicos.ui.theme.Custom1
import com.example.randhawamedicos.vmodel.LoginState
import com.example.randhawamedicos.vmodel.SignUpScreenViewModel

@Composable
fun SignInScreen(
    onGoToNextScreen: () -> Unit,
    onGoBack: () -> Unit,
    onGoToSignUpScreen: () -> Unit,
    viewModel: SignUpScreenViewModel,
    onGoToViewDetailsScreen: (User) -> Unit,
){

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

    val signInResult = viewModel.signInResult.observeAsState()

    Log.d("signinresult", signInResult.value?.body().toString())

    val userEmail = rememberSaveable{ mutableStateOf("") }
    val userPassword = rememberSaveable{ mutableStateOf("") }

    when(viewModel.signInState.value) {
        LoginState.DEFAULT.lname ->

            LazyColumn(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                //  verticalArrangement = Arrangement.Center,
            ) {

                item {
                    TextField(
                        value = userEmail.value,
                        onValueChange = {
                            userEmail.value = it
                        },
                        maxLines = 1,
                        label = {
                            Text(
                                text = "Your Email",
                                modifier = Modifier.padding(start = 6.dp)
                            )
                        },


                        leadingIcon = {
                            Surface(
                                shape = CircleShape,
                                color = Color.White,
                                tonalElevation = 4.dp,
                                shadowElevation = 8.dp,
                                modifier = Modifier.size(50.dp),
                                contentColor = Custom1


                            ) {
                                Box(
                                    modifier = Modifier.padding(6.dp)
                                ) {
                                    Icon(
                                        Icons.Rounded.Email,
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
                            unfocusedLeadingIconColor = Custom1,


                            ),

                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 24.dp)
                            .shadow(3.dp, RoundedCornerShape(50.dp))
                            .background(Color.White, CircleShape),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)

                    )

                }

                item {
                    TextField(
                        value = userPassword.value,
                        onValueChange = {
                            userPassword.value = it
                        },
                        maxLines = 1,
                        label = {
                            Text(
                                text = "Password",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        },


                        leadingIcon = {
                            Surface(
                                shape = CircleShape,
                                color = Color.White,
                                tonalElevation = 4.dp,
                                shadowElevation = 8.dp,
                                modifier = Modifier.size(50.dp),
                                contentColor = Custom1


                            ) {
                                Box(
                                    modifier = Modifier.padding(6.dp)
                                ) {
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
                            viewModel.signIn(userEmail.value, userPassword.value)
                        }) {

                        Text(
                            text = "Sign In",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )

                    }
                }

                item {
                    Row(
                        modifier = Modifier.clickable {
                            onGoToSignUpScreen()
                        }
                    ) {
                        Text(text = "Don't have an account? ")
                        Text(text = "Sign Up")
                    }
                }


            }
        LoginState.LOADING.lname -> {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                CircularProgressIndicator()
            }
        }

        LoginState.SUCCESS.lname -> {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
        LaunchedEffect(Unit)  {
            signInResult.value?.body()?.let { onGoToViewDetailsScreen(it.user) }

        }


            }
        }

        LoginState.ERROR.lname ->{
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Error")
                }
            }

        LoginState.FAILED.lname ->{
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Failed")
            }
        }

        LoginState.EMPTY.lname ->{
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,

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
                            viewModel.setSignInDefault()
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
        }
} }}}