package com.example.facturasmvp.filter

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.DatePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import android.widget.SeekBar
import android.widget.TextView
import com.example.facturasmvp.Factura
import com.example.facturasmvp.FacturaAdapter
import com.example.facturasmvp.databinding.ActivityFilterBinding
import com.example.facturasmvp.main.MainActivity
import com.google.android.material.snackbar.Snackbar
import java.util.*

class FilterActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var binding: ActivityFilterBinding
    private lateinit var adapter: FacturaAdapter
    private lateinit var sp: SharedPreferences

    private var datos: MutableList<Factura> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Botón de cancelar los filtros
        binding.cancelButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Calendario
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        binding.buttonDate1.setOnClickListener() {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    binding.buttonDate1.setText("" + mDay + "/" + (mMonth + 1) + "/" + mYear)
                },
                year,
                month,
                day
            )
            dpd.show()
            // fecha máxima que puedes seleccionar
            dpd.datePicker.maxDate = c.timeInMillis
        }

        binding.buttonDate2.setOnClickListener() {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    binding.buttonDate2.setText("" + mDay + "/" + (mMonth + 1) + "/" + mYear)
                },
                year,
                month,
                day
            )
            dpd.show()
            // fecha máxima que puedes seleccionar
            dpd.datePicker.maxDate = c.timeInMillis
        }

        // Cambio progresivo de la cantidad del SeekBar
        var progressView: TextView? = null
        var seekBar: SeekBar? = null

        progressView = this.binding.cantidad2
        seekBar = this.binding.seekBar
        seekBar!!.setOnSeekBarChangeListener(this)

        // Botón de aplicar los filtros
        with(binding){

            botonAplicar.setOnClickListener {
                // recuperamos el valor
                val valorUmbral = buttonDate1.text
                val valorFecha2 = buttonDate2.text
                val valorNivel  = seekBar.isSelected
                //val valorNivel = spnDificultad.selectedItem // devuelve la cadena entre etiquetas <item>

                //
                if (valorUmbral=="") {
                    // Si el cuadro del umbral está vacío, mostramos un mensaje de error
                    Snackbar.make(it, "ERROR", Snackbar.LENGTH_LONG).show()
                } else {
                    // guardamos si hay algún valor

                    // volvemos a la actividad anterior
                    finish()
                    return@setOnClickListener
                }
            }
        }

        // Botón de eliminar los filtros
        binding.botonEliminar.setOnClickListener {
            startActivity(Intent(this, FilterActivity::class.java))
        }
    }

    // importaciones del SeekBar
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        binding.cantidad2!!.text = progress.toString()
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {}
    override fun onStopTrackingTouch(p0: SeekBar?) {}
}