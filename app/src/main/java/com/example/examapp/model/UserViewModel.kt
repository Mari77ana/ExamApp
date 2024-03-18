package com.example.examapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examapp.retrofit.UserApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime

class UserViewModel(private val userApi: UserApi) : ViewModel() {

    private val _userUiState = MutableStateFlow<UserUiState?>(null)
    val userUiState = _userUiState.asStateFlow()

    //private val formState = MutableStateFlow(FormState())


    fun saveUser(user: UserUiState) {
        viewModelScope.launch {
            try {
                val savedUser = userApi.saveUser(user)
                _userUiState.value = savedUser
                FetchState.SUCCEEDED_TO_FETCH_USER


            } catch (e: Exception) {
                FetchState.FAILED_TO_FETCH_USER
                println("FAILED -> USER NOT SAVED")
            }
        }

    }


    fun getAllUsers() {
        viewModelScope.launch {
            try {
                val getAllUsers = userApi.getAllUsers()
                _userUiState.value = getAllUsers.firstOrNull()
                FetchState.SUCCEEDED_TO_FETCH_USER
                println("SUCCESS -> get all users")

            } catch (e: Exception) {
                FetchState.FAILED_TO_FETCH_USER
                println("FAILED -> get all users")
            }
        }

    }



    fun getUserById(userId: Int) {
        viewModelScope.launch {
            try {
                val getUser = userApi.getUserById(userId)
                _userUiState.value = getUser
                FetchState.SUCCEEDED_TO_FETCH_USER
                println("GET USER -> $getUser")

            } catch (e: Exception) {
                FetchState.FAILED_TO_FETCH_USER
                println("FAILED TO GET USER")
            }
        }
    }



    /*

    data class FormState(
        val firstname: String = "",
        val lastname: String = "",
        val location: String = "",
        val birthDate: LocalDate? = null,
        val birthTime: LocalTime? = null
    ) {
        val isComplete = firstname.isNotEmpty() &&
                lastname.isNotEmpty() &&
                location.isNotEmpty() &&
                birthDate != null &&
                birthTime != null

    }

    data class UiState(
        val forState: FormState = FormState(),
        val isButtonEnabled: Boolean = false
    )

     */





     enum class FetchState {
         SUCCEEDED_TO_FETCH_USER,
         FAILED_TO_FETCH_USER
     }



}