package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.navigation.Profile

@Composable
fun TopBar(shouldShowProfile: Boolean = false, navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxWidth().height(80.dp).padding(8.dp)){
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little Lemon Logo"
            ,
            Modifier
                .height(50.dp)
                .width(200.dp).align(Alignment.Center), contentScale = ContentScale.FillWidth)

        if(shouldShowProfile){
            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp)
                    .align(Alignment.CenterEnd)
                    .clickable {
                        navHostController.navigate(Profile.route)
                    })
        }
    }

//    Row(modifier = Modifier
//        .fillMaxWidth()
//        .padding(16.dp), horizontalArrangement = Arrangement.End) {
//        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little Lemon Logo"
//            ,
//            Modifier
//                .height(50.dp)
//                .width(200.dp)
//                .padding(end = 50.dp), contentScale = ContentScale.FillWidth)
//        if(shouldShowProfile){
//            Image(painter = painterResource(id = R.drawable.profile),
//                contentDescription = "Profile Image",
//                alignment = Alignment.CenterEnd,
//                modifier = Modifier
//                    .clip(CircleShape)
//                    .size(50.dp)
//                    .clickable {
//                        navHostController.navigate(Profile.route)
//                    })
//        }
//    }
}