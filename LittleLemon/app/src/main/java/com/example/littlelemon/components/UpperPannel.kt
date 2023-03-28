package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.cloud
import com.example.littlelemon.ui.theme.green
import com.example.littlelemon.ui.theme.yellow

@Composable
fun UpperPanel(onTextChange: (String) -> Unit) {
    var searchPhrase by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.background(green)){
        Column(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = stringResource(id = R.string.title),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = yellow
            )
            Text(
                text = stringResource(id = R.string.location),
                fontSize = 24.sp,
                color = cloud
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.description),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(bottom = 28.dp, end = 20.dp)
                        .fillMaxWidth(0.6f),
                    color = cloud
                )
                Image(
                    painter = painterResource(id = R.drawable.hero),
                    contentDescription = "Upper Panel Image",
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .width(100.dp)
                        .height(100.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            TextField(value = searchPhrase, 
                onValueChange = {
                    searchPhrase = it
                    onTextChange(it)
                                },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")},
            placeholder = { Text(text = "Enter search phrase")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
                shape = TextFieldDefaults.OutlinedTextFieldShape,
                colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Transparent,
                backgroundColor = Color.White, leadingIconColor = Color.Black)
            )
        }
    }

}