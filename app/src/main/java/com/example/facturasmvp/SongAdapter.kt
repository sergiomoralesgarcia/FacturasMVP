package com.example.facturasmvp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.facturasmvp.databinding.SongListItemBinding

class FacturaAdapter : ListAdapter<Factura, FacturaAdapter.ViewHolder>(
    DiffCallback
) {

    var onItemClick : ((Factura) -> Unit)? = null

    companion object DiffCallback : DiffUtil.ItemCallback<Factura>() {
        override fun areItemsTheSame(oldItem: Factura, newItem: Factura): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Factura, newItem: Factura): Boolean {
            return oldItem.idFac == newItem.idFac
        }
    }

    private lateinit var onItemClickListener: ((earthquake: Factura) -> Unit)

    fun setOnItemClickListener(onItemClickListener: (earthquake: Factura) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SongListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val factura = getItem(position)
        holder.bind(factura)

        // presionar en el contenedor del adapter
        val factura2 = getItem(position)
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(factura2)
        }
    }

    inner class ViewHolder(private val binding: SongListItemBinding): RecyclerView.ViewHolder(binding.root) {
        var container: ConstraintLayout? = null

        init {
            container = itemView.findViewById(R.id.itemContainer)
        }

        fun bind(factura: Factura) {
            val context = binding.importeOrdenacion.context
            binding.importeOrdenacion.text = context.getString(R.string.song_name_author_format,
                factura.importeOrdenacion.toString())

            binding.descEstado.text = context.getString(R.string.song_name_author_format,
                factura.descEstado)

            binding.fecha.text = context.getString(R.string.song_name_author_format,
                factura.fecha)

        }
    }
}