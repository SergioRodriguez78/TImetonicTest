package com.timetonic.test.ui.components.atoms

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.SubcomposeAsyncImage

@Composable
fun ImageTimetonic(
    modifier: Modifier,
    url: String,
    progressIndicator: ProgressIndicator,
    contentDescription: String? = null,
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = contentDescription,
        loading = {
            when (progressIndicator) {
                ProgressIndicator.Circular -> CircularProgressIndicator()
                ProgressIndicator.Linear -> LinearProgressIndicator()
            }
        },
    )
}

enum class ProgressIndicator {
    Circular,
    Linear
}
