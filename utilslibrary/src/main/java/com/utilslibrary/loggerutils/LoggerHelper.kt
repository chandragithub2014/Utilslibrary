package com.utilslibrary.loggerutils

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.annotation.Keep

@Keep
class LoggerHelper {
    fun displayDebugLog(tag:String,message:String){
        Log.d(tag,message)
    }
    fun displayInfoLog(tag:String,message:String){
        Log.i(tag,message)
    }

    fun displayErrorLog(tag:String,message:String){
        Log.e(tag,message)
    }


    fun displayToast(ctx: Context, message:String , duration : Int = 1){
        if(duration == 1) {
            Toast.makeText(ctx, message, Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show()
        }
    }

}