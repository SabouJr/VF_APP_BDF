package fr.example.bdf_app.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.example.bdf_app.data.Challenge

class DashboardViewModel : ViewModel() {

    private val _challengesLiveData = MutableLiveData<List<Challenge>>()
    val challengesLiveData: MutableLiveData<List<Challenge>>
        get() = _challengesLiveData

    fun initChallenges() {
        challengesLiveData.postValue(
            listOf(
                Challenge(id = 1, value = "Ne pas dépenser de l’argent dans des cigarettes - +100€"),
                Challenge(id = 2, value = "Marcher au lieu de payer un ticket de métro - +10€"),
                Challenge(id = 3, value = "Prendre les transports au lieu de la voiture - +50€ "),
                Challenge(id = 4, value = "Apporter votre gamelle au travail au lieu d’aller au resto - + 5€")
            )
        )
    }
}