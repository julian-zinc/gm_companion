package com.zinc.gmcompanion.model

import android.content.Context
import kotlin.random.Random
import kotlin.random.nextInt

enum class AlphaStrikeMechType { BRAWLER, SKIRMISHER, STRIKER, SNIPER }

class MechIA(val mech: String, val role: AlphaStrikeMechType) {
    val init: String = ""
    val move: String = ""
    val fire: String = ""
}

class MechIACard(val initiative: String, val movement: String, val combat: String)

class AlphaStrikeIA {
    fun generateCard(
        context: Context,
        mechType: AlphaStrikeMechType
    ): MechIACard {
        val card = when (mechType) {
            AlphaStrikeMechType.BRAWLER -> generateBrawlerCard()
            AlphaStrikeMechType.SNIPER -> generateSniperCard()
            AlphaStrikeMechType.SKIRMISHER -> generateSkirmisherCard()
            AlphaStrikeMechType.STRIKER -> generateStrikerCard()
        }
        return card
    }

    private fun generateBrawlerCard(): MechIACard {
        return when (Random.nextInt(1..8)) {
            1 -> MechIACard(
                "20",
                "<b>Si es el primero:</b> SALTA a 12 hex. de todos los enemigos, cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> SALTA a cobertura de la mayoría de enemigos" +
                        "<br><b>2.</b> SALTA hacia el enemigo con menos TMM" +
                        "<br><b>3.</b> CAMINA para que el mínimo de enemigos (min. 1) tenga LOS" +
                        "<br><b>4.</b> CAMINA hacia el enemigo con más PV" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con más salud" +
                        "<br><b>3.</b> Enemigo con menos TMM" +
                        "<br><b>4.</b> Enemigo más cercano"
            )
            2 -> MechIACard(
                "65",
                "<b>Si es el primero:</b> SALTA a 8 hex. de todos los enemigos, cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> CAMINA a cobertura de la mayoría de enemigos" +
                        "<br><b>2.</b> CAMINA hacia el enemigo con más salud" +
                        "<br><b>3.</b> CAMINA hacia el enemigo con más TMM" +
                        "<br><b>4.</b> CAMINA hacia el enemigo con más PV" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo con menos TMM" +
                        "<br><b>2.</b> Enemigo destruible" +
                        "<br><b>3.</b> Enemigo con más salud" +
                        "<br><b>4.</b> Enemigo sin cobertura" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            3 -> MechIACard(
                "135",
                "<b>Si es el primero:</b> SALTA a 12 hex. de todos los enemigos, sin LOS o con máxima cobertura" +
                        "<br><b>1.</b> CAMINA hacia el enemigo con menos salud si éste está a más de 12 hex." +
                        "<br><b>2.</b> SALTA para que el mínimo de enemigos (min. 1) tenga LOS" +
                        "<br><b>3.</b> SALTA a cobertura de la mayoría de enemigos" +
                        "<br><b>4.</b> CAMINA hacia el enemigo más cercano",
                "Sobrecalienta." +
                        "<br><b>1.</b> Enemigo con menos TMM" +
                        "<br><b>2.</b> Enemigo destruible" +
                        "<br><b>3.</b> Enemigo criticable" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            4 -> MechIACard(
                "195",
                "<b>Si es el primero:</b> SALTA a 8 hex. del enemigo más cercano, sin LOS y cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> SALTA a cobertura de la mayoría de enemigos" +
                        "<br><b>2.</b> SALTA hacia el enemigo con más salud" +
                        "<br><b>3.</b> CAMINA hacia el enemigo con menos MV" +
                        "<br><b>4.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>2.</b> Enemigo destruible" +
                        "<br><b>3.</b> Enemigo sin cobertura" +
                        "<br><b>4.</b> Enemigo con menos TMM" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            5 -> MechIACard(
                "256",
                "<b>Si es el primero:</b> SALTA a 6 hex. del enemigo más cercano, sin LOS y cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> CAMINA hacia el enemigo con más salud" +
                        "<br><b>2.</b> CAMINA hacia el enemigo de mayor amenaza" +
                        "<br><b>3.</b> CAMINA para que el mínimo de enemigos (min. 1) tenga LOS" +
                        "<br><b>4.</b> CAMINA hacia el enemigo con más PV" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo con menos TMM" +
                        "<br><b>2.</b> Enemigo destruible" +
                        "<br><b>3.</b> Enemigo más cercano"
            )
            6 -> MechIACard(
                "410",
                "<b>Si es el primero:</b> SALTA para tener LOS con el máximo de enemigos, cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> CAMINA para tener LOS con el máximo de enemigo" +
                        "<br><b>2.</b> CAMINA para estar cubierto del máximo de enemigos" +
                        "<br><b>3.</b> CAMINA hacia el enemigo con menos TMM" +
                        "<br><b>4.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>2.</b> Enemigo destruible" +
                        "<br><b>3.</b> Enemigo con menos TMM" +
                        "<br><b>4.</b> Enemigo sin cobertura" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            7 -> MechIACard(
                "575",
                "<b>Si es el primero:</b> SALTA para tener LOS con el máximo de enemigos, cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> QUIETO si no hay enemigos en 8 hex. y al menos un enemigo en LOS con TMM 1 ó menos" +
                        "<br><b>2.</b> CAMINA para estar cubierto del máximo de enemigos" +
                        "<br><b>3.</b> CAMINA hacia el enemigo de mayor amenaza" +
                        "<br><b>4.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>3.</b> Enemigo con menos TMM" +
                        "<br><b>4.</b> Enemigo sin cobertura" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            8 -> MechIACard(
                "798",
                "<b>Si es el primero:</b> CAMINA a 6 hex. del enemigo más cercano y sin enemigos con LOS o cubierto del máximo de enemigos" +
                        "<br><b>1.</b> QUIETO si no hay enemigos en 6 hex. y al menos un enemigo en LOS con TMM 1 ó menos" +
                        "<br><b>2.</b> CAMINA para estar cubierto del máximo de enemigos" +
                        "<br><b>3.</b> CAMINA hacia el enemigo de mayor amenaza" +
                        "<br><b>4.</b> CAMINA para tener al mínimo de enemigos en LOS" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "Sobrecalienta." +
                        "<br><b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con más TMM" +
                        "<br><b>3.</b> Enemigo más cercano"
            )
            else -> {
                MechIACard("X", "X", "X")
            }
        }
    }

    private fun generateSniperCard(): MechIACard {
        return when (Random.nextInt(1..8)) {
            1 -> MechIACard(
                "212",
                "<b>Si es el primero:</b> SPRINT a 24 hex. de todos los enemigos, con el mínimo de enemigos en LOS" +
                        "<br><b>1.</b> SALTA a 9 hex. de todos los enemigos si hay enemigos a 6 ó menos hex." +
                        "<br><b>2.</b> SALTA hacia la mayor altura" +
                        "<br><b>3.</b> CAMINA para tener al máximo de aliados en LOS, encarando al máximo de enemigos" +
                        "<br><b>4.</b> CAMINA para tener LOS con el enemigo con menos TMM" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con menos TMM" +
                        "<br><b>3.</b> Enemigo sin cobertura" +
                        "<br><b>4.</b> Enemigo de mayor amenaza" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            2 -> MechIACard(
                "236",
                "<b>Si es el primero:</b> CAMINA a 15 hex. y LOS del máximo de enemigos, cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> SALTA a 9 hex. de todos los enemigos si hay enemigos a 6 ó menos hex." +
                        "<br><b>2.</b> SALTA hacia la mayor altura" +
                        "<br><b>3.</b> CAMINA para tener al máximo de aliados en LOS, encarando al máximo de enemigos" +
                        "<br><b>4.</b> CAMINA para tener LOS con el enemigo con menos TMM" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con menos TMM" +
                        "<br><b>3.</b> Enemigo sin cobertura" +
                        "<br><b>4.</b> Enemigo de mayor amenaza" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            3 -> MechIACard(
                "243",
                "<b>Si es el primero:</b> CAMINA a 12 hex. y LOS del enemigo más cercano, con cobertura del máximo de enemigos" +
                        "<br><b>1.</b> CAMINA a 12 hex. del enemigo más cercano" +
                        "<br><b>2.</b> CAMINA a cobertura de la mayoría de enemigos" +
                        "<br><b>3.</b> CAMINA para tener LOS con el enemigo con menos TMM" +
                        "<br><b>4.</b> CAMINA para tener LOS con el enemigo más cercano en 12 hex." +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con  menos TMM" +
                        "<br><b>3.</b> Enemigo sin cobertura" +
                        "<br><b>4.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            4 -> MechIACard(
                "387",
                "<b>Si es el primero:</b> CAMINA a 15 hex. y LOS del enemigo más cercano, con cobertura del máximo de enemigos" +
                        "<br><b>1.</b> CAMINA a cobertura de la mayoría de enemigos" +
                        "<br><b>2.</b> CAMINA  para tener LOS con el enemigo con menos salud" +
                        "<br><b>3.</b> CAMINA para tener LOS con el mínimo de enemigos (min. 1)" +
                        "<br><b>4.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo con menos salud" +
                        "<br><b>2.</b> Enemigo con menos TMM" +
                        "<br><b>3.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>4.</b> Enemigo más cercano"
            )
            5 -> MechIACard(
                "617",
                "<b>Si es el primero:</b> SALTA a 15 hex. y LOS de la mayoría de enemigos, cubierto del máximo de enemigos" +
                        "<br><b>1.</b> QUIETO si estás cubierto de todos los enemigos y al menos 1 enemigo con LOS" +
                        "<br><b>2.</b> SALTA a cobertura de la mayoría de enemigos" +
                        "<br><b>3.</b> CAMINA para tener LOS con el enemigo con menos salud" +
                        "<br><b>4.</b> CAMINA hacia el enemigo más cercano",
                "Sobrecalienta." +
                        "<br><b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con menos TMM" +
                        "<br><b>3.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>4.</b> Enemigo más cercano"
            )
            6 -> MechIACard(
                "779",
                "<b>Si es el primero:</b> CAMINA a 18 hex. y LOS de la mayoría de enemigos, cubierto del máximo de enemigos" +
                        "<br><b>1.</b> QUIETO si no hay enemigos a 6 hex. y al menos 1 enemigo con LOS" +
                        "<br><b>2.</b> CAMINA para tener LOS con el enemigo con menos salud" +
                        "<br><b>3.</b> SALTA a cobertura del máximo de enemigos" +
                        "<br><b>4.</b> SALTA hacia el enemigo con menos salud" +
                        "<br><b>5.</b> SALTA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo con menos salud" +
                        "<br><b>2.</b> Enemigo con menos TMM" +
                        "<br><b>3.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>4.</b> Enemigo más cercano"
            )
            7 -> MechIACard(
                "848",
                "<b>Si es el primero:</b> CAMINA a 21 hex. y LOS de la mayoría de enemigos, cubierto del máximo de enemigos" +
                        "<br><b>1.</b> QUIETO si no hay enemigos a 9 hex. y al menos 1 enemigo con LOS" +
                        "<br><b>2.</b> CAMINA para estar a 9 hex. de todos los enemigos" +
                        "<br><b>3.</b> CAMINA para tener al mínimo de enemigos (min. 1) con LOS" +
                        "<br><b>4.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con mayor TMM" +
                        "<br><b>3.</b> Enemigo sin cobertura" +
                        "<br><b>4.</b> Enemigo con menos salud" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            8 -> MechIACard(
                "952",
                "<b>Si es el primero:</b> CAMINA a 15 hex. y LOS de la mayoría de enemigos, cubierto del máximo de enemigos" +
                        "<br><b>1.</b> QUIETO si sólo hay un enemigo en LOS" +
                        "<br><b>2.</b> QUIETO si estás en cobertura de todos los enemigos" +
                        "<br><b>3.</b> CAMINA para tener cobertura del máximo de enemigos" +
                        "<br><b>4.</b> CAMINA para estar a 12 hex. de todos los enemigos" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con menos TMM" +
                        "<br><b>3.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>4.</b> Enemigo más cercano"
            )
            else -> {
                MechIACard("X", "X", "X")
            }
        }
    }

    private fun generateSkirmisherCard(): MechIACard {
        return when (Random.nextInt(1..8)) {
            1 -> MechIACard(
                "51",
                "<b>Si es el primero:</b> SALTA a 6 hex. del enemigo más cercano, cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> SALTA hacia el enemigo con menos TMM" +
                        "<br><b>2.</b> SALTA hacia el enemigo de mayor amenaza" +
                        "<br><b>3.</b> CAMINA para que el mínimo de enemigos (min. 1) tenga LOS" +
                        "<br><b>4.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo de mayor amenaza" +
                        "<br><b>3.</b> Enemigo con menos TMM" +
                        "<br><b>4.</b> Enemigo sin cobertura" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            2 -> MechIACard(
                "166",
                "<b>Si es el primero:</b> CAMINA a 9 hex. y LOS del enemigo más cercano, cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> CAMINA a 9 hex. del enemigo más cercano" +
                        "<br><b>2.</b> CAMINA para tener cobertura de la mayoría de enemigos" +
                        "<br><b>3.</b> CAMINA para tener LOS del enemigo con menos TMM" +
                        "<br><b>4.</b> CAMINA para tener LOS del enemigo más cercano en 12 hex." +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo con menos TMM" +
                        "<br><b>2.</b> Enemigo destruible" +
                        "<br><b>3.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>4.</b> Enemigo sin cobertura" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            3 -> MechIACard(
                "222",
                "<b>Si es el primero:</b> SALTA para tener al máximo de enemigos con LOS, cubierto del máximo de enemigos" +
                        "<br><b>1.</b> CAMINA para tener al máximo de enemigos en LOS" +
                        "<br><b>2.</b> CAMINA para estar cubierto del máximo de enemigos" +
                        "<br><b>3.</b> CAMINA hacia el enemigo con menos TMM" +
                        "<br><b>4.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>3.</b> Enemigo sin cobertura" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            4 -> MechIACard(
                "318",
                "<b>Si es el primero:</b> CAMINA para tener al máximo de enemigos con LOS, cubierto del máximo de enemigos" +
                        "<br><b>1.</b> QUIETO si hay enemigos en 12 hex. con LOS y TMM de 1 ó menos" +
                        "<br><b>2.</b> CAMINA para estar cubierto del máximo de enemigos" +
                        "<br><b>3.</b> CAMINA hacia el enemigo de mayor amenaza" +
                        "<br><b>4.</b> CAMINA para tener el mínimo de enemigos (min. 1) en LOS" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con más TMM" +
                        "<br><b>3.</b> Enemigo más cercano"
            )
            5 -> MechIACard(
                "459",
                "<b>Si es el primero:</b> SALTA hacia el enemigo más lejano, sin LOS del resto de enemigos o cubierto de la mayoría de ellos" +
                        "<br><b>1.</b> CAMINA hacia el enemigo más lejano del que te puedas poner detrás" +
                        "<br><b>2.</b> SALTA hacia el enemigo más lejano" +
                        "<br><b>3.</b> SALTA a cobertura del máximo de enemigos" +
                        "<br><b>4.</b> SALTA para tener al mínimo de enemigos (min. 1) en LOS",
                "<b>1.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>2.</b> Enemigo de mayor amenaza" +
                        "<br><b>3.</b> Enemigo con menos TMM" +
                        "<br><b>4.</b> Enemigo más cercano"
            )
            6 -> MechIACard(
                "561",
                "<b>Si es el primero:</b> SALTA hacia el enemigo más lejano, sin LOS del resto de enemigos o cubierto de la mayoría de ellos" +
                        "<br><b>1.</b> CAMINA hacia el enemigo más lejano del que te puedas poner detrás" +
                        "<br><b>2.</b> SALTA hacia el enemigo más lejano" +
                        "<br><b>3.</b> SALTA a cobertura del máximo de enemigos" +
                        "<br><b>4.</b> SALTA para tener al mínimo de enemigos (min. 1) en LOS",
                "<b>1.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>2.</b> Enemigo con menos TMM" +
                        "<br><b>3.</b> Enemigo de mayor amenaza" +
                        "<br><b>4.</b> Enemigo más cercano"
            )
            7 -> MechIACard(
                "575",
                "<b>Si es el primero:</b> SALTA para tener LOS con el máximo de enemigos, cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> SALTA a cubierto de la mayoría de enemigos si el enemigo con menos salud no se ha movido" +
                        "<br><b>2.</b> CAMINA hacia el enemigo con menos salud" +
                        "<br><b>3.</b> CAMINA para tener al mínimo de enemigos (min. 1) en LOS" +
                        "<br><b>4.</b> CAMINA a cobertura del máximo de enemigos" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más lejano",
                "Sobrecalienta." +
                        "<br><b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con menos salud" +
                        "<br><b>3.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>4.</b> Enemigo sin cobertura" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            8 -> MechIACard(
                "913",
                "<b>Si es el primero:</b> SALTA a 9 hex. de todos los enemigos, cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> SALTA a cobertura de la mayoría de enemigos si el enemigo con mayor MV no se ha movido aún" +
                        "<br><b>2.</b> CAMINA hacia el enemigo con mayor MV" +
                        "<br><b>3.</b> CAMINA a cobertura del máximo de enemigos" +
                        "<br><b>4.</b> CAMINA hacia el enemigo con menor salud si te puedes poner detrás" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "Sobrecalienta." +
                        "<br><b>1.</b> Enemigo con más MV" +
                        "<br><b>2.</b> Enemigo destruible" +
                        "<br><b>3.</b> Enemigo de mayor amenaza" +
                        "<br><b>4.</b> Enemigo con menos TMM" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            else -> {
                MechIACard("X", "X", "X")
            }
        }
    }

    private fun generateStrikerCard(): MechIACard {
        return when (Random.nextInt(1..8)) {
            1 -> MechIACard(
                "505",
                "<b>Si es el primero:</b> SPRINT a 15 hex. de todos los enemigos, con el mínimo de enemigos en LOS" +
                        "<br><b>1.</b> SPRINT para tener al mínimo de enemigos en LOS si no hay enemigos en 12 hex." +
                        "<br><b>2.</b> CAMINA hacia el enemigo más cercano al que te puedas poner detrás" +
                        "<br><b>3.</b> CAMINA hacia el enemigo con menor salud" +
                        "<br><b>4.</b> CAMINA a cobertura del máximo de enemigos" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con menos salud" +
                        "<br><b>3.</b> Enemigo con menos TMM" +
                        "<br><b>4.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            2 -> MechIACard(
                "701",
                "<b>Si es el primero:</b> SALTA a 12 hex. de todos los enemigos, sin LOS o cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> SPRINT para tener el mínimo de enemigos en LOS si no hay enemigos en 12 hex." +
                        "<br><b>2.</b> SALTA hacia el enemigo más lejano al que te puedas poner detrás" +
                        "<br><b>3.</b> CAMINA hacia el enemigo con menos TMM" +
                        "<br><b>4.</b> CAMINA a cobertura del máximo de enemigos" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con menos TMM" +
                        "<br><b>3.</b> Enemigo sin cobertura" +
                        "<br><b>4.</b> Enemigo más cercano"
            )
            3 -> MechIACard(
                "585",
                "<b>Si es el primero:</b> SALTA a 12 hex. de todos los enemigos, sin LOS o cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> SPRINT para tener el mínimo de enemigos en LOS si no hay enemigos en 12 hex." +
                        "<br><b>2.</b> CAMINA hacia el enemigo con mayor TMM" +
                        "<br><b>3.</b> CAMINA para tener al mínimo de enemigos (min. 1) en LOS" +
                        "<br><b>4.</b> CAMINA para estar a cobertura del máximo de enemigos" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo con más TMM" +
                        "<br><b>2.</b> Enemigo destruible" +
                        "<br><b>3.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>4.</b> Enemigo sin cobertura" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            4 -> MechIACard(
                "725",
                "<b>Si es el primero:</b> SALTA a 9 hex. de todos los enemigos, sin LOS o cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> SALTA a cobertura de la mayoría de enemigos si el enemigo con menor salud aún no se ha movido" +
                        "<br><b>2.</b> CAMINA hacia el enemigo desrtuible de mayor salud" +
                        "<br><b>3.</b> CAMINA para tener al mínimo de enemigos (min. 1) en LOS" +
                        "<br><b>4.</b> CAMINA a cobertura del máximo de enemigos" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "Sobrecalienta." +
                        "<br><b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con más salud" +
                        "<br><b>3.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>4.</b> Enemigo sin cobertura" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            5 -> MechIACard(
                "781",
                "<b>Si es el primero:</b> SALTA a 15 hex. de todos los enemigos, sin LOS o cubierto de la mayoría de enemigos" +
                        "<br><b>1.</b> SALTA a cobertura del máximo de enemigos si el enemigo con menos salud aún no se ha movido" +
                        "<br><b>2.</b> CAMINA hacia el enemigo con menos salud" +
                        "<br><b>3.</b> CAMINA para que el mínimo de enemigos (min. 1) tenga LOS" +
                        "<br><b>4.</b> CAMINA a cobertura del máximo de enemigos" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más lejano",
                "Sobrecalienta." +
                        "<br><b>1.</b> Enemigo con menos salud" +
                        "<br><b>2.</b> Enemigo destruible" +
                        "<br><b>3.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>4.</b> Enemigo sin cobertura" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            6 -> MechIACard(
                "890",
                "<b>Si es el primero:</b> SALTA a 15 hex. de todos los enemigos, con el mínimo de enemigos (min. 1) en LOS o cubierto de la mayoría" +
                        "<br><b>1.</b> SALTA a cobertura del máximo de enemigos si el enemigo con menos salud aún no se ha movido" +
                        "<br><b>2.</b> CAMINA hacia el enemigo con menos salud" +
                        "<br><b>3.</b> CAMINA para que el mínimo de enemigos (min. 1) tenga LOS" +
                        "<br><b>4.</b> CAMINA a cobertura del máximo de enemigos" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más lejano",
                "Sobrecalienta." +
                        "<br><b>1.</b> Enemigo destruible" +
                        "<br><b>2.</b> Enemigo con menos salud" +
                        "<br><b>3.</b> Enemigo que esté en la franja de distancia más cercana" +
                        "<br><b>4.</b> Enemigo sin cobertura" +
                        "<br><b>5.</b> Enemigo más cercano"
            )
            7 -> MechIACard(
                "966",
                "<b>Si es el primero:</b> SALTA a 9 hex. de todos los enemigos y cubierto del máximo de enemigos" +
                        "<br><b>1.</b> SALTA a cobertura del máximo de enemigos si el enemigo con más MV aún no se ha movido" +
                        "<br><b>2.</b> CAMINA hacia el enemigo de más MV" +
                        "<br><b>3.</b> CAMINA a cobertura del máximo de enemigos" +
                        "<br><b>4.</b> CAMINA hacia el enemigo de menor salud al que te puedas poner detrás" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo con más MV" +
                        "<br><b>2.</b> Enemigo de mayor amenaza" +
                        "<br><b>3.</b> Enemigo con menos TMM" +
                        "<br><b>4.</b> Enemigo más cercano"
            )
            8 -> MechIACard(
                "798",
                "<b>Si es el primero:</b> SALTA a 9 hex. de todos los enemigos y cubierto del máximo de enemigos" +
                        "<br><b>1.</b> SALTA a cobertura del máximo de enemigos si el enemigo con más MV aún no se ha movido" +
                        "<br><b>2.</b> CAMINA hacia el enemigo de más MV" +
                        "<br><b>3.</b> CAMINA hacia el enemigo de menos TMM al que te puedas poner detrás" +
                        "<br><b>4.</b> CAMINA a cobertura del máximo de enemigos" +
                        "<br><b>5.</b> CAMINA hacia el enemigo más cercano",
                "<b>1.</b> Enemigo con más MV" +
                        "<br><b>2.</b> Enemigo destruible" +
                        "<br><b>3.</b> Enemigo de mayor amenaza" +
                        "<br><b>4.</b> Enemigo más cercano"
            )
            else -> {
                MechIACard("X", "X", "X")
            }
        }
    }
}