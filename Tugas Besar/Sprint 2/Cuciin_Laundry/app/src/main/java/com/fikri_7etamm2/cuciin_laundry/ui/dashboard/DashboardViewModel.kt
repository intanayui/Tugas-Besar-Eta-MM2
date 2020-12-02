package com.fikri_7etamm2.cuciin_laundry.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Belum Ada Orderan"
    }
    val text: LiveData<String> = _text
}