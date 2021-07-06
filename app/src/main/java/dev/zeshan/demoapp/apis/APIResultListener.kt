package dev.zeshan.demoapp.apis


interface APIResultListener<T> {
    fun onAPIResult(response: T, errorMessage: String?)
}
