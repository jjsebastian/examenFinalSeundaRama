package com.utad.javierjimenez.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object DataStorageRepository {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "MY_DATA_STORE")

    private val userNameKey = stringPreferencesKey("SUSER_NAME_KEY")

    suspend fun saveUserName(context: Context, sampleData:String){
        context.dataStore.edit{ editor ->
            editor[userNameKey] = sampleData
        }
    }
    suspend fun getUserName(context: Context): Flow<String> {
        return context.dataStore.data.map { editor ->
            editor[userNameKey] ?: "no hay nombre"
        }
    }
    suspend fun delateAll(context: Context){
        context.dataStore.edit { editor ->
            editor.clear()//borrar todos
        }
    }

    suspend fun delateSample(context: Context){
        context.dataStore.edit { editor ->
            editor.remove(userNameKey)//borrar solo un dato
        }
    }

}