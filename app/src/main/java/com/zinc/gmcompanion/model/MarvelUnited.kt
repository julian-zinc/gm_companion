package com.zinc.gmcompanion.model

import android.view.View
import com.zinc.gmcompanion.service.OpenAIService
import kotlinx.android.synthetic.main.marvel_united_fragment.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarvelUnited {
    private lateinit var openAIService: OpenAIService
    lateinit var heroesSeleccionados: String
    lateinit var villanoSeleccionado: String
    lateinit var ubicacionVillano: String
    lateinit var ubicacionHeroes: String

    private fun getFullHeroList(): List<String> {
        return listOf(
            "Ant-Man",
            "Viuda Negra",
            "Capitán América",
            "Capitana Marvel",
            "Hulk",
            "Iron Man",
            "Avispa",
            "Iron Spider",
            "Spider cerdo",
            "Bill Rayos Beta",
            "Spiderman",
            "Miles Morales",
            "Ghost Spider",
            "Lobezno",
            "Cíclope",
            "Tormenta",
            "Jean Grey",
            "Profesor X",
            "Bestia",
            "Mística",
            "Magneto"
        )
    }

    private fun getFullVillainList(): List<String> {
        return listOf(
            "Cráneo Rojo",
            "Ultrón",
            "Taskmaster",
            "Rhino",
            "Lagarto",
            "Green Goblin",
            "Mística",
            "Magneto",
            "Dientes de sable",
            "Juggernaut"
        )
    }

    private fun getFullLocationList(): List<String> {
        return listOf(
            "Cuartel general de S.H.I.E.L.D.",
            "Laboratorio Stark",
            "Central Park",
            "Mansión de los Vengadores",
            "Times Square",
            "Torre de los Vengadores",
            "Helitransporte de S.H.I.E.L.D.",
            "Cuartel general de la policía de Nueva York"
        )
    }

    fun generateMarvelGame(view: View) {
        heroesSeleccionados =
            selectNFromList(Integer.valueOf(view.players_value?.text.toString()), getFullHeroList())
        view.heroes?.text = "Héroes: $heroesSeleccionados"

        villanoSeleccionado = selectNFromList(1, getFullVillainList())
        while (heroesSeleccionados.contains(villanoSeleccionado)) {
            villanoSeleccionado = selectNFromList(1, getFullVillainList())
        }

        view.villain?.text = "Villano: $villanoSeleccionado"
/*
        ubicacionHeroes = selectNFromList(1, getFullLocationList())
        view.hero_location?.text = "Ubicación: $ubicacionHeroes"

        ubicacionVillano = selectNFromList(1, getFullLocationList())
        while (ubicacionVillano == ubicacionHeroes) {
            ubicacionVillano = selectNFromList(1, getFullLocationList())
        }
        view.villain_location?.text = "Ubicación: $ubicacionVillano"*/
    }

    private fun selectNFromList(n: Int, list: List<String>): String =
        list.shuffled().take(n).joinToString(", ")

    fun generateMarvelEvent(view: View) {

        val retrofit = Retrofit.Builder().baseUrl("https://api.openai.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        openAIService = retrofit.create(OpenAIService::class.java)

        val input =
            "En dos frases cortas, explica el plan del villano ${villanoSeleccionado} y cómo los héroes (${heroesSeleccionados}) van a tratar de detenerle"
        val request = ChatRequest(
            model = "gpt-4.1-nano", store = true, messages = listOf(Message("user", input))
        )
        openAIService.chat(request).enqueue(object : Callback<ChatResponse> {
            override fun onResponse(
                call: Call<ChatResponse>, response: Response<ChatResponse>
            ) {
                if (response.isSuccessful) {
                    val message = response.body()?.choices?.firstOrNull()?.message?.content
                    view.scene?.text = message ?: "Sin respuesta."

                    view.clear_scene?.visibility = View.VISIBLE
                    view.scene?.visibility = View.VISIBLE
                } else {
                    view.scene?.text = "Error: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                view.scene?.text = "Fallo: ${t.message}"
            }
        })
    }
}