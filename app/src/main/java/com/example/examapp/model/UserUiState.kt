package com.example.examapp.model

import java.time.LocalDate
import java.time.LocalTime

data class UserUiState(
    val id: Int,
    val name: String,
    val lastname: String,
    val location: String,
    val birthDate: LocalDate,
    val birthTime: LocalTime


)
