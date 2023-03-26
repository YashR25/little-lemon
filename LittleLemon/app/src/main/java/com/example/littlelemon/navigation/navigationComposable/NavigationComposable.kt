package com.example.littlelemon.navigation.navigationComposable

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon.navigation.Home
import com.example.littlelemon.navigation.OnBoarding
import com.example.littlelemon.navigation.Profile
import com.example.littlelemon.utils.IS_LOGGED_IN
import com.example.littlelemon.utils.SharedPreferenceManager

@Composable
fun Navigation(navController: NavHostController) {

    val context = LocalContext.current
    val sharedPreferences = SharedPreferenceManager.getSharedPreference(context)
    val isLoggedIn = sharedPreferences?.getBoolean(IS_LOGGED_IN, false)
    val startDestination = if(isLoggedIn == true) Home.route else OnBoarding.route

    NavHost(navController = navController, startDestination = startDestination){
        composable(Home.route){
            com.example.littlelemon.screens.Home()
        }

        composable(OnBoarding.route){
            com.example.littlelemon.OnBoarding(navController)
        }

        composable(Profile.route){
            com.example.littlelemon.screens.Profile(navController)
        }
    }
}