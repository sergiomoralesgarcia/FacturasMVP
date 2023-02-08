package com.example.facturasmvp.main

import com.example.facturasmvp.Factura

interface MainContract {

    interface View {
        fun showFacturas(facturaList: MutableList<Factura>)
    }

    interface Presenter {
        fun getFacturas()
    }

    interface Api {
        fun downloadFacturas(successListener: (MutableList<Factura>) -> Unit)
    }
}



