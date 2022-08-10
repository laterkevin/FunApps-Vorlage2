package de.syntax_institut.funappsvorlage.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntax_institut.funappsvorlage.data.datamodels.Meme
import de.syntax_institut.funappsvorlage.data.remote.MemeApi
import java.lang.Exception

const val TAG = "AppRepositoryTAG"

/**
 * Diese Klasse holt die Informationen und stellt sie mithilfe von Live Data dem Rest
 * der App zur Verfügung
 */
class AppRepository(private val api: MemeApi) {

    // Die LiveData Variable memes enthält die Liste aus dem API call
    // TODO
    private val _memes = MutableLiveData<List<Meme>>()
    val memes: LiveData<List<Meme>>
        get() = _memes

    /**
     * Diese Funktion ruft die Daten aus dem API Service ab und speichert die Antwort in der
     * Variable memes. Falls der Call nicht funktioniert, wird die Fehlermeldung geloggt
     */
    // TODO Schreibe hier deinen Code
    suspend fun getMemes() {
        try {
            val memeList = api.retrofitService.getMemes().data.memes
            _memes.value = memeList.shuffled()
        } catch (e: Exception) {
            Log.e(TAG, "Fehler beim shuffeln der Liste!")
        }
    }
}
