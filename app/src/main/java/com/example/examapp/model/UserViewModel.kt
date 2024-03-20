package com.example.examapp.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examapp.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime

class UserViewModel() : ViewModel() {


    private val _userUiState = MutableStateFlow<UserUiState?>(null)
    val userUiState = _userUiState.asStateFlow()

    //private val formState = MutableStateFlow(FormState())

    /*
    fun saveUser(){
        userUiState.value?.let { user ->
            viewModelScope.launch {
                try {
                    val userApi = RetrofitRepository.createUserApi()
                    val savedUser = userApi.saveUser(user)
                    _userUiState.value = savedUser
                    println("USER SAVED $savedUser")

                }catch (e: Exception){
                    println("USER NOT SAVED $user")
                    Log.e("saving user", "failed",e)

                }
            }
        }
    }

     */




    fun saveUser() {
        userUiState.value?.let { user ->
            viewModelScope.launch {
                try {
                    val savedUser = RetrofitInstance.userApi.saveUser(user)
                    _userUiState.value = savedUser
                    FetchState.SUCCEEDED_TO_FETCH_USER
                    println("USER SAVED $savedUser")
                } catch (e: Exception) {
                    FetchState.FAILED_TO_FETCH_USER
                    println("FAILED -> USER NOT SAVED $user")
                    Log.e("saving user", "failed",e)
                }
            }
        }
    }



/*
    fun getAllUsers() {
        viewModelScope.launch {
            try {
                val getAllUsers = RetrofitInstance.userApi.getAllUsers()
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
                val getUser = RetrofitInstance.userApi.getUserById(userId)
                _userUiState.value = getUser
                FetchState.SUCCEEDED_TO_FETCH_USER
                println("GET USER -> $getUser")

            } catch (e: Exception) {
                FetchState.FAILED_TO_FETCH_USER
                println("FAILED TO GET USER")
            }
        }
    }

 */

    /*
    fun updateUser(user: UserUiState) {
        _userUiState.value = user.copy(
            id = user.id,
            name = user.name,
            lastname = user.lastname,
            location = user.location,
            birthDate = user.birthDate,
            birthTime = user.birthTime
        )

    }

     */

    fun updateUser(name: String, lastname: String,location: String) {
        _userUiState.value = _userUiState.value?.copy(
            name = name,
            lastname = lastname,
            location = location,

        ) ?: UserUiState(
            id = null,
            name = name,
            lastname = lastname,
            location = location,
            birthDate = null,
            birthTime = null
        )
        println("UPDATE USER ${userUiState.value}")
        saveUser()

    }


    fun updateName(name: String) {
        _userUiState.value = _userUiState.value?.copy(
            name = name

        ) ?: UserUiState(
            id = null,
            name = name,
            lastname = null,
            location = null,
            birthDate = null,
            birthTime = null
        )
        println("UPDATE name $name")

    }

    fun updateLastname(lastname: String) {
        _userUiState.value = _userUiState.value?.copy(
            lastname = lastname

        ) ?: UserUiState(
            id = null,
            name = null,
            lastname = lastname,
            location = null,
            birthDate = null,
            birthTime = null
        )
        println("UPDATE Lastname $lastname")

    }

    fun updateLocation(location: String) {
        _userUiState.value = _userUiState?.value?.copy(
            location = location

        ) ?: UserUiState(
            id = null,
            name = null,
            lastname = null,
            location = location,
            birthDate = null,
            birthTime = null

        )
        println("UPDATE Location $location")
    }

    fun updateBirtDate(birthdate: LocalDate) {
        _userUiState.value = _userUiState?.value?.copy(
            birthDate = birthdate

        ) ?: UserUiState(
            id = null,
            name = null,
            lastname = null,
            location = null,
            birthDate = birthdate,
            birthTime = null

        )
        println("UPDATE Date $birthdate")
    }


    fun updateBirthTime(hours: Int, minutes: Int) {
        val birthTime = LocalTime.of(hours, minutes)
        _userUiState.value = _userUiState?.value?.copy(
            birthTime = birthTime

        ) ?: UserUiState(
            id = null,
            name = null,
            lastname = null,
            location = null,
            birthDate = null,
            birthTime = birthTime
        )
        println("UPDATE Time $birthTime")
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