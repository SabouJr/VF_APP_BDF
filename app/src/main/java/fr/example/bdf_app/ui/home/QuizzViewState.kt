package fr.example.bdf_app.ui.home

import fr.example.bdf_app.data.Question

sealed class QuizzViewState {
    data class Populate(val quizz: List<Question>, val maxProgress: Int) : QuizzViewState()
    data class Content(val indexQuestion: Int) : QuizzViewState()
}
