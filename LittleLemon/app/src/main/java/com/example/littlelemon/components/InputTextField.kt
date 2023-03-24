package com.example.littlelemon.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun InputTextField(value: String,
                   keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
                   onValueChange: (String) -> Unit,
label: String) {
    Text(text = label, style = MaterialTheme.typography.body2)
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        placeholder = { Text(text = label) },
        keyboardOptions = keyboardOptions
    )

}