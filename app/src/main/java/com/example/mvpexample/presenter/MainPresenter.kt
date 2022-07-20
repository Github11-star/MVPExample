package com.example.mvpexample.presenter

import com.example.mvpexample.contracts.MainActivityContract
import com.example.mvpexample.network.model.UniversityDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainPresenter(
    private val view: MainActivityContract.View,
    private val model: MainActivityContract.Model
) : MainActivityContract.Presenter, MainActivityContract.Model.OnFinishListener {

    val scope = CoroutineScope(Dispatchers.IO)

    override fun getUniversity(country: String) {
        scope.launch {
            model.fetchUniversity(onFinishListener = this@MainPresenter, country = country)
        }
    }

    override fun onDestroy() {
        scope.cancel()
    }

    override fun onLoading() {
        view.onLoading()
    }

    override fun onError(message: String) {
        view.onError(message)
    }

    override fun onSuccess(list: List<UniversityDTO>) {
        view.onSuccess(list)
    }
}