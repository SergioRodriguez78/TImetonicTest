package com.timetonic.test.landing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timetonic.test.landing.data.LandingRepository
import com.timetonic.test.landing.ui.data.LandingData
import com.timetonic.test.network.ApiResponse
import com.timetonic.test.ui.BaseScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LandingViewModel(
    private val landingRepository: LandingRepository
) : ViewModel() {

    private var _landingData = MutableStateFlow(LandingData())
    val landingData = _landingData.asStateFlow()

    private var _landingState: MutableStateFlow<BaseScreenState> =
        MutableStateFlow(BaseScreenState.Loading)
    val landingState = _landingState.asStateFlow()

    fun getBooks() {
        viewModelScope.launch {
            try {
                landingRepository.getAllBooks().collect { response ->
                    if (response is ApiResponse.Success) {
                        _landingData.value =
                            _landingData.value.copy(booksInfo = response.data.orEmpty())
                        _landingState.value = BaseScreenState.Success
                    } else {
                        _landingState.value = BaseScreenState.Error
                    }

                }
            } catch (e: Exception) {
                _landingState.value = BaseScreenState.Error
            }
        }
    }
}
