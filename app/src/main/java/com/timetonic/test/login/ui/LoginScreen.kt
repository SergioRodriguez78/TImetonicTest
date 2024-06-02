package com.timetonic.test.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.timetonic.test.login.LoginViewModel
import com.timetonic.test.ui.BaseScreenState
import com.timetonic.test.ui.components.atoms.ImageTimetonic
import com.timetonic.test.ui.components.atoms.InputField
import com.timetonic.test.ui.components.atoms.PrimaryButton
import com.timetonic.test.ui.components.atoms.ProgressIndicator
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel()
) {

    val loginState = viewModel.loginState.collectAsState()
    val loginData = viewModel.loginData.collectAsState()

    LaunchedEffect(loginState) {
        if (loginState.value is BaseScreenState.Success) {
            TODO()
            // Navigate to the next screen
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(200.dp))

        ImageTimetonic(
            modifier = Modifier
                .padding(16.dp),
            url = "https://assets-global.website-files.com/5dc29b28f67939b38882b698/647525f9c5058fd805aa682d_timetonic-logo-dark-hdpi-opti.png",
            progressIndicator = ProgressIndicator.Linear
        )

        Spacer(modifier = Modifier.size(100.dp))

        InputField(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            value = loginData.value.email,
            labelText = "Email",
            onValueChange = {
                viewModel.updateEmail(it)
            }
        )

        InputField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginData.value.password,
            labelText = "Password",
            onValueChange = {
                viewModel.updatePassword(it)
            }
        )

        PrimaryButton(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            buttonText = "Login",
            onClick = {
                viewModel.login()
            }
        )

        if (loginState.value is BaseScreenState.Error) {
            Text(
                text = "Error occurred",
                color = Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        }
        if (loginState.value is BaseScreenState.Loading) {
            CircularProgressIndicator()
            Text(
                text = "Loading...",
                color = Color.Gray,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
