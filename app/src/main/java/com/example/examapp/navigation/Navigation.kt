package com.example.examapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examapp.Screens.Screen

@Composable
fun Navigation() {
    // Navigates From RegistrationScreen
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RegistrationFormula.route ) {
        composable( route = Screen.RegistrationFormula.route) {

        }

    }


}