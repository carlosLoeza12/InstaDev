package com.example.instadev.view.auth.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instadev.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val loginUseCase: LoginUseCase) : ViewModel() {

    private val _uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChange(email: String) {

        this._uiState.update { state ->

            state.copy(
                email = email,
                isLoginEnabled = this.isEmailValid(email) && isPasswordValid(state.password)
            )
        }
    }

    fun onPasswordChange(password: String) {

        this._uiState.update { state ->

            state.copy(
                password = password,
                isLoginEnabled = this.isEmailValid(state.email) && isPasswordValid(password)
            )
        }
    }

    fun doLogin() {

        viewModelScope.launch(Dispatchers.IO) {

            loginUseCase.invoke(user = _uiState.value.email, password = _uiState.value.password)
        }
    }

    private fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isPasswordValid(password: String): Boolean = password.length >= 5
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false
)