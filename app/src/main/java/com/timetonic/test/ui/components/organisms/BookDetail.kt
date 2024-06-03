package com.timetonic.test.ui.components.organisms

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.timetonic.test.ui.components.atoms.ImageTimetonic
import com.timetonic.test.ui.components.atoms.ProgressIndicator
import com.timetonic.test.ui.components.molecules.BookInfo

@Composable
fun BookDetail(
    modifier: Modifier,
    bookUrl: String,
    title: String,
    bookId: String,
) {
    Row(
        modifier = modifier
    ) {
        ImageTimetonic(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),

            url = bookUrl,
            progressIndicator = ProgressIndicator.Circular,
        )

        BookInfo(
            modifier = Modifier.padding(start = 32.dp),
            title = title,
            bookId = bookId
        )
    }
}