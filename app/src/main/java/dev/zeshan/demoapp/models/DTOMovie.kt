package dev.zeshan.demoapp.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class DTOMovie {
    @SerializedName("adult")
    @Expose
    private var adult: Boolean = false

    @SerializedName("backdrop_path")
    @Expose
    private var backdropPath: String? = null

    @SerializedName("genre_ids")
    @Expose
    private var genreIds: List<Int?>? = null

    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("original_language")
    @Expose
    private var originalLanguage: String? = null

    @SerializedName("original_title")
    @Expose
    private var originalTitle: String? = null

    @SerializedName("overview")
    @Expose
    private var overview: String? = null

    @SerializedName("popularity")
    @Expose
    private var popularity: Double? = null

    @SerializedName("poster_path")
    @Expose
    private var posterPath: String? = null

    @SerializedName("release_date")
    @Expose
    private var releaseDate: String? = null

    @SerializedName("title")
    @Expose
    private var title: String? = null

    @SerializedName("video")
    @Expose
    private var video: Boolean? = null

    @SerializedName("vote_average")
    @Expose
    private var voteAverage: Double? = null

    @SerializedName("vote_count")
    @Expose
    private var voteCount: Int? = null
    private var adultType: String? = null

    fun getAdultType(): String? {
        return adultType
    }

    fun getAdult(): Boolean {
        return adult
    }

    fun setAdultType(adult: String?) {
        this.adultType = adult
    }

    fun setAdult(adult: Boolean) {
        this.adult = adult
    }

    fun getBackdropPath(): String? {
        return backdropPath
    }

    fun setBackdropPath(backdropPath: String?) {
        this.backdropPath = backdropPath
    }

    fun getGenreIds(): List<Int?>? {
        return genreIds
    }

    fun setGenreIds(genreIds: List<Int?>?) {
        this.genreIds = genreIds
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getOriginalLanguage(): String? {
        return originalLanguage
    }

    fun setOriginalLanguage(originalLanguage: String?) {
        this.originalLanguage = originalLanguage
    }

    fun getOriginalTitle(): String? {
        return originalTitle
    }

    fun setOriginalTitle(originalTitle: String?) {
        this.originalTitle = originalTitle
    }

    fun getOverview(): String? {
        return overview
    }

    fun setOverview(overview: String?) {
        this.overview = overview
    }

    fun getPopularity(): Double? {
        return popularity
    }

    fun setPopularity(popularity: Double?) {
        this.popularity = popularity
    }

    fun getPosterPath(): String? {
        return posterPath
    }

    fun setPosterPath(posterPath: String?) {
        this.posterPath = posterPath
    }

    fun getReleaseDate(): String? {
        return releaseDate
    }

    fun setReleaseDate(releaseDate: String?) {
        this.releaseDate = releaseDate
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getVideo(): Boolean? {
        return video
    }

    fun setVideo(video: Boolean?) {
        this.video = video
    }

    fun getVoteAverage(): Double? {
        return voteAverage
    }

    fun setVoteAverage(voteAverage: Double?) {
        this.voteAverage = voteAverage
    }

    fun getVoteCount(): Int? {
        return voteCount
    }

    fun setVoteCount(voteCount: Int?) {
        this.voteCount = voteCount
    }

}