package fr.example.bdf_app.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.example.bdf_app.data.Challenge
import fr.example.bdf_app.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    private var _binding: FragmentDashboardBinding? = null

    private lateinit var challengesAdapter: ChallengesAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        initAdapter()

        setUpObserver()

        dashboardViewModel.initChallenges()

        return binding.root
    }

    private fun setUpObserver() {
        dashboardViewModel.challengesLiveData.observe(viewLifecycleOwner) {
            challengesAdapter.refresh(newItems = it)
        }
    }

    private fun initAdapter() {
        challengesAdapter = ChallengesAdapter(ArrayList(), object : ChallengesAdapter.IChallengeListener {
            override fun onClickChallenge(item: Challenge) {
                // TODO
            }
        })
        binding.rvChallenges.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = challengesAdapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}