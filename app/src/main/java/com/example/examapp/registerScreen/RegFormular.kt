package com.example.examapp.registerScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examapp.model.UserViewModel
import java.time.LocalDate

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationFormula(modifier: Modifier = Modifier, userViewModel: UserViewModel){

    var name by remember { mutableStateOf("")}
    var lastname by remember { mutableStateOf("")}
    var location by remember { mutableStateOf("")}
    var birthDate by remember { mutableStateOf(LocalDate.now()) }
    var birthTime by remember { mutableStateOf(LocalDate.now()) }

    val uiState by userViewModel.userUiState.collectAsState()

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = {name = it})
        modifier.padding(vertical = 4.dp)


    }
}

 */