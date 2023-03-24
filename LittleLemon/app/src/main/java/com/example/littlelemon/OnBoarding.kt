package com.example.littlelemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.components.InputTextField
import com.example.littlelemon.components.TopBar
import com.example.littlelemon.ui.theme.green


@Composable
fun OnBoarding() {

    Scaffold(topBar = {TopBar()}) {paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Header()
            Form()
        }
    }
}

@Composable
private fun Form() {
    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Personal Information", style = MaterialTheme.typography.h2,
        modifier = Modifier.padding(top = 30.dp))
        Column() {
            InputTextField(value = firstName, onValueChange = {firstName = it}, label = "First Name")
            InputTextField(value = lastName, onValueChange = {lastName = it}, label = "Last Name")
            InputTextField(value = email, onValueChange = {email = it}, label = "Email Address"
                , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register", style = MaterialTheme.typography.body2)
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
    OnBoarding()
}