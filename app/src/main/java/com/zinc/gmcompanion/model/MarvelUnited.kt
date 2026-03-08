package com.zinc.gmcompanion.model

import android.view.View
import com.zinc.gmcompanion.service.OpenAIService
import com.zinc.gmcompanion.databinding.MarvelUnitedFragmentBinding
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

    private var previousHeroes: List<String> = emptyList()

    private fun getFullHeroList(): List<String> {
        return listOf(
            "Ant-Man",
            "Black Widow",
            "Captain America",
            "Captain Marvel",
            "Hulk",
            "Iron Man",
            "Wasp",
            "Iron Spider",
            "Spider-Ham",
            "Bill Ray Beta",
            "Spider-Man",
            "Miles Morales",
            "Ghost-Spider",
            "Wolverine",
            "Ciclops",
            "Storm",
            "Jean Grey",
            "Professor X",
            "Beast",
            "Mystique",
            "Magneto",
            "Winter Soldier",
            "Shuri",
            "Black Panther",
            "Peni Parker",
            "Scarlet Spider",
            "Silk",
            "Spider-Man Noir",
            "Spider-Punk",
            "Symbiote Spider-Man",
            "Anti-Venom",
            "Superior Spider-Man"
        )
    }

    private fun getFullVillainList(): List<String> {
        return listOf(
            "Red Skull",
            "Ultron",
            "Taskmaster",
            "Rhino",
            "Lizard",
            "Green Goblin",
            "Mystique",
            "Magneto",
            "Sabretooth",
            "Juggernaut",
            "Anti-Venom",
            "Superior Spider-Man",
            "Morlun",
            "Spot",
            "Killmonger"
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

    private fun getPersistentVillains(context: android.content.Context): MutableList<String> {
        val prefs = context.getSharedPreferences("MarvelUnitedPrefs", android.content.Context.MODE_PRIVATE)
        val villainsString = prefs.getString("previousVillains", "") ?: ""
        return if (villainsString.isEmpty()) mutableListOf() else villainsString.split("|").toMutableList()
    }

    private fun savePersistentVillains(context: android.content.Context, villains: List<String>) {
        val prefs = context.getSharedPreferences("MarvelUnitedPrefs", android.content.Context.MODE_PRIVATE)
        prefs.edit().putString("previousVillains", villains.joinToString("|")).apply()
    }

    fun generateMarvelGame(binding: MarvelUnitedFragmentBinding, context: android.content.Context) {
        val numPlayers = Integer.valueOf(binding.playersValue.text.toString())
        
        // Select heroes excluding previous ones from current session
        val availableHeroes = getFullHeroList().filter { !previousHeroes.contains(it) }
        val selectedHeroesList = availableHeroes.shuffled().take(numPlayers)
        
        previousHeroes = selectedHeroesList
        heroesSeleccionados = selectedHeroesList.joinToString("\n• ", prefix = "• ")
        binding.heroes.text = "Héroes:\n$heroesSeleccionados"

        // Select villain excluding previous 5 (persistent) and current heroes
        val persistentVillains = getPersistentVillains(context)
        val availableVillains = getFullVillainList().filter { 
            !persistentVillains.contains(it) && !selectedHeroesList.contains(it) 
        }
        
        val selectedVillain = if (availableVillains.isNotEmpty()) {
            availableVillains.shuffled().first()
        } else {
            // Fallback if everyone was recently used, pick one not in current heroes
            getFullVillainList().filter { !selectedHeroesList.contains(it) }.shuffled().first()
        }

        // Update persistence: add new one to the end, keep only last 5
        persistentVillains.add(selectedVillain)
        if (persistentVillains.size > 5) {
            persistentVillains.removeAt(0)
        }
        savePersistentVillains(context, persistentVillains)
        
        villanoSeleccionado = selectedVillain
        binding.villain.text = "Villano:\n• $villanoSeleccionado"
    }

    private fun selectNFromList(n: Int, list: List<String>): String =
        list.shuffled().take(n).joinToString(", ")

    fun generateMarvelEvent(binding: MarvelUnitedFragmentBinding, context: android.content.Context) {

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
                    binding.scene.text = message ?: "Sin respuesta."

                    binding.clearScene.visibility = View.VISIBLE
                    binding.scene.visibility = View.VISIBLE
                } else {
                    binding.scene.text = "Error: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                binding.scene.text = "Fallo: ${t.message}"
            }
        })
    }
}