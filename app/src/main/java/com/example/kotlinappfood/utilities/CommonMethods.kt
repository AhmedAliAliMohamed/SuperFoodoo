package com.example.kotlinappfood.utilities

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import com.example.kotlinappfood.databinding.LangugeDialogBinding
import com.example.kotlinappfood.ui.activity.MainActivity
import java.security.AccessController.getContext


class CommonMethods {
    companion object{
        fun showLanguageDialog(context: Context,layoutInflater: LayoutInflater){
            val  alertDialog = Dialog(context)
            val  dialogBinding = LangugeDialogBinding.inflate(layoutInflater)
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

            }

            alertDialog.show()



        }
    }
}