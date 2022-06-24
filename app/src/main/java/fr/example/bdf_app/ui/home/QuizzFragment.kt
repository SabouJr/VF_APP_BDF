package fr.example.bdf_app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fr.example.bdf_app.data.Question
import fr.example.bdf_app.databinding.FragmentQuizzBinding

class QuizzFragment : Fragment() {

    private lateinit var quizzViewModel: QuizzViewModel

    private var _binding: FragmentQuizzBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizzBinding.inflate(inflater, container, false)

        quizzViewModel = ViewModelProvider(this)[QuizzViewModel::class.java]

        setUpObservers()

        quizzViewModel.populateQuizz()

        return binding.root
    }

    private fun setUpObservers() {
        quizzViewModel.homeViewStateLiveData.observe(viewLifecycleOwner) {
            render(it)
        }
    }

    private fun render(homeViewState: QuizzViewState) {
        when (homeViewState) {
            is QuizzViewState.Populate -> {
                initViewPager(homeViewState.quizz)
            }
            is QuizzViewState.Content -> {
                binding.vpQuizz.currentItem = homeViewState.indexQuestion
                binding.progressBar.progress = homeViewState.indexQuestion
            }
        }
    }

    private fun initViewPager(questions: List<Question>) {
        binding.progressBar.apply {
            progress = 0
            max = questions.size
        }
        binding.vpQuizz.apply {
            isUserInputEnabled = false
            adapter = ViewPagerAdapter(questions = questions, object : ViewPagerAdapter.IQuestionListener {
                override fun onClickNextButton(currentPosition: Int, isCorrect: Boolean, isLastQuestion: Boolean) {
                    quizzViewModel.addingResponse(isResponseValid = isCorrect)
                    if (isLastQuestion) {
                        animateEndQuizz()
                    }
                }
            })
        }
    }

    private fun animateEndQuizz() {
        binding.animationSuccess.apply {
            visibility = View.VISIBLE
            playAnimation()
        }

        // TODO: Navigate to screen results.

        // RESULTS HERE : homeViewModel.responses
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}