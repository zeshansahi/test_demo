package dev.zeshan.demoapp.rvutills


import android.os.Bundle
import android.util.Log
import dev.zeshan.demoapp.apis.RestClient
import dev.zeshan.demoapp.base.BaseViewHolder
import dev.zeshan.demoapp.databinding.MovieItemBinding
import dev.zeshan.demoapp.models.DTOMovie
import dev.zeshan.demoapp.utils.Navigator

class MovieVH(itemView: MovieItemBinding) :BaseViewHolder<DTOMovie?, MovieListener<DTOMovie?>?>(itemView.root) {
    private val TAG = "MovieVH"
    private val binding: MovieItemBinding
    private var item: DTOMovie? = null
    private var listener: MovieListener<DTOMovie?>? = null
    override fun onBind(item: DTOMovie?, listener: MovieListener<DTOMovie?>?) {
        this.item = item
        this.listener = listener
        var adult = when (item?.getAdult()) {
            true -> "Adult"
            false -> "No adult"
            else -> "No adult"
        }
        item?.setAdultType(adult)
/*
        var path =
            "${RestClient.BASE_URL_IMAGE}${item?.getPosterPath()}"
        item?.setPosterPath(path)
*/
        Log.e(TAG, "onBind: ${item?.getPosterPath()}")
        binding.items = item
    }


    init {
        binding = itemView
        binding.btnBook.setOnClickListener({
            listener?.onClickToBook(item)
            var args= Bundle()
            args.putString("id",item?.getId().toString())
            Navigator.navigateToDetail(args)
        })
    }
}
