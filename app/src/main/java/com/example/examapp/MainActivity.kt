package com.example.examapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.examapp.model.UserViewModel
import com.example.examapp.Screens.RegistrationFormula
import com.example.examapp.ui.theme.ExamAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegistrationFormula(userViewModel = UserViewModel())
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Text(
        text = " Testing if Git works for me  ",

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExamAppTheme {
        RegistrationFormula()
    }
}