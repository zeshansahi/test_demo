package dev.zeshan.demoapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class APIResponse<T> {

    @SerializedName("results")
    @Expose
    var data: T? = null
        private set

    @SerializedName("total_pages")
    @Expose
    var totalPages = 0

    @SerializedName("current_page")
    @Expose
    var currentPage = 0


}
