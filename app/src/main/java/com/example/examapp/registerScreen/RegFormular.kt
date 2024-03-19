package com.example.examapp.registerScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examapp.model.UserUiState
import com.example.examapp.model.UserViewModel
import com.example.examapp.retrofit.UserApi
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockSelection
import java.time.LocalDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationFormula(modifier: Modifier = Modifier, userViewModel: UserViewModel) {

    val uiState by userViewModel.userUiState.collectAsState()
    val calendarState = rememberSheetState()
    val clockState = rememberSheetState()

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = Modifier.padding(vertical = 4.dp),
            value = uiState?.name.orEmpty(),
            onValueChange = { userViewModel.updateName(it) },
            label = { Text(text = "Firstname") })


        TextField(
            modifier = Modifier.padding(vertical = 4.dp),
            value = uiState?.lastname.orEmpty(),
            onValueChange = {userViewModel.updateLastname(it)
            },
            label = { Text(text = "Lastname") })


        TextField(
            modifier = Modifier.padding(vertical = 4.dp),
            value = uiState?.location.orEmpty(),
            onValueChange = { userViewModel.updateLocation(it) },
            label = { Text(text = "Location") }
        )

        CalendarDialog(
            state = calendarState,
            config = CalendarConfig(
                monthSelection = true,
                yearSelection = true
            ),
            selection = CalendarSelection.Date { date ->
                Log.d("DATE", "$date")
                userViewModel.updateBirtDate(date) // save birthDate
            }
        )
        Button(
            modifier = modifier
                .width(280.dp)
                .padding(top = 10.dp),
            onClick = { calendarState.show() }
        ) {
            Text(text = "Select birth date")
        }

        ClockDialog(
            state = clockState,
            selection = ClockSelection.HoursMinutes { hours: Int, minutes: Int ->
                Log.d("TIME", "$hours:$minutes")

                // TODO Add to User -> hours * 100 + minutes
                userViewModel.updateBirthTime(hours,minutes)
            }
        )
        Button(
            modifier = modifier
                .width(280.dp)
                .padding(top = 10.dp),
            onClick = {
                clockState.show()
            }
        ) {
            Text(text = "Select birth time ")
        }

        Button(
            onClick = {
                      // TODO save user
                       uiState?.let { userViewModel.saveUser(it) }

            }, modifier = Modifier
                .width(280.dp)
                .padding(top = 10.dp)
        ) {
            Text(text = "Save")

        }


    }
}


@Preview(showBackground = true)
@Composable
fun RegistrationFormula() {

    RegistrationFormula(modifier = Modifier, userViewModel = UserViewModel())

}


