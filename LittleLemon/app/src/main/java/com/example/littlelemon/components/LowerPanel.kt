package com.example.littlelemon.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.MenuItemRoom
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.yellow

@Composable
fun LowerPanel(navController: NavHostController, dishes: List<MenuItemRoom> = listOf()) {
    Column {
        WeeklySpecialCard()
        LazyColumn {
            itemsIndexed(dishes) { _, dish ->
                MenuDish(navController, dish)
            }
        }
    }
}

@Composable
fun WeeklySpecialCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.weekly_special),
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun MenuDish(navController: NavHostController? = null, dish: MenuItemRoom) {
    Card(onClick = {}) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Column(modifier = Modifier
                .fillMaxWidth(0.75f)
                .padding(vertical = 5.dp)) {
                Text(text = dish.title, style = MaterialTheme.typography.h2)
                Text(text = dish.description, style = MaterialTheme.typography.body1)
                Text(text = "$${dish.price}", style = MaterialTheme.typography.body2)
            }
            GlideImage(model = dish.image, contentDescription = "Greek Salad Image", modifier = Modifier.clip(shape = RoundedCornerShape(10.dp)))
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = yellow
    )
}