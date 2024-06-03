package com.timetonic.test.dataAccess.sharedPreferences.manager

interface SharedPreferencesManager {
    fun readString(key: String): String?
    fun writeString(key: String, value: String)
}
