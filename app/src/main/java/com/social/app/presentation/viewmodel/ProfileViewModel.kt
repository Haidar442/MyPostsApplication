package com.social.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.social.app.data.local.UserPreferences
import com.social.app.domain.usecase.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    userPreferences: UserPreferences,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {

    val email: Flow<String?> = userPreferences.getUserEmail()
    fun logout() {
        viewModelScope.launch {
            logoutUseCase()
        }
    }
}
