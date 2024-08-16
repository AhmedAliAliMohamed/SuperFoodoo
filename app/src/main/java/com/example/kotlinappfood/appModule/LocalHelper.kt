package com.example.kotlinappfood.appModule

import android.content.Context
import com.example.kotlinappfood.utilities.SharedPreferencesHelper
import java.util.Locale

class LocalHelper {
    companion object {
        fun setLocale(context: Context): Context {
            val language = SharedPreferencesHelper.getSharedPreferenceString(
                context,
                SharedPreferencesHelper.Keys.LANGUAGE_KEY.name,
               Locale.getDefault().language
            )
            return updateResources(context, language)

        }
        private fun updateResources(context: Context, language: String): Context {
        val local = Locale(language)
        Locale.setDefault(local)
        val configuration = context.resources.configuration
        configuration.setLocale(local)
        configuration.setLayoutDirection(local)
        return context.createConfigurationContext(configuration)
        }

    }


}