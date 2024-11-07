package com.social.app.domain.usecase

import com.social.app.data.local.UserPreferences
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val userPreferences: UserPreferences
) {
    suspend operator fun invoke() {
        userPreferences.clearUserData()
    }
}
