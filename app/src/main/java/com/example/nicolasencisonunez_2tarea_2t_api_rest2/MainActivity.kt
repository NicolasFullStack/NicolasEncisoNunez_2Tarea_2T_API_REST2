package com.example.nicolasencisonunez_2tarea_2t_api_rest2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nicolasencisonunez_2tarea_2t_api_rest2.Model.Movie
import com.example.nicolasencisonunez_2tarea_2t_api_rest2.Model.SeriesResponse
import com.example.nicolasencisonunez_2tarea_2t_api_rest2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    //La palabra clave lateinit en Kotlin se utiliza para declarar una variable que
    //se inicializará más tarde, es decir, no se inicializa en el momento de la declaración.
    //Esto es útil para variables que no pueden ser inicializadas en el momento de la declaración,
    //pero se garantiza que se inicializarán antes de su uso.
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: MovieAdapter
    private val seriesList = mutableListOf<Movie>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Para poder acceder a todos los elementos que necesitamos inicializamos el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Cambio el setContentView por el binding.root para simplificar el acceso a las vistas
        //Esto procede del build.gradle.kts(.app)
        setContentView(binding.root)

        //Nos lo incluye android en las ultimas versiones para mejorar la visibilidad de la pantalla
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        displayMovies()
        fetchMovies("series")
    }
    //Genera el recicleview
    private fun displayMovies() {
        adapter = MovieAdapter(seriesList)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter
    }

    //6. Configura la instancia de Retrofit en Kotlin:
    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://peticiones.online/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    //7. Crea la función fetchMovies para hacer la solicitud de datos en el MainActivity
    // Funcion para el manejo de las llamadas asincronas o corrutinas.
    // Dispatchers.IO es la mas optima para peticiones
    // launch lanza esta corrutina
    // Funcionalidad para pedir datos
    private fun fetchMovies(query : String){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<SeriesResponse> = getRetrofit()
                .create(MovieApiService::class.java)
                .getAllSeries(query)

            val series :SeriesResponse? = call.body()
            if (series !=null){
                for(miserie: Movie in series){
                    Log.v("Series",miserie.toString())
                }
            }
            //hilo de la interfazGrafica se encarga de las imagenes en su hilo propio
            runOnUiThread {
                if(call.isSuccessful){
                    val seriesL = series?: emptyList()
                    seriesList.clear()
                    seriesList.addAll(seriesL)
                    adapter.notifyDataSetChanged()
                }else{
                    showError()
                }
            }
        }
    }

            // 10. anejo de errores Se define la función showError para mostrar
            // un mensaje de error si la llamada a la  API falla
            private fun showError(){
                Toast.makeText(this, "Se ha producido un error, intentelo de nuevo", Toast.LENGTH_SHORT).show()
           }
}