package fr.example.bdf_app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.example.bdf_app.data.Question
import fr.example.bdf_app.data.Response

class QuizzViewModel : ViewModel() {

    private val _homeViewStateLiveData = MutableLiveData<QuizzViewState>()
    val homeViewStateLiveData: LiveData<QuizzViewState>
        get() = _homeViewStateLiveData

    lateinit var questions: List<Question>
    var indexQuestion = 0
    val responses = ArrayList<Boolean>()

    fun populateQuizz() {
        questions = listOf(
            Question(
                id = 1, category = "La Banque de France et ses mission", title = "Comment surnomme- t-on la banque de France ?",
                responses = listOf(
                    Response(id = 1, value = "le gardien de la monnaie"),
                    Response(id = 2, value = "la police de l’argent"),
                    Response(id = 3, value = "le grand protecteur de ton épargne", isValid = true)
                )
            ),
            Question(
                id = 2, category = "La Banque de France et ses mission", title = "La Banque de France est-elle le premier imprimeur de billets en euros ?",
                responses = listOf(
                    Response(id = 1, value = "Vrai"),
                    Response(id = 2, value = "Faux", isValid = true),
                    Response(id = 3, value = "")
                )
            ),
            Question(
                id = 3, category = "La Banque de France et ses mission", title = "Combien de personnes sont fichées à la Banque de France ?",
                responses = listOf(
                    Response(id = 1, value = "près de 1 millions"),
                    Response(id = 2, value = "près de 2 millions", isValid = true),
                    Response(id = 3, value = "près de 4 millions"),
                )
            ),
            Question(
                id = 4, category = "La Banque de France et ses mission", title = "Comment faire pour ne plus être fiché à la Banque de France ?",
                responses = listOf(
                    Response(id = 1, value = "régularisé sa situation financière"),
                    Response(id = 2, value = "attendre 5 ans", isValid = true),
                    Response(id = 3, value = "régularisé sa situation financière et attendre 2 ans"),
                )
            ),
            Question(
                id = 5, category = "Gestion de son budget et ses finances", title = "Qu'est-ce qui caractérise un cas de surendettement ?",
                responses = listOf(
                    Response(id = 1, value = "Mes mensualités de crédits représentent plus du tiers de mes revenus"),
                    Response(id = 2, value = "Je suis chaque mois à découvert", isValid = true),
                    Response(id = 3, value = "Je n'arrive plus à payer toutes mes dettes et mes charges personnelles"),
                )
            ),
            Question(
                id = 6, category = "Gestion de son budget et ses finances", title = "Je dois payer mon loyer, passer chez le coiffeur, régler ma facture d’électricité… Quel est l’ordre de priorité ?",
                responses = listOf(
                    Response(id = 1, value = "Mon loyer (charges fixes) 1. Ma factures d’électricité (charges 2. courantes) Le coiffeur (dépenses 3. occasionnelles)"),
                    Response(id = 2, value = "Ma factures d’électricité (charges 2. courantes), Le coiffeur (dépenses 3. occasionnelles), Mon loyer (charges fixes) 1", isValid = true),
                    Response(id = 3, value = "Mon loyer (charges fixes) 1,Le coiffeur (dépenses 3. occasionnelles), Ma factures d’électricité (charges 2. courantes)"),
                )
            ),
            Question(
                id = 7, category = "Gestion de son budget et ses finances", title = "Etablir des budgets est :",
                responses = listOf(
                    Response(id = 1, value = "Obligatoire"),
                    Response(id = 2, value = "Facultatif mais fortement conseillé", isValid = true),
                    Response(id = 3, value = ""),
                )
            ),
            Question(
                id = 8, category = "Gestion de son budget et ses finances", title = "Parmi ces charges à payer laquelle est une charge fixe ?",
                responses = listOf(
                    Response(id = 1, value = "L’achat d’un telephone"),
                    Response(id = 2, value = "Le loyer", isValid = true),
                    Response(id = 3, value = "Les factures de restaurant"),
                )
            ),
            Question(
                id = 9, category = "Gestion de son budget et ses finances", title = "Quand-est-ce qu’un budget est dit « équilibré » ?",
                responses = listOf(
                    Response(id = 1, value = "Quand les ressources sont supérieures ou égales aux dépenses sur une période donnée"),
                    Response(id = 2, value = "Quand les ressources sont inférieures aux dépenses sur une période donnée", isValid = true),
                    Response(id = 3, value = "Quand les dépenses sont supérieures aux ressources sur une période donnée"),
                )
            ),
            Question(
                id = 10, category = "Épargne", title = "Qu’est-ce que l’épargne ?",
                responses = listOf(
                    Response(id = 1, value = "L’argent que tu donnes à un ami"),
                    Response(id = 2, value = "L’argent que tu dépenses immédiatement", isValid = true),
                    Response(id = 3, value = "L’argent que tu mets de côté"),
                )
            ),
            Question(
                id = 11, category = "Épargne", title = "A quoi sert l’épargne ?",
                responses = listOf(
                    Response(id = 1, value = "À faire face à un imprévu, à préparer tes futurs projets, ou à te faire plaisir"),
                    Response(id = 2, value = "A acheter uniquement des choses utiles", isValid = true),
                    Response(id = 3, value = "A bloquer ton argent pour une durée d’une année"),
                )
            ),
            Question(
                id = 12, category = "Épargne", title = "Et toi, quel genre de personne es-tu a la fin du mois ?",
                responses = listOf(
                    Response(id = 1, value = "Les pâtes à tous les repas"),
                    Response(id = 2, value = "Celui ou celle qui peut faire le plus beau voyage", isValid = true),
                    Response(id = 3, value = "Il te reste suffisamment d’argent pour faire plaisir à tes proches et à toi-même"),
                )
            ),
            Question(
                id = 13, category = "Épargne", title = "Comment épargner ?",
                responses = listOf(
                    Response(id = 1, value = "Tu prends 10 % des sommes que tu reçois car c’est la règle de l’épargne"),
                    Response(id = 2, value = "Tu définis la somme que tu souhaites conserver pour tes projets", isValid = true),
                    Response(id = 3, value = "Tu mets de côté 25 % des sommes que tu reçois car c’est la règle de l’épargne"),
                )
            ),
            Question(
                id = 14, category = "Crédits", title = "Vers qui se tourner en cas de surendettement ?",
                responses = listOf(
                    Response(id = 1, value = "Vers son conseiller banquier"),
                    Response(id = 2, value = "Vers la Banque de France", isValid = true),
                    Response(id = 3, value = "Vers un ami"),
                )
            ),
            Question(
                id = 15, category = "Crédits", title = "Pour financer mes études, à quoi pourrais-je prétendre comme prêts ?",
                responses = listOf(
                    Response(id = 1, value = "Prêts immobiliers bancaires"),
                    Response(id = 2, value = "Crédit classique", isValid = true),
                    Response(id = 3, value = "Prêt étudiant"),
                )
            ),
            Question(
                id = 16, category = "Crédits", title = "Si je suis en conflit avec ma banque, qui dois-je contacter ?",
                responses = listOf(
                    Response(id = 1, value = "La Banque de France"),
                    Response(id = 2, value = "Mon conseiller", isValid = true),
                    Response(id = 3, value = "Le service client"),
                )
            ),
            Question(
                id = 17, category = "Crédits", title = "Quel est le document indispensable pour constituer un dossier de demande de prêt ?",
                responses = listOf(
                    Response(id = 1, value = "Bulletins de salaire"),
                    Response(id = 2, value = "Facture EDF", isValid = true),
                    Response(id = 3, value = "Quittance de loyer"),
                )
            ),
            Question(
                id = 18, category = "Crédits", title = "Quel est le document indispensable pour constituer un dossier de demande de prêt ?",
                responses = listOf(
                    Response(id = 1, value = "75 000 €"),
                    Response(id = 2, value = "25 000 €", isValid = true),
                    Response(id = 3, value = "100 000 €"),
                )
            ),
        )

        _homeViewStateLiveData.postValue(QuizzViewState.Populate(quizz = questions, maxProgress = questions.size))
    }

    fun addingResponse(isResponseValid: Boolean) {
        responses.add(element = isResponseValid)
        indexQuestion++
        _homeViewStateLiveData.postValue(QuizzViewState.Content(indexQuestion = indexQuestion))
    }
}