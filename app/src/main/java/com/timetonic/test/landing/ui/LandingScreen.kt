package com.timetonic.test.landing.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.timetonic.test.landing.LandingViewModel
import com.timetonic.test.ui.BaseScreenState
import com.timetonic.test.ui.components.organisms.BookDetail
import org.koin.androidx.compose.koinViewModel

@Composable
fun LandingScreen(
    viewModel: LandingViewModel = koinViewModel()
) {

    val landingState = viewModel.landingState.collectAsState()
    val landingData = viewModel.landingData.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getBooks()
    }

    Column {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            text = "Landing Screen",
        )

        if (landingState.value == BaseScreenState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        }

        if (landingState.value == BaseScreenState.Success) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(landingData.value.booksInfo) { book ->
                    BookDetail(
                        modifier = Modifier.padding(16.dp),
                        bookUrl = book.coverImage,
                        title = book.name,
                        bookId = book.id,
                    )
                }
            }
        }
    }
}
