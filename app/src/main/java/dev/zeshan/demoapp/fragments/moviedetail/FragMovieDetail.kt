package dev.zeshan.demoapp.fragments.moviedetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dev.zeshan.demoapp.apis.RestClient
import dev.zeshan.demoapp.databinding.FragMovieDetailBinding
import dev.zeshan.demoapp.models.DTOMovieDetail


class FragMovieDetail : Fragment() {
    private var _binding: FragMovieDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var id: String;
    private lateinit var viewModel: FragMovieDetailViewModel

    private val observer =
        Observer<DTOMovieDetail> { obj ->
            _binding?.pbMovieList?.visibility = View.GONE
            _binding?.clMain?.visibility = View.VISIBLE
            _binding?.items = obj

        }//test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            id = arguments?.getString("id").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragMovieDetailBinding.inflate(inflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.btnWatch?.setOnClickListener { view ->
            Toast.makeText(context, "This will do later", Toast.LENGTH_LONG).show()
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragMovieDetailViewModel::class.java)
        viewModel.getMovieDetail(id)
        // TODO: Use the ViewModel
        viewModel.movieDetail?.let {
            it.observe(viewLifecycleOwner, observer)
        }
    }

}