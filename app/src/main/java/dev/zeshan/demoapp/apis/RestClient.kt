package dev.zeshan.demoapp.apis

import androidx.databinding.library.BuildConfig
import com.google.gson.GsonBuilder
import dev.zeshan.demoapp.models.APIResponse
import dev.zeshan.demoapp.models.DTOMovie
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {

    companion object {
        var webService: WebService? = null
        private var retrofit: Retrofit? = null
        val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w500/"
        val BASE_URL = "https://api.themoviedb.org/3/movie/"
        val apiKey = "f15d1b35a6ac84a33a15c2d635face6a"

        private fun getRetrofit(): Retrofit? {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                httpClient.addInterceptor(logging)
            }
            val gson = GsonBuilder()
                .serializeNulls()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url()
                val url = originalHttpUrl.newBuilder()
                    .build()
                val requestBuilder = original.newBuilder()
                    .url(url)
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            httpClient.readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build()
            //        }
            return retrofit
        }

        fun getClient(): WebService? {
            if (webService == null) {
                webService = getRetrofit()!!.create(WebService::class.java)
            }
            return webService
        }


        fun movieList(
            resultLitener: APIResultListener<APIResponse<ArrayList<DTOMovie>?>?>
        ) {
            val apiResponseCall: Call<APIResponse<ArrayList<DTOMovie>?>?>? =
                getClient()?.movieList(apiKey)
            apiResponseCall?.enqueue(object : Callback<APIResponse<ArrayList<DTOMovie>?>?> {
                override fun onResponse(
                    call: Call<APIResponse<ArrayList<DTOMovie>?>?>,
                    response: Response<APIResponse<ArrayList<DTOMovie>?>?>
                ) {
                    resultLitener.onAPIResult(response.body(), null)
                }

                override fun onFailure(
                    call: Call<APIResponse<ArrayList<DTOMovie>?>?>,
                    t: Throwable
                ) {
                    resultLitener.onAPIResult(null, t.message)
                }
            })
        }

    }
}