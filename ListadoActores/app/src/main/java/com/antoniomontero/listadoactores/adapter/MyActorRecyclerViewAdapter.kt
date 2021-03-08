package com.antoniomontero.listadoactores.adapter


import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import coil.load
import com.antoniomontero.listadoactores.poko.ActorResponse

class MyActorRecyclerViewAdapter(
    private var values: List<ActorResponse>
) : RecyclerView.Adapter<MyActorRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_actor, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewId: TextView = view.findViewById(R.id.text_view_id)
        val textViewName: TextView = view.findViewById(R.id.text_view_name)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = values[position]
        val id = currentItem.url.reversed().split("/")[1].reversed()
        holder.textViewId.text = id
        holder.textViewName.text = currentItem.name.capitalize()
    }

    fun setData(newActorResponses: List<ActorResponse>) {
        this.values = newActorResponses
        // Refresca la IU para que se muestren los nuevos
        // Pokemon en la lista
        notifyDataSetChanged()
    }



}