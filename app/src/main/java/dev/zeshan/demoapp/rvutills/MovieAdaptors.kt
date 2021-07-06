package dev.zeshan.demoapp.rvutills

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import dev.zeshan.demoapp.R
import dev.zeshan.demoapp.base.GenericRecyclerAdapter
import dev.zeshan.demoapp.databinding.MovieItemBinding
import dev.zeshan.demoapp.models.DTOMovie


class MovieAdaptors(context: Context?) :
    GenericRecyclerAdapter<DTOMovie?, MovieListener<DTOMovie?>?, MovieVH?>(context) {
    private val context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val itemAnswerBinding: MovieItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie_item,
            parent,
            false
        )
        return MovieVH(itemAnswerBinding)
    }
}