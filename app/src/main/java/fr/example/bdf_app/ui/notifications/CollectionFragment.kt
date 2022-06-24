package fr.example.bdf_app.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.example.bdf_app.databinding.FragmentCollectionBinding

class CollectionFragment : Fragment() {

    private lateinit var collectionViewModel: CollectionViewModel

    private var _binding: FragmentCollectionBinding? = null
    private val binding get() = _binding!!

    lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        collectionViewModel =
            ViewModelProvider(this)[CollectionViewModel::class.java]

        _binding = FragmentCollectionBinding.inflate(inflater, container, false)

        initAdapter()

        collectionViewModel.populateMovies()

        setUpObserver()

        return binding.root
    }

    private fun setUpObserver() {
        collectionViewModel.moviesLiveData.observe(viewLifecycleOwner) {
            movieAdapter.refresh(newItems = it)
        }
    }

    private fun initAdapter() {
        movieAdapter = MovieAdapter(ArrayList())
        binding.collectionRecyclerList.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = movieAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}