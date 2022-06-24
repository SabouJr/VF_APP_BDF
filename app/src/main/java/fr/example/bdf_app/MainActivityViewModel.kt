package fr.example.bdf_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val _anectode = MutableLiveData<String>()
    val anecdote: LiveData<String>
        get() = _anectode

    val anecdotes = listOf(
        "La banque de France a pour missions d'assurer la gestion des moyens de paiement du Trésor et d'entreprises publiques.",
        "Les trois grandes missions de la banque de France sont la stratégie monétaire, la stabilité financière et le service économique à la collectivité.",
        "La banque de France est en charge du renforcement de la réglementation et de la prévention des risques ainsi que de la sécurité des dépôts des épargnants. ",
        "La banque de France a été créée le 18 janvier 1800 à Paris.",
        "La banque de France est devenue propriété de l'État français uniquement le 1er janvier 19461 lors de sa nationalisation par Charles de Gaulle.",
        "Livrets d’épargne bancaire, compte épargne logement (CEL), plan épargne logement (PEL) sont des dispositifs d’épargne qui peuvent vous permettre de mettre de côté pour pouvoir financer vos projets.",
        "Le dispositif d’épargne logement est constitué du Plan Épargne Logement (PEL) et du Compte Épargne Logement (CEL). Ce sont des dispositifs d’épargne réglementés, qui peuvent vous permettre de vous constituer une épargne pour l’achat d’un bien immobilier ou pour financer des travaux par exemple. Vous pouvez aussi, grâce à eux, obtenir un prêt épargne logement, à l’issue de votre phase d’épargne, sous certaines conditions.",
        "Le livret d’épargne populaire est un livret d’épargne bancaire réglementé qui peut vous permettre de mettre de côté et de vous constituer une épargne. Ce livret est destiné aux personnes disposant de revenus modestes.",
        "Comment réussir à mettre de l'argent de côté en 3 étapes ?",
        "En France, quatre sources distinctes permettent le suivi du crédit : l’activité reflétée dans l’évolution des bilans bancaires, une collecte sur les flux de crédits nouveaux, les crédits déclarés par les banques à la centralisation des risques, une collecte régionale conventionnelle auprès de 300 banques de la Fédération Bancaire Française.",
        "L’usage veut que le montant des mensualités de remboursement d’un prêt n’excède pas le tiers du montant des revenus d’un particulier.",
    )

    fun fetchAnectode() {
        _anectode.postValue(anecdotes.random())
    }
}