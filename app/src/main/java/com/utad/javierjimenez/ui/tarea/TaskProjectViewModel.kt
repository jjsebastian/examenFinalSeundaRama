package com.utad.javierjimenez.ui.tarea

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utad.javierjimenez.data.network.EmpresaApi
import com.utad.javierjimenez.data.network.EmpresaResponseItem

import com.utad.javierjimenez.data.storage.DataStorageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
data class TaskProjectUIState (

    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val response: List<EmpresaResponseItem>? = null

)
class TaskProjectViewModel: ViewModel() {
    private var _userName: MutableLiveData<String> = MutableLiveData(null)
    val userName: LiveData<String> = _userName

    private var _uiState: MutableLiveData<TaskProjectUIState> = MutableLiveData(TaskProjectUIState())
    val uiState: LiveData<TaskProjectUIState> get() = _uiState

    fun getUserName(context: Context){

        viewModelScope.launch(Dispatchers.IO){
            DataStorageRepository.getUserName(context).collect{ userName->
                if(userName!="No hay datos"){
                    _userName.postValue(userName)
                }
            }
        }
    }

    fun getTask(userName: String){
        _uiState.postValue(TaskProjectUIState(isLoading= true))
        viewModelScope.launch(Dispatchers.IO){
            val response = EmpresaApi.service.getHomeWork(userName, "U-tad")
            if(response.isSuccessful){
                _uiState.postValue(TaskProjectUIState(response = response.body()))
            }else{
                _uiState.postValue(TaskProjectUIState(isError = true))
            }

        }

    }
}