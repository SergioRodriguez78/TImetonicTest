package com.timetonic.test.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timetonic.test.login.data.LoginRepository
import com.timetonic.test.login.ui.data.LoginData
import com.timetonic.test.network.ApiResponse
import com.timetonic.test.ui.BaseScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _loginState: MutableStateFlow<BaseScreenState> =
        MutableStateFlow(BaseScreenState.Empty)
    val loginState = _loginState.asStateFlow()

    private val _loginData: MutableStateFlow<LoginData> = MutableStateFlow(LoginData())
    val loginData = _loginData.asStateFlow()

    fun updateEmail(email: String) {
        _loginData.value = _loginData.value.copy(email = email)
    }

    fun updatePassword(password: String) {
        _loginData.value = _loginData.value.copy(password = password)
    }

    fun login() {
        _loginState.value = BaseScreenState.Loading
        viewModelScope.launch {
            try {
                loginRepository.login(loginData.value.email, loginData.value.password)
                    .catch {
                        Log.e("LoginViewModel", "login error: ${it.message}")
                        _loginState.value = BaseScreenState.Error
                    }
                    .collect { response ->
                        if (response is ApiResponse.Success) {
                            _loginState.value = BaseScreenState.Success
                        }
                    }
            } catch (e: Exception) {
                _loginState.value = BaseScreenState.Error
            }
        }
    }
}
