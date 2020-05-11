package com.utilslibrary

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utilslibrary.loggerutils.LoggerHelper
import com.utilslibrary.sharedprefsutils.SharedPreferencesHelper
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoggerHelper().displayDebugLog(TAG,"Display DebugLog")
        SharedPreferencesHelper.invoke(context = applicationContext).saveStringPreferences("name","Chandra")
        SharedPreferencesHelper.invoke(context = applicationContext).saveIntegerPreferences("age",38)
        SharedPreferencesHelper.invoke(context = applicationContext).saveFloatPreferences("height",5.6)
        LoggerHelper().displayToast(applicationContext,"Saved Preferences Long duration")
        LoggerHelper().displayToast(applicationContext,"Saved Preferences Short duration",0)
        println("Fetching String preferences ${SharedPreferencesHelper.invoke(applicationContext).fetchStringPreferences("name")}")
        println("Fetching Integer preferences ${SharedPreferencesHelper.invoke(applicationContext).fetchIntPreferenes("age")}")
        println("Fetching Float preferences ${SharedPreferencesHelper.invoke(applicationContext).fetchFloatPreferences("height")}")


    }
}