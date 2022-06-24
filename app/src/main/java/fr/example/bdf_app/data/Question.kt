package fr.example.bdf_app.data

data class Question(
    val id: Int,
    val category: String,
    val title: String,
    val responses: List<Response>
)

data class Response(
    val id: Int,
    val value: String,
    val isValid: Boolean = false
)