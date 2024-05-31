package com.timetonic.test.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.timetonic.test.ui.components.atoms.ImageTimetonic
import com.timetonic.test.ui.components.atoms.InputField
import com.timetonic.test.ui.components.atoms.PrimaryButton
import com.timetonic.test.ui.components.atoms.ProgressIndicator

@Composable
fun LoginScreen(
) {
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
            value = "Text",
            labelText = "Email",
            onValueChange = { }
        )

        InputField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = "Text",
            labelText = "Password",
            onValueChange = { }
        )

        PrimaryButton(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            buttonText = "Login",
            onClick = { }
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
