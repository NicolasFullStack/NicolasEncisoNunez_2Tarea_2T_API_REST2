package com.example.nicolasencisonunez_2tarea_2t_api_rest2

import com.example.nicolasencisonunez_2tarea_2t_api_rest2.Model.SeriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url



//Creacion de interface para la PETICION a la API con RETROFIT
interface MovieApiService {

    //llamada de retrofit , peticion http con get que es Asincrono
    //(Pedimos y no sabemos cuanto tiempo tarda en responder)
    //Es una promesa, no sabemos que sucedera y tenemos que esperar Suspend (peticion asincrona)

    //Podemos definir tantas peticiones como quiera GET, POST, PUT, DELETE
    @GET
    suspend fun getAllSeries(@Url url : String): Response<SeriesResponse>

}