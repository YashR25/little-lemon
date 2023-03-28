package com.example.littlelemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.components.LittleLemonForm
import com.example.littlelemon.components.TopBar
import com.example.littlelemon.navigation.Home
import com.example.littlelemon.ui.theme.green


@Composable
fun OnBoarding(navController: NavHostController) {

    Scaffold(topBar = {TopBar(navHostController = navController, shouldShowProfile = false) }) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Header()
            LittleLemonForm(buttonText = "Register",
                onButtonClick = {navController.navigate(Home.route)})
        }
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(green),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Let's get to know you", style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(40.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun OnBoardingPreview(){
//    OnBoarding()
}