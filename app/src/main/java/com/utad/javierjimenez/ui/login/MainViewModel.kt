package com.utad.javierjimenez.ui.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utad.javierjimenez.data.storage.DataStorageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    fun saveUserName(context: Context, username: String){
        viewModelScope.launch(Dispatchers.IO) {
            DataStorageRepository.saveUserName(context.applicationContext, username)
        }
    }

}