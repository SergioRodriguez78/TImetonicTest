package com.timetonic.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.timetonic.test.navigation.NavigationController
import com.timetonic.test.ui.theme.TimetonicTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            TimetonicTestTheme {

                Scaffold {
                    NavigationController(navController, it)
                }
            }
        }
    }
}
