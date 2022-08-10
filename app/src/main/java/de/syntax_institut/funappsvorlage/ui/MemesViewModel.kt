package de.syntax_institut.funappsvorlage.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.syntax_institut.funappsvorlage.data.AppRepository
import de.syntax_institut.funappsvorlage.data.remote.MemeApi
import kotlinx.coroutines.launch

class MemesViewModel : ViewModel() {

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
            repository.getMemes()
        }
    }
}

