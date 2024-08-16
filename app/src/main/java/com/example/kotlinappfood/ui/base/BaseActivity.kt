package com.example.kotlinappfood.ui.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinappfood.appModule.LocalHelper
import javax.inject.Inject

abstract class BaseActivity<ViewModel : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initViewModel()
        initObservers()
        initErrorObservers()
    }

    protected abstract fun initViewModel()
    protected abstract fun initObservers()
    protected abstract fun initErrorObservers()


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocalHelper.setLocale(newBase))
    }

}