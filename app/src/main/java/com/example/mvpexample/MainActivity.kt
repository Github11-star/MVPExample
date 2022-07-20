package com.example.mvpexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpexample.contracts.MainActivityContract
import com.example.mvpexample.model.MainModel
import com.example.mvpexample.network.api.ApiService
import com.example.mvpexample.network.model.UniversityDTO
import com.example.mvpexample.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    @Inject
    private lateinit var apiService : ApiService
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this,MainModel(apiService))
    }

    override fun onLoading() {

    }

    override fun onSuccess(list: List<UniversityDTO>) {

    }

    override fun onError(message: String) {

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}