package com.example.facturasmvp.main

import com.example.facturasmvp.Factura


class MainApi: MainContract.Api {

    override fun downloadFacturas(successListener: (MutableList<Factura>) -> Unit) {
        val random = (0..10).random()

        val facturaList = mutableListOf<Factura>()

        facturaList.add(Factura(0,"Pendiente de pago", 1.5600000000000001, "07/02/2019"))
        facturaList.add(Factura(1,"Pagada", 25.140000000000001, "05/02/2019"))
        facturaList.add(Factura(2,"Pagada", 22.690000000000001, "08/01/2019"))
        facturaList.add(Factura(3,"Pendiente de pago", 12.84, "07/12/2018"))
        facturaList.add(Factura(4,"Pagada", 35.159999999999997, "16/11/2018"))
        facturaList.add(Factura(5,"Pagada", 18.27, "05/10/2018"))
        facturaList.add(Factura(6,"Pendiente de pago", 61.170000000000002, "05/09/2018"))
        facturaList.add(Factura(7,"Pagada", 37.18, "07/08/2018"))

        successListener(facturaList)

    }

}