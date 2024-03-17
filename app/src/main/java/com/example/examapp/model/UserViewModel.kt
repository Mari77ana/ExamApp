package com.example.examapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examapp.retrofit.UserApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val userApi: UserApi) : ViewModel() {

    private val _userUiState = MutableStateFlow<UserUiState?>(null)
    val userUiState = _userUiState.asStateFlow()


    fun saveUser(user: UserUiState) {
        viewModelScope.launch {
            try {
                val savedUser = userApi.saveUser(user)
                _userUiState.value = savedUser
                println("SUCCESS -> USER SAVED")

            } catch (e: Exception) {
                println("FAILED -> USER NOT SAVED")
            }
        }

    }


    fun getAllUsers(user: UserUiState) {
        viewModelScope.launch {
            try {
                val getAllUsers = userApi.getAllUsers()
                _userUiState.value = getAllUsers.firstOrNull()
                println("SUCCESS -> get all users")

            } catch (e: Exception) {
                println("FAILED -> get all users")
            }
        }

    }


}