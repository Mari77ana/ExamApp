package com.example.examapp.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HairdressersScreen(modifier: Modifier = Modifier){
    Column(
        modifier.fillMaxSize()
    ) {
        Text(text = "WELCOME TO HAIRDRESSER SCREEN",
            )


    }


}


@Preview(showBackground = true)
@Composable
fun HairdressersScreenPreview() {
    HairdressersScreen()
}
