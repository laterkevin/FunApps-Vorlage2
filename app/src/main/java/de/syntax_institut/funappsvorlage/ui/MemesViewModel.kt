package de.syntax_institut.funappsvorlage.ui

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.syntax_institut.funappsvorlage.data.AppRepository
import de.syntax_institut.funappsvorlage.data.remote.MemeApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class ApiStatus {
    LOADING, DONE, ERROR
}

class MemesViewModel : ViewModel() {

    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus>
        get() = _loading

    // hier wird eine AppRepository Instanz erstellt, mit dem Parameter MemeApi
    // TODO
    private val repository = AppRepository(MemeApi)

    // hier werden die memes aus dem repository in einer eigenen Variablen gespeichert
    // TODO
    val meme = repository.memes

    /**
     * Diese Funktion ruft die Repository-Funktion zum Laden der Memes
     * innerhalb einer Coroutine auf
     */
    // TODO Schreibe hier deinen Code
    fun loadData() {
        viewModelScope.launch {
            _loading.value = ApiStatus.LOADING
            try {
                repository.getMemes()
                _loading.value = ApiStatus.DONE
            } catch (
                e: Exception
            ) {
                Log.e("MainViewModel", "Error Loading Data from API")
                _loading.value = ApiStatus.ERROR
            }
        }
    }
}

