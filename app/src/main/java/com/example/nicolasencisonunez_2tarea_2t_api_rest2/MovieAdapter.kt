package com.example.nicolasencisonunez_2tarea_2t_api_rest2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nicolasencisonunez_2tarea_2t_api_rest2.Model.Movie



//recibo una lista de imagenes
class MovieAdapter (val series: List<Movie>):RecyclerView.Adapter<MovieViewHolder>(){


    //implemen tos los 3 metodos a los que me obliga
    // Siempre se sigue el mismo proceso
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.itemserie, parent, false))

    }
    //Devuelve el numero de elementos  de imagenes que tiene .size
    override fun getItemCount(): Int {
        return series.size
    }
    //recoge el valor del elemento
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item :Movie = series[position]
        holder.bind(item)
    }


}