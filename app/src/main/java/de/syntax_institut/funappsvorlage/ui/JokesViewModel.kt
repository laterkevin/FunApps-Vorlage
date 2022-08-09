package de.syntax_institut.funappsvorlage.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.syntax_institut.funappsvorlage.data.AppRepository
import de.syntax_institut.funappsvorlage.data.remote.JokeApi
import kotlinx.coroutines.launch

class JokesViewModel : ViewModel() {

    // hier wird eine AppRepository Instanz erstellt, mit dem Parameter JokeApi
    // TODO
    private val repository = AppRepository(JokeApi)

    // hier werden die jokes aus dem repository in einer eigenen Variablen gespeichert
    // TODO
    val joke = repository.jokes

    /**
     * Diese Funktion ruft die Repository-Funktion zum Laden der Witze
     * innerhalb einer Coroutine auf
     */
    // TODO Schreibe hier deinen Code
    fun loadData() {
        viewModelScope.launch {
            repository.getJokes()
        }
    }
}

