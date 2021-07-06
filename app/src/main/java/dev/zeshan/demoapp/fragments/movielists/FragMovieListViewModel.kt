package dev.zeshan.demoapp.fragments.movielists

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.zeshan.demoapp.apis.APIResultListener
import dev.zeshan.demoapp.apis.RestClient
import dev.zeshan.demoapp.models.APIResponse
import dev.zeshan.demoapp.models.DTOMovie

class FragMovieListViewModel : ViewModel() {

    var movieList = MutableLiveData<ArrayList<DTOMovie>>()
    fun getMovieList() {
        RestClient.movieList(object : APIResultListener<APIResponse<ArrayList<DTOMovie>?>?> {
            override fun onAPIResult(
                response: APIResponse<ArrayList<DTOMovie>?>?,
                errorMessage: String?
            ) {
                if (response != null && errorMessage == null) {
                    movieList.value = response?.data
                } else if (response == null && errorMessage != null) {
                }
            }
        })
    }
}