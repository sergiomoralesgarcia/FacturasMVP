package com.example.facturasmvp.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.facturasmvp.Factura
import com.example.facturasmvp.FacturaAdapter
import com.example.facturasmvp.databinding.ActivityMainBinding
import com.example.facturasmvp.detail.DetailActivity
import com.example.facturasmvp.filter.FilterActivity

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FacturaAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.FacturaList
        recycler.layoutManager = LinearLayoutManager(this)
        adapter = FacturaAdapter()
        adapter.setOnItemClickListener {
            Toast.makeText(this, "Text", Toast.LENGTH_SHORT).show()
        }

        recycler.adapter = adapter

        val mainPresenter = MainPresenter(this, MainApi())
        mainPresenter.getSongs()

        // abrir página filtros
        binding.botonFactura.setOnClickListener {
            startActivity(Intent(this, FilterActivity::class.java))
        }
        // abrir popup presionando en el contenedor del recycler
        adapter.onItemClick = {
            val dialog = DetailActivity()

            dialog.show(supportFragmentManager, "customDialog")
        }

    }

    override fun showSongs(songList: MutableList<Factura>) {
        adapter.submitList(songList)

    }

}