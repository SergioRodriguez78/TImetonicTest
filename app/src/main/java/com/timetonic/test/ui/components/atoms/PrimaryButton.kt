package com.timetonic.test.ui.components.atoms

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.timetonic.test.ui.theme.TimetonicBlue

@Composable
fun PrimaryButton(
    modifier: Modifier,
    buttonText: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = TimetonicBlue
        )
    ) {
        Text(text = buttonText)
    }
}
