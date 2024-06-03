package com.timetonic.test.dataAccess.sharedPreferences.manager

import android.content.SharedPreferences

class SharedPreferencesManagerImpl(
    private val preferences: SharedPreferences
) : SharedPreferencesManager {

    override fun readString(key: String): String? {
        return preferences.getString(key, null)
    }

    override fun writeString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    companion object {
        const val SESSION_KEY = "session_KEY"
    }
}
