package com.example.facturasmvp.main

class MainPresenter(private val mainView: MainContract.View,
                    private val mainApi: MainContract.Api) : MainContract.Presenter {
    override fun getFacturas() {
        mainApi.downloadFacturas { facturaList ->
            mainView.showFacturas(facturaList)
        }
    }
}