package com.example.littlelemon.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.navigation.Home
import com.example.littlelemon.utils.*

@Composable
fun LittleLemonForm(
    firstName: String = "",
lastName: String = "",
email: String = "",
buttonText: String,
onButtonClick: () -> Unit) {
    val context = LocalContext.current
    var firstNameState by remember {
        mutableStateOf(firstName)
    }

    var lastNameState by remember {
        mutableStateOf(lastName)
    }

    var emailState by remember {
        mutableStateOf(email)
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Personal Information", style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(top = 30.dp))
        Column() {
            InputTextField(value = firstNameState, onValueChange = {firstNameState = it}, label = "First Name")
            InputTextField(value = lastNameState, onValueChange = {lastNameState = it}, label = "Last Name")
            InputTextField(value = emailState, onValueChange = {emailState = it}, label = "Email Address"
                , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
        }
            Button(onClick = {
                    val isValid = validateInput(firstNameState, lastNameState, emailState, context)
                    if(isValid) onButtonClick() else Toast.makeText(
                        context,
                        "Please fill all the fields",
                        Toast.LENGTH_SHORT
                    ).show()
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = buttonText, style = MaterialTheme.typography.body2)
            }
    }

}


fun validateInput(firstName: String, lastName: String, email: String, context: Context): Boolean {
    return if(firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty()){
        SharedPreferenceManager.getSharedPreference(context)?.edit()?.apply {
            putBoolean(IS_LOGGED_IN, true)
            putString(FIRST_NAME, firstName)
            putString(LAST_NAME, lastName)
            putString(EMAIL, email)
            apply()
        }
        true
    }else{
        false
    }
}