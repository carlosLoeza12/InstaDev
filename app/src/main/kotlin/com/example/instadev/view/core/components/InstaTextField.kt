package com.example.instadev.view.core.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@Composable
fun InstaOutlinedTextField(
    modifier: Modifier,
    labelText: String,
    shape: Shape = MaterialTheme.shapes.medium,
    value: String,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = modifier,
        label = {

            InstaText(
                text = labelText,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        shape = shape,
        value = value,
        onValueChange = { onValueChange(it) }
    )
}