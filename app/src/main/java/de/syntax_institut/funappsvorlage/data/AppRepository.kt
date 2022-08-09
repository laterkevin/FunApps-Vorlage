package de.syntax_institut.funappsvorlage.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntax_institut.funappsvorlage.data.datamodels.Joke
import de.syntax_institut.funappsvorlage.data.remote.JokeApi
import java.lang.Exception


const val TAG = "AppRepository"

/**
 * Diese Klasse holt die Informationen und stellt sie mithilfe von Live Data dem Rest
 * der App zur Verfügung
 */
class AppRepository(private val api: JokeApi) {

    // Die LiveData Variable jokes enthält die Liste aus dem API call
    // TODO Schreibe hier deinen Code
    private val _jokes = MutableLiveData<List<Joke>>()
    val jokes: LiveData<List<Joke>>
        get() = _jokes

    /**
     * Diese Funktion ruft die Daten aus dem API Service ab und speichert die Antwort in der
     * Variable jokes. Falls der Call nicht funktioniert, wird die Fehlermeldung geloggt
     */
    // TODO Schreibe hier deinen Code
    suspend fun getJokes() {
        try {
            val jokeList = api.retrofitService.getJokes().jokes
            _jokes.value = jokeList.shuffled()
        } catch (e: Exception) {
            Log.e(TAG, "Fehler beim shuffeln der Liste!")
        }
    }
}
