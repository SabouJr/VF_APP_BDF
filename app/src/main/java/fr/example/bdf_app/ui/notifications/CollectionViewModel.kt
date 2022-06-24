package fr.example.bdf_app.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CollectionViewModel : ViewModel() {

    private val _moviesLiveData = MutableLiveData<MutableList<MovieModel>>()
    val moviesLiveData: LiveData<MutableList<MovieModel>>
        get() = _moviesLiveData

    fun populateMovies() {
        with(_moviesLiveData) {
            postValue(
                ArrayList(
                    listOf(
                        MovieModel(
                            name = "Dépenses",
                        ),
                        MovieModel(
                            name = "Epargnes",
                        )
                    )
                )
            )
        }
    }
}