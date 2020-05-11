package com.utilslibrary.sharedprefsutils

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.Keep
import androidx.core.content.edit
import androidx.preference.PreferenceManager

@Keep
class SharedPreferencesHelper {


    companion object {
        private var prefs: SharedPreferences? = null
        @Volatile
        private var INSTANCE: SharedPreferencesHelper? = null
        private val LOCK = Any()
        operator fun invoke(context: Context): SharedPreferencesHelper =
            INSTANCE ?: synchronized(LOCK) {
                INSTANCE ?: buildSharedPreferencesHelper(context).also {
                    INSTANCE = it
                }
            }

        private fun buildSharedPreferencesHelper(context: Context): SharedPreferencesHelper {
            prefs = PreferenceManager.getDefaultSharedPreferences(context)
            return SharedPreferencesHelper()
        }

    }

    fun saveStringPreferences(key: String, value: String) {
        prefs?.edit(commit = true) {
            putString(key, value)
        }
    }

    fun saveIntegerPreferences(key: String, value: Int) {
        prefs?.edit(commit = true) {
            putInt(key, value)
        }

    }

    fun saveFloatPreferences(key: String, value: Double) {
        prefs?.edit(commit = true) {
            putFloat(key, value.toFloat())
        }
    }

    fun saveLongPreferences(key: String, value: Long) {
        prefs?.edit(commit = true) {
            putLong(key, value)
        }
    }

    fun fetchStringPreferences(key: String): String? = prefs?.getString(key, "")

    fun fetchIntPreferenes(key: String): Int? = prefs?.getInt(key, 0)

    fun fetchFloatPreferences(key: String): Float? = prefs?.getFloat(key, 0.0f)

    fun fetchLongPreferences(key: String): Long? = prefs?.getLong(key, 0)


}