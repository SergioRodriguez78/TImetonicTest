package com.timetonic.test.ui

sealed class BaseScreenState {
    data object Loading : BaseScreenState()
    data object Error : BaseScreenState()
    data object Success : BaseScreenState()
    data object Empty : BaseScreenState()
}
