package com.example.kotlinappfood.utilities

import android.content.Context

class SharedPreferencesHelper {
  companion object{
      fun setSharedPreferenceString(context: Context,key: String,value : String){
          val sharedPreference =  context.getSharedPreferences(Keys.PREF_FILE.name, Context.MODE_PRIVATE)
          val editor = sharedPreference.edit()
          editor.putString(key, value)
          editor.apply()
      }
      fun setSharedPreferenceBoolean(context: Context,key: String,value : Boolean){
          val sharedPreference =  context.getSharedPreferences(Keys.PREF_FILE.name, Context.MODE_PRIVATE)
          val editor = sharedPreference.edit()
          editor.putBoolean(key, value)
          editor.apply()
      }
      fun getSharedPreferenceBoolean(context: Context,key: String,defaultValue : Boolean) : Boolean{
          val sharedPreference =  context.getSharedPreferences(Keys.PREF_FILE.name, Context.MODE_PRIVATE)
          return sharedPreference.getBoolean(key, defaultValue)
      }
      fun getSharedPreferenceString(context: Context,key: String,defaultValue : String) : String{
          val sharedPreference =  context.getSharedPreferences(Keys.PREF_FILE.name, Context.MODE_PRIVATE)
          return sharedPreference.getString(key, defaultValue).toString()
      }
  }

    enum class Keys  {
        LANGUAGE_KEY,
        PREF_FILE,
        AR,
        EN,
        FIRST_TIME,

    }


}