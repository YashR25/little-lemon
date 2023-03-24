package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R

@Composable
fun TopBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp), horizontalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little Lemon Logo"
            , Modifier.height(50.dp).width(200.dp), contentScale = ContentScale.FillWidth)

    }
}