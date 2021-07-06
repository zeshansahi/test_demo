package dev.zeshan.demoapp.apis

import dev.zeshan.demoapp.models.APIResponse
import dev.zeshan.demoapp.models.DTOMovie
import dev.zeshan.demoapp.models.DTOMovieDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {

    @GET("upcoming")
    fun movieList(
        @Query("api_key")  apiKey:String
    ): Call<APIResponse<ArrayList<DTOMovie>?>?>?

    @GET("{Id}")
    fun movieDetail(
        @Path("Id")id:String,
        @Query("api_key")  apiKey:String
    ): Call<DTOMovieDetail>?

}