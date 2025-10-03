package com.example.instadev.view.auth.register

import androidx.lifecycle.ViewModel
import android.util.Patterns
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    private val _uiState: MutableStateFlow<RegisterUiState> = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState

    fun onModeChange() {

        this._uiState.update { state: RegisterUiState ->

            state.copy(isPhoneMode = state.isPhoneMode.not(), value = "", isRegisterEnable = false)
        }
    }

    fun onRegisterChanged(value: String) {

        this._uiState.update { state: RegisterUiState ->

           val isRegisterEnable: Boolean = if(state.isPhoneMode) {

               value.length >= 10 && state.value.all { it.isDigit() }
           } else {

                Patterns.EMAIL_ADDRESS.matcher(value).matches()
            }

            state.copy(isRegisterEnable = isRegisterEnable, value = value)
        }
    }
}

data class RegisterUiState(
    val value: String = "",
    val isPhoneMode: Boolean = true,
    val isRegisterEnable: Boolean = false
)