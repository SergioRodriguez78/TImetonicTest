package com.timetonic.test.ui.components.atoms

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.SubcomposeAsyncImage

@Composable
fun ImageTimetonic(
    modifier: Modifier,
    url: String,
    contentDescription: String? = null,
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = contentDescription,
        loading = {
            CircularProgressIndicator()
        },
    )
}
