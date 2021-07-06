package dev.zeshan.demoapp.fragments.moviedetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.zeshan.demoapp.apis.RestClient
import dev.zeshan.demoapp.models.DTOMovieDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragMovieDetailViewModel : ViewModel() {
    var movieDetail = MutableLiveData<DTOMovieDetail>()

    fun getMovieDetail(id: String) {
        val apiResponseCall: Call<DTOMovieDetail>? =
            RestClient.getClient()?.movieDetail(id, RestClient.apiKey)
        apiResponseCall?.enqueue(
            object : Callback<DTOMovieDetail> {
                override fun onResponse(
                    call: Call<DTOMovieDetail>,
                    response: Response<DTOMovieDetail>
                ) {
                    movieDetail.value = response.body()
                }

                override fun onFailure(call: Call<DTOMovieDetail>, t: Throwable) {

                }
            }
        )
    }
}