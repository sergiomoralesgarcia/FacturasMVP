package com.example.facturasmvp.main

import com.example.facturasmvp.Factura

interface MainContract {

    interface View {
        fun showSongs(facturaList: MutableList<Factura>)
    }

    interface Presenter {
        fun getSongs()
    }

    interface Api {
        fun downloadSongs(successListener: (MutableList<Factura>) -> Unit)
    }
}



