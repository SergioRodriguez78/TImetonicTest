package com.timetonic.test.ui.components.atoms

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.timetonic.test.ui.theme.TimetonicBlue

@Composable
fun PrimaryText(
    modifier: Modifier,
    text: String,
    color: Color = TimetonicBlue
) {
    Text(
        modifier = modifier,
        text = text,
        color = color
    )
}
