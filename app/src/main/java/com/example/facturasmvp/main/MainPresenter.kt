package com.example.facturasmvp.main

class MainPresenter(private val mainView: MainContract.View,
                    private val mainApi: MainContract.Api) : MainContract.Presenter {
    override fun getSongs() {
        mainApi.downloadSongs { facturaList ->
            mainView.showSongs(facturaList)
        }
    }
}