package com.example.littlelemon.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.navigation.OnBoarding
import com.example.littlelemon.ui.theme.charcoal
import com.example.littlelemon.utils.*

@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = SharedPreferenceManager.getSharedPreference(context)
    val firstName = sharedPreferences?.getString(FIRST_NAME,"")
    val lastName = sharedPreferences?.getString(LAST_NAME, "")
    val email = sharedPreferences?.getString(EMAIL, "")
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
            .padding(8.dp)) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little Lemon Logo",
            Modifier
                .width(200.dp)
                .height(100.dp), contentScale = ContentScale.Fit)

        Column(modifier = Modifier) {
            Text(text = "Personal Information", style = MaterialTheme.typography.h2, modifier = Modifier.padding(bottom = 50.dp))
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                ProfileTextField("First Name", firstName!!)
                ProfileTextField("Last Name", lastName!!)
                ProfileTextField("Email Address", email!!)
            }
        }
        Button(onClick = {
            sharedPreferences?.edit()?.clear()?.apply()
            navController.navigate(OnBoarding.route)
        },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Logout", style = MaterialTheme.typography.body2)
        }
    }
}

@Composable
fun ProfileTextField(label: String, value: String){
        Text(text = label, style = MaterialTheme.typography.body2, modifier = Modifier
            .fillMaxWidth())
    Column(modifier = Modifier
        .border(1.dp, charcoal, RoundedCornerShape(8.dp))
        .fillMaxWidth()) {
        Text(text = value, modifier = Modifier.padding(8.dp))
    }

}
