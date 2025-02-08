package com.example.nicolasencisonunez_2tarea_2t_api_rest2.Model

data class Movie(
    val _id: String,
    val channel: String,
    val creator: String,
    val dates: String,
    val id: Int,
    val image: String,
    val rating: Double,
    val title: String
)
//Uso el plugin json to kotlin del ejemplo
//Crea el data class y una clase que contiene