package com.example.randhawamedicos.screens

import SignInScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.randhawamedicos.ui.theme.RandhawaMedicosTheme
import com.example.randhawamedicos.vmodel.OrderViewModel
import com.example.randhawamedicos.vmodel.ProductsViewModel
import com.example.randhawamedicos.vmodel.SignUpScreenViewModel
import com.example.randhawamedicos.vmodel.SpecificOrderViewModel

class MainActivity : ComponentActivity() {

    val viewModel : SignUpScreenViewModel by viewModels()

    val productsViewModel: ProductsViewModel by viewModels()

    val orderViewModel: OrderViewModel by viewModels()

    val specificOrderViewModel : SpecificOrderViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandhawaMedicosTheme {



                        Navigation(
                            modifier = Modifier,
                            viewModel = viewModel,
                            productsViewModel = productsViewModel,
                            orderViewModel = orderViewModel,
                            specificOrderViewModel = specificOrderViewModel
                        )





            }
        }
    }
}





@Composable
fun Navigation(
    modifier: Modifier,
    viewModel: SignUpScreenViewModel,
    productsViewModel: ProductsViewModel,
    orderViewModel: OrderViewModel,
    specificOrderViewModel: SpecificOrderViewModel
){



    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.SignUp,
        enterTransition = { slideInHorizontally { it } },
        exitTransition = {slideOutHorizontally { -it }},
        popEnterTransition = { slideInHorizontally { -it } },
        popExitTransition = { slideOutHorizontally { it } }
    ){
        composable<Screen.SignUp>{
                SignUpScreen(
                    onGoToNextScreen = {
                        navController.navigate(Screen.SignIn)
                    },

                    onGoToHomeScreen = {
                        navController.navigate(Screen.Home)
                    },
                    viewModel = viewModel
                )

        }

        composable<Screen.SignIn>{
                SignInScreen(
                    onGoToViewDetailsScreen = { user->

                            navController.navigate(Screen.ViewDetails(
                                    name = user.name,
                                    email = user.email,
                                    phone = user.phone,
                                account_status = user.approved,
                                    user_id = user.user_id,
                                    pin = user.pincode

                            ))


                    },

                    onGoToNextScreen = {
                        navController.navigate(Screen.Home)
                    },
                            onGoBack = {
                        navController.popBackStack()
                    },
                    onGoToSignUpScreen ={
                        navController.navigate(Screen.SignUp)
                    },
                    viewModel = viewModel
                )

        }



        composable<Screen.ViewDetails> { backStackEntry ->
            val viewDetails : Screen.ViewDetails = backStackEntry.toRoute()


            ViewDetails(
                name = viewDetails.name,
                email = viewDetails.email,
                phone = viewDetails.phone,
                user_id = viewDetails.user_id,
                account_status = viewDetails.account_status,
                pin = viewDetails.pin,




                onGoBack = {
                    navController.popBackStack()
                },

                onGoToProfile = {
                    navController.navigate(Screen.Profile(
                        name = viewDetails.name,
                        email = viewDetails.email,
                        phone = viewDetails.phone,
                        city = "",
                        date = "",
                        pin = "",
                        user_id = "",
                        account_status = 0
                    ))
                },
                productsViewModel = productsViewModel,
                orderViewModel = orderViewModel,
                specificOrderViewModel = specificOrderViewModel,
                onGoToOrderState = {
                    navController.navigate(Screen.OrderState)
                }

                
            )


        }



        composable<Screen.OrderState>{
            
            OrderState(
                orderViewModel = orderViewModel,
                onGoBack = {
                    navController.popBackStack()
                },
                onGoToViewDetails = {
                    navController.navigate(Screen.ViewDetails)
                }
            )
            
        }



    }}








