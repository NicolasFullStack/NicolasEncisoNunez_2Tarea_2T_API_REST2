package com.example.nicolasencisonunez_2tarea_2t_api_rest2

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.nicolasencisonunez_2tarea_2t_api_rest2.Model.Movie
import com.example.nicolasencisonunez_2tarea_2t_api_rest2.databinding.ItemserieBinding
import com.squareup.picasso.Picasso



// Recibe la vista que queremos cargar (view) es la vista que le vamos a pasar
class MovieViewHolder (view: View) :RecyclerView.ViewHolder(view){
    //Le defino la vista que yo le doy
    private val binding = ItemserieBinding.bind(view)



    //funcion que recibe la string los datos que es la urg de la api, asi puedo ver los carteles de las peliculas
    // cargo la libreria de las imagenes en el imageView
    fun bind (serie: Movie){
        Picasso.get().load(serie.image).into(binding.ivSerie)
        binding.tvTitulo.setText("Titulo: "+serie.title)
        binding.tvCreator.setText("Director: "+serie.creator)
        binding.tvPuntuacion.setText("Puntuacion: "+serie.rating.toString())
        binding.tvfecha.setText("Fecha: "+serie.dates)
        binding.tvCanal.setText(("canal: "+serie.channel))
    }

}