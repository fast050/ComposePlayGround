package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          PreviewGreeting()
       }
    }

    @Composable
    fun Greeting(name: String) {
        Column {
            Text (text = "Hello $name!")
            Spacer(modifier = Modifier.size(10.dp))
            Text (text = "[bruh] $name!")
        }
    }

    @Preview
    @Composable
    fun PreviewGreeting() {
        Greeting("Android Good")
    }
}