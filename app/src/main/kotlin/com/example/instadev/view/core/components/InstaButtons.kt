package com.example.instadev.view.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun InstaButton(
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    text: String
) {

    Button(
        modifier = modifier,
        colors = colors,
        onClick = { onClick.invoke() },
        enabled = isEnabled,
        shape = shape
    ) {

        InstaText(
            modifier = Modifier.padding(vertical = 4.dp),
            text = text,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun InstaOutlinedButton(
    modifier: Modifier,
    onClick: () -> Unit,
    border: BorderStroke = BorderStroke(
        width = 1.dp,
        color = MaterialTheme.colorScheme.primary
    ),
    text: String,
    textColor: Color = MaterialTheme.colorScheme.primary
) {

    OutlinedButton(
        modifier = modifier,
        onClick = { onClick.invoke() },
        border = border,
    ) {

        InstaText(text = text, color = textColor)
    }
}

@Composable
fun InstaTextButton(onClick: () -> Unit, text: String) {

    TextButton(onClick = {onClick.invoke()}) {

        InstaText(
            text = text,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}