package com.timetonic.test.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.timetonic.test.ui.components.atoms.PrimaryText
import com.timetonic.test.ui.theme.TimetonicLightColor

@Composable
fun BookInfo(
    modifier: Modifier,
    title: String,
    bookId: String,
) {
    Column(
        modifier = modifier
    ) {
        PrimaryText(
            modifier = Modifier,
            text = title
        )
        PrimaryText(
            modifier = Modifier.padding(top = 8.dp),
            text = bookId,
            color = TimetonicLightColor
        )
    }
}
