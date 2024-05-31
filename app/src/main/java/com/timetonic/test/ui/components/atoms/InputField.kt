package com.timetonic.test.ui.components.atoms

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InputField(
    modifier: Modifier,
    value: String,
    labelText : String,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text("Label") },
    )
}
