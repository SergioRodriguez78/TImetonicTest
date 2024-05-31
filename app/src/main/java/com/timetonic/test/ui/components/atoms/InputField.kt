package com.timetonic.test.ui.components.atoms

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.timetonic.test.ui.theme.TimeTOnicOrange
import com.timetonic.test.ui.theme.TimetonicLightColor

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
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TimetonicLightColor,
            unfocusedContainerColor = TimetonicLightColor,
        )
    )
}
