package com.example.examapp.Screens

sealed class Screen(val route: String) {
    object RegistrationFormula: Screen("registration_screen")
    object HairdressersScreen: Screen("hairdressers_screen")
}
