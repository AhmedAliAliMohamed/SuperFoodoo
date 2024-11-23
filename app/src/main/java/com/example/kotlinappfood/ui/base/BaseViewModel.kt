package com.example.kotlinappfood.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinappfood.utilities.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    val _dataStates = MutableLiveData<DataState<String>>()
    val dataState: LiveData<DataState<String>> get() = _dataStates


}