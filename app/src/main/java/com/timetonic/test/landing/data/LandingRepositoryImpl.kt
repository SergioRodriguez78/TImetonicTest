package com.timetonic.test.landing.data

import com.timetonic.test.dataAccess.sharedPreferences.manager.SharedPreferencesManager
import com.timetonic.test.dataAccess.sharedPreferences.manager.SharedPreferencesManagerImpl
import com.timetonic.test.landing.data.remote.LandingService
import com.timetonic.test.landing.data.remote.model.extension.toBookUI
import com.timetonic.test.landing.ui.model.BookUI
import com.timetonic.test.network.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class LandingRepositoryImpl(
    private val service: LandingService,
    private val preferences: SharedPreferencesManager
) : LandingRepository {
    override suspend fun getAllBooks(): Flow<ApiResponse<List<BookUI>?>> =
        withContext(Dispatchers.IO) {
            val ou = preferences.readString(SharedPreferencesManagerImpl.OU).orEmpty()
            val sessionKey =
                preferences.readString(SharedPreferencesManagerImpl.SESSION_KEY).orEmpty()

            service.getAllBooks(
                uc = ou,
                ou = ou,
                sessionKey = sessionKey,
            ).map { landingResponseDTO ->

                if (landingResponseDTO.allBooks.booksInfo.isEmpty()) {
                    return@map ApiResponse.Error(Throwable("No books found"))
                }

                val books =landingResponseDTO.allBooks.booksInfo.map { booksDto ->
                    booksDto.toBookUI()
                }
                ApiResponse.Success(books)
            }
        }
}
