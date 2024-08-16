package com.example.kotlinappfood.utilities

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kotlinappfood.databinding.LanguageDialogBinding


class CommonMethods {
    companion object{
        private lateinit var alertDialog :Dialog
        fun showLanguageDialog(context: Context,layoutInflater: LayoutInflater,activity: Activity){
            alertDialog = Dialog(context)
            val  dialogBinding = LanguageDialogBinding.inflate(layoutInflater)
            alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            alertDialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            alertDialog.setContentView(dialogBinding.root)
            alertDialog.create()
            alertDialog.setCancelable(false)
            dialogBinding.cancelLanguageButton.setOnClickListener{
                alertDialog.dismiss()
            }
            dialogBinding.okayLanguageButton.setOnClickListener {
              if (SharedPreferencesHelper.getSharedPreferenceString(context,SharedPreferencesHelper.Keys.LANGUAGE_KEY.name,"") == "EN"){
                  SharedPreferencesHelper.setSharedPreferenceString(context,SharedPreferencesHelper.Keys.LANGUAGE_KEY.name,SharedPreferencesHelper.Keys.AR.name)
                  alertDialog.dismiss()
              }else{
                  SharedPreferencesHelper.setSharedPreferenceString(context,SharedPreferencesHelper.Keys.LANGUAGE_KEY.name,SharedPreferencesHelper.Keys.EN.name)
                  alertDialog.dismiss()
              }
                activity.recreate()
            }

            alertDialog.show()



        }
    }
}