package dev.zeshan.demoapp.utils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dev.zeshan.demoapp.R
import dev.zeshan.demoapp.apis.RestClient


class AppDataConfig {
    lateinit var navigationManager: NavigationManager

    companion object {
        private var instance: AppDataConfig? = null
        fun getInstance(): AppDataConfig? {
            if (instance == null) {
                instance = AppDataConfig()
            }
            return instance
        }

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun imageLoading(view: ImageView, url: String) {
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.joker)
                .error(R.drawable.joker)
            url?.let {
                Glide.with(view.context)
                    .load("${RestClient.BASE_URL_IMAGE}${it}").into(view)
                    .apply { options }

            }


        }
    }
}