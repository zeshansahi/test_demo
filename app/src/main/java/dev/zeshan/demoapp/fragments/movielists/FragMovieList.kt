package dev.zeshan.demoapp.fragments.movielists

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dev.zeshan.demoapp.databinding.FragMovieListFragmentBinding
import dev.zeshan.demoapp.models.DTOMovie
import dev.zeshan.demoapp.rvutills.MovieAdaptors

class FragMovieList : Fragment() {
    private var _binding: FragMovieListFragmentBinding? = null
    private val binding get() = _binding!!

    private var adaptors: MovieAdaptors? = null

    private lateinit var viewModel: FragMovieListViewModel
    private val observer =
        Observer<ArrayList<DTOMovie>> { terminals ->
            adaptors!!.setItems(terminals)
            _binding?.pbMovieList?.visibility = View.GONE
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragMovieListFragmentBinding.inflate(inflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adaptors = MovieAdaptors(activity)
        _binding?.rvMovieList?.layoutManager = LinearLayoutManager(activity)
        _binding?.rvMovieList?.adapter = adaptors
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragMovieListViewModel::class.java)
        viewModel.getMovieList()
        // TODO: Use the ViewModel
        viewModel.movieList?.let {
            it.observe(viewLifecycleOwner, observer)
        }
    }


}