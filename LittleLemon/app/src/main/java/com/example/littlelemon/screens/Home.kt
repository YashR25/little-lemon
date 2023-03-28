package com.example.littlelemon.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.AppDatabase
import com.example.littlelemon.components.LowerPanel
import com.example.littlelemon.components.TopBar
import com.example.littlelemon.components.UpperPanel
import com.example.littlelemon.ui.theme.charcoal

@Composable
fun Home(navHostController: NavHostController) {
    val context = LocalContext.current
    
    val database = AppDatabase.getInstance(context)

    Scaffold(topBar = { TopBar(shouldShowProfile = true, navHostController)}) { it ->
        Column(Modifier.padding(it)) {
            val databaseItems = database.menuItemDao().getAll().observeAsState(emptyList())
            val categories = databaseItems.value.groupBy {item ->  item.category}.keys.toList()
            var menuItems = databaseItems.value
            var searchPhrase by remember {
                mutableStateOf("")
            }
            UpperPanel{st ->
                searchPhrase = st
            }
            MenuBreakDown(categories)
            menuItems = if(searchPhrase.isNotEmpty()){
                menuItems.filter { it.title.contains(searchPhrase, ignoreCase = true) }
            }else{
                databaseItems.value
            }
            LowerPanel(navController = navHostController, menuItems)
        }
    }
}

@Composable
fun MenuBreakDown(categories: List<String>) {
    Column(Modifier.padding(8.dp)) {
        Text(text = "ORDER FOR DELIVERY!", style = MaterialTheme.typography.h1)
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(vertical = 10.dp)) {
            items(categories){category ->
                Box(modifier = Modifier.clip(RoundedCornerShape(10.dp)).background(Color.LightGray)) {
                    Text(text = category, modifier = Modifier.padding(8.dp), style = MaterialTheme.typography.body2)
                }
            }
        }
    }


}


