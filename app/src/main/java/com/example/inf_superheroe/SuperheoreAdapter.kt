package com.example.inf_superheroe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SuperheoreAdapter(
    private val items: List<Superheores>,
    private val onItemClick: ((Superheores) -> Unit)? = null
) : RecyclerView.Adapter<SuperheoreAdapter.SuperheoreViewHolder>() {

    class SuperheoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.textView)
        val descripcion: TextView = itemView.findViewById(R.id.textView2)
        val foto: ImageView = itemView.findViewById(R.id.img_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheoreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_targetheroe, parent, false)
        return SuperheoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheoreViewHolder, position: Int) {
        val item = items[position]
        holder.nombre.text = item.idname
        holder.descripcion.text = item.iddescripcion
        holder.foto.setImageResource(item.idfoto)
        holder.itemView.setOnClickListener { onItemClick?.invoke(item) }
    }

    override fun getItemCount(): Int = items.size
}
