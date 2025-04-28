package com.alexyndrik.thousands_of_courses.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

object AppSettingsDataStore {

    private const val ONBOARDING_KEY = "onboarding_completed"
    private const val AUTHORIZATION_KEY = "authorization_completed"
    private const val EMAIL_KEY = "email_value"

    private val Context.dataStore by preferencesDataStore(name = "settings")

    suspend fun saveOnboardingState(context: Context, completed: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(ONBOARDING_KEY)] = completed
        }
    }

    suspend fun readOnboardingState(context: Context): Boolean {
        val preferences = context.dataStore.data.first()
        return preferences[booleanPreferencesKey(ONBOARDING_KEY)] ?: false
    }

    suspend fun saveAuthorizationState(context: Context, authorized: Boolean, email: String) {
        context.dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(AUTHORIZATION_KEY)] = authorized
            preferences[stringPreferencesKey(EMAIL_KEY)] = email
        }
    }

    suspend fun readAuthorizationState(context: Context): Boolean {
        val preferences = context.dataStore.data.first()
        return preferences[booleanPreferencesKey(AUTHORIZATION_KEY)] ?: false
    }

    suspend fun readEmail(context: Context): String {
        val preferences = context.dataStore.data.first()
        return preferences[stringPreferencesKey(EMAIL_KEY)] ?: ""
    }
}
