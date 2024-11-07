package com.social.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.social.app.data.local.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val _emailError = MutableStateFlow<String?>(null)
    val emailError: StateFlow<String?> = _emailError

    private val _passwordError = MutableStateFlow<String?>(null)
    val passwordError: StateFlow<String?> = _passwordError

    fun saveLoginInfo(email: String, password: String, onSuccess: () -> Unit) {
        var isValid = true

        // Check if email is empty
        if (email.isBlank()) {
            _emailError.value = "Email is required."
            isValid = false
        } else {
            _emailError.value = null
        }

        // Check if password is empty
        if (password.isBlank()) {
            _passwordError.value = "Password is required."
            isValid = false
        } else {
            _passwordError.value = null
        }

        if (isValid) {
            viewModelScope.launch {
                userPreferences.saveLoginInfo(email, password)
                onSuccess() // Call the success callback after saving
            }
        }
    }

    fun clearEmailError() {
        _emailError.value = null
    }

    fun clearPasswordError() {
        _passwordError.value = null
    }
}
