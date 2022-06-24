package fr.example.bdf_app.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import fr.example.bdf_app.data.Question
import fr.example.bdf_app.data.Response
import fr.example.bdf_app.databinding.ItemQuizzBinding

class ViewPagerAdapter(private val questions: List<Question>, private val listener: IQuestionListener) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = ItemQuizzBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(questions[position], position, listener)
    }

    override fun getItemCount(): Int = questions.size

    inner class ViewPagerViewHolder constructor(private val binding: ItemQuizzBinding) : RecyclerView.ViewHolder(binding.root) {

        var isCorrect = false
        var goodResponse: Response? = null

        fun bind(currentQuestion: Question, currentPosition: Int, listener: IQuestionListener) {

            val isLastQuestion = currentPosition + 1 == questions.size

            binding.btnNextQuestion.text = if (isLastQuestion) {
                "Valider"
            } else {
                "Suivant"
            }

            with(currentQuestion) {
                binding.tvCategory.text = category
                binding.tvQuestion.text = title
                binding.rbChoice1.text = responses[0].value
                binding.rbChoice2.text = responses[1].value
                binding.rbChoice3.text = responses[2].value
            }

            goodResponse = currentQuestion.responses.find { it.isValid }

            binding.rgQuestion.setOnCheckedChangeListener { radioGroup, radioButtonId ->
                binding.btnNextQuestion.isEnabled = true
                isCorrect = goodResponse!!.value == binding.root.findViewById<RadioButton>(radioButtonId).text
            }

            binding.btnNextQuestion.setOnClickListener {
                listener.onClickNextButton(currentPosition, isCorrect, isLastQuestion)
            }
        }

    }

    interface IQuestionListener {
        fun onClickNextButton(currentPosition: Int, isCorrect: Boolean, isLastQuestion: Boolean)
    }

}