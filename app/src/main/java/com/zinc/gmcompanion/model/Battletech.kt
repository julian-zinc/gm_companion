package com.zinc.gmcompanion.model

import android.content.Context
import com.zinc.gmcompanion.R
import kotlin.random.Random

enum class MechType {BRAWLER, SKIRMISHER, FLANKER, SMASHER, STRIKER, CAVALRY, ARTILLERY, SUPPORT, SNIPER}

class Battletech {
    fun generateMechMovement(
        context: Context,
        mechType: MechType,
        aggressivity: Int
    ): String {
        var random = Random.nextInt(1, 7)
        when (aggressivity) {
            1, 2 -> random -= 2
            3, 4 -> random -= 1
            6, 7 -> random += 1
            8, 9 -> random += 2
        }
        var movement = context.getString(R.string.error)
        when(mechType) {
            MechType.BRAWLER -> {
                movement = when (random) {
                    -1, 0 -> "<b>¡Atrás!:</b> Corre/Salta para mantener al enemigo a distancia larga, ganando el máximo de esquiva y cobertura"
                    1 -> "<b>¡A cubierto!:</b> Corre/Salta para mantener al enemigo a distancia media, ganando el máximo de esquiva y cobertura"
                    2, 3 -> "<b>¡Adelante!:</b> Corre/Salta para mantener al enemigo a distancia corta, ganando el máximo de esquiva y cobertura"
                    4, 5 -> "<b>¡Al ataque!:</b> Camina (o corre/salta si es necesario para llegar) para mantener al enemigo a distancia corta, ganando cobertura/esquiva si es posible"
                    6, 7, 8 -> "<b>¡Cuerpo a cuerpo!:</b> Camina (o corre/salta si es necesario para llegar a distancia corta o puedes alcanzar una espalda) para acercarte al enemigo lo más posible"
                    else -> context.getString(R.string.error)
                }
            }
            MechType.SKIRMISHER -> {
                movement = when (random) {
                    -1, 0 -> "<b>¡Atrás!:</b> Corre/Salta para mantener al enemigo a distancia larga, ganando el máximo de esquiva y cobertura"
                    1, 2 -> "<b>¡A cubierto!:</b> Corre/Salta para mantener al enemigo a distancia media, ganando el máximo de esquiva y cobertura"
                    3 -> "<b>¡Adelante!:</b> Corre/Salta para mantener al enemigo a distancia corta, ganando el máximo de esquiva y cobertura"
                    4 -> "<b>¡Al ataque!:</b> Camina (o corre/salta si es necesario para llegar) para mantener al enemigo a distancia corta, priorizando la precisión y ganando cobertura/esquiva si es posible"
                    5 -> "<b>¡Cuerpo a cuerpo!:</b> Camina (o corre/salta si es necesario para llegar a distancia corta o puedes alcanzar una espalda) para acercarte al enemigo lo más posible"
                    6, 7, 8 -> "<b>¡Carga!:</b> Si puede recorer al menos 5 hexágonos, realiza una carga con el máximo de hexágonos de distancia, si no camina (o corre/salta si es necesario para llegar a distancia corta) para acercarte al enemigo lo más posible"
                    else -> context.getString(R.string.error)
                }
            }
            MechType.FLANKER -> {
                movement = when (random) {
                    -1, 0, 1 -> "<b>¡A cubierto!:</b> Camina/Corre/Salta para mantener al enemigo a distancia media, ganando el máximo de esquiva y cobertura"
                    2 -> "<b>¡Adelante!:</b> Corre/Salta para mantener al enemigo a distancia corta, ganando el máximo de esquiva y cobertura"
                    3 -> "<b>¡Al ataque!:</b> Camina (o corre/salta si es necesario para llegar) para mantener al enemigo a distancia corta, priorizando la precisión y ganando cobertura/esquiva si es posible"
                    4, 5 -> "<b>¡Flanquea!:</b> Camina/Corre/Salta para tratar de buscar la espalda o el costado del enemigo"
                    6, 7, 8 -> "<b>¡Carga!:</b> Si puede recorer al menos 5 hexágonos, realiza una carga con el máximo de hexágonos de distancia, si no camina/corre/salta para tratar de buscar la espalda o el costado del enemigo"
                    else -> context.getString(R.string.error)
                }
            }
            MechType.SMASHER -> {
                movement = when (random) {
                    -1, 0, 1 -> "<b>¡Atrás!:</b> Corre/Salta para mantener al enemigo a distancia larga, ganando el máximo de esquiva y cobertura"
                    2, 3 -> "<b>¡A cubierto!:</b> Corre/Salta para mantener al enemigo a distancia media, ganando el máximo de esquiva y cobertura"
                    4 -> "<b>¡Adelante!:</b> Corre/Salta para mantener al enemigo a distancia corta, ganando el máximo de esquiva y cobertura"
                    5, 6, 7, 8 -> "<b>¡Al ataque!:</b> Camina (o corre/salta si es necesario para llegar) para mantener al enemigo a distancia corta, priorizando la precisión y ganando cobertura/esquiva si es posible"
                    else -> context.getString(R.string.error)
                }
            }
            MechType.STRIKER -> {
                movement = when (random) {
                    -1, 0 -> "<b>¡Atrás!:</b> Corre/Salta para mantener al enemigo a distancia larga, ganando el máximo de esquiva y cobertura"
                    1 -> "<b>¡A cubierto!:</b> Corre/Salta para mantener al enemigo a distancia media, ganando el máximo de esquiva y cobertura"
                    2 -> "<b>¡Fuego!:</b> Quieto/Camina (o Corre/Salta para llegar) a distancia media, priorizando la precisión a la cobertura"
                    3 -> "<b>¡Adelante!:</b> Corre/Salta para mantener al enemigo a distancia corta, ganando el máximo de esquiva y cobertura"
                    4, 5 -> "<b>¡Al ataque!:</b> Camina (o corre/salta si es necesario para llegar) para mantener al enemigo a distancia corta, priorizando la precisión y ganando cobertura/esquiva si es posible"
                    6 -> "<b>¡Cuerpo a cuerpo!:</b> Camina (o corre/salta si es necesario para llegar a distancia corta o puedes alcanzar una espalda) para acercarte al enemigo lo más posible"
                    7, 8 -> "<b>¡Carga!:</b> Si puede recorer al menos 5 hexágonos, realiza una carga con el máximo de hexágonos de distancia, si no camina (o corre/salta si es necesario para llegar a distancia corta) para acercarte al enemigo lo más posible"
                    else -> context.getString(R.string.error)
                }
            }
            MechType.CAVALRY -> {
                movement = when (random) {
                    -1, 0, 1 -> "<b>¡A cubierto!:</b> Camina/Corre/Salta para mantener al enemigo a distancia media, ganando el máximo de esquiva y cobertura"
                    2 -> "<b>¡Adelante!:</b> Corre/Salta para mantener al enemigo a distancia corta, ganando el máximo de esquiva y cobertura"
                    3, 4 -> "<b>¡Al ataque!:</b> Camina (o corre/salta si es necesario para llegar) para mantener al enemigo a distancia corta, priorizando la precisión y ganando cobertura/esquiva si es posible"
                    5, 6 -> "<b>¡Flanquea!:</b> Camina/Corre/Salta para tratar de buscar la espalda o el costado del enemigo"
                    7, 8 -> "<b>¡Carga!:</b> Si puede recorer al menos 5 hexágonos, realiza una carga con el máximo de hexágonos de distancia, si no camina/corre/salta para tratar de buscar la espalda o el costado del enemigo"
                    else -> context.getString(R.string.error)
                }
            }
            MechType.ARTILLERY -> {
                movement = when (random) {
                    -1 -> "<b>¡Atrás!:</b> Corre/Salta para mantener al enemigo a distancia larga, ganando el máximo de esquiva y cobertura"
                    0, 1 -> "<b>¡A cubierto!:</b> Corre/Salta para mantener al enemigo a distancia media, ganando el máximo de esquiva y cobertura"
                    2, 3, 4 -> "<b>¡Fuego!:</b> Quieto/Camina (o Corre/Salta para llegar) a distancia media, priorizando la precisión a la cobertura"
                    5 -> "<b>¡Adelante!:</b> Corre/Salta para mantener al enemigo a distancia corta, ganando el máximo de esquiva y cobertura"
                    6, 7, 8 -> "<b>¡Al ataque!:</b> Quieto/Camina (o corre/salta si es necesario para llegar) para mantener al enemigo a distancia corta, priorizando la precisión y ganando cobertura/esquiva si es posible"
                    else -> context.getString(R.string.error)
                }
            }
            MechType.SUPPORT -> {
                movement = when (random) {
                    -1, 0 -> "<b>¡Atrás!:</b> Corre/Salta para mantener al enemigo a distancia larga, ganando el máximo de esquiva y cobertura"
                    1 -> "<b>¡A cubierto!:</b> Corre/Salta para mantener al enemigo a distancia media, ganando el máximo de esquiva y cobertura"
                    2 -> "<b>¡Fuego!:</b> Quieto/Camina (o Corre/Salta para llegar) a distancia media, priorizando la precisión a la cobertura"
                    3, 4 -> "<b>¡Adelante!:</b> Corre/Salta para mantener al enemigo a distancia corta, ganando el máximo de esquiva y cobertura"
                    5, 6, 7, 8 -> "<b>¡Al ataque!:</b> Quieto/Camina (o corre/salta si es necesario para llegar) para mantener al enemigo a distancia corta, priorizando la precisión y ganando cobertura/esquiva si es posible"
                    else -> context.getString(R.string.error)
                }
            }
            MechType.SNIPER -> {
                movement = when (random) {
                    -1, 0, 1 -> "<b>¡Atrás!:</b> Corre/Salta para mantener al enemigo a distancia larga, ganando el máximo de esquiva y cobertura"
                    2, 3, 4 -> "<b>¡Fuego!:</b> Quieto/Camina (o Corre/Salta para llegar) a distancia media, priorizando la precisión a la cobertura"
                    5 -> "<b>¡Adelante!:</b> Corre/Salta para mantener al enemigo a distancia corta, ganando el máximo de esquiva y cobertura"
                    6, 7, 8 -> "<b>¡Al ataque!:</b> Quieto/Camina (o corre/salta si es necesario para llegar) para mantener al enemigo a distancia corta, priorizando la precisión y ganando cobertura/esquiva si es posible"
                    else -> context.getString(R.string.error)
                }
            }
        }
        return "Si el mech está tumbado, intentará levantarse si la tirada es a 9 ó menos, si no sólo rotará desde el suelo." +
                "<br>" +
                movement
    }

    fun generateMechAttack(context: Context, aggresivity: Int): String {
        var random1 = Random.nextInt(1, 5)
        if (aggresivity > 6) random1 += 1
        if (aggresivity < 4) random1 -= 1
        val target = when (random1) {
            0, 1 -> "más fácil de impactar con la mayoría del daño"
            2, 3 -> "con menos blindaje o más partes expuestas"
            4, 5 -> "que fue atacado por tu equipo más recientemente"
            else -> context.getString(R.string.error)
        }
        val target2 = when (Random.nextInt(1, 6)) {
            1 -> "más cercano"
            2 -> "que hace más daño"
            3 -> "más ligero"
            4 -> "más pesado"
            5 -> "que hace menos daño"
            else -> context.getString(R.string.error)
        }
        var random3 = Random.nextInt(1, 5)
        random3 = random3 + aggresivity -4
        val heat = when (random3) {
            -2, -1, 0, 1, 2, 3 -> "0"
            4, 5 -> "4"
            6 -> "12"
            7 -> "16"
            8 -> "21"
            9 -> "∞"
            else -> context.getString(R.string.error)
        }
        var random4 = Random.nextInt(1, 5)
        if (aggresivity > 6) random4 += 1
        if (aggresivity < 4) random4 -= 1
        val weaponsPriority = when (random4) {
            0, 1, 2 -> "más precisas"
            3, 4, 5 -> "más dañinas"
            else -> context.getString(R.string.error)
        }

        return "<b>Objetivo:</b> " +
                "Si tiene un objetivo al que poder atacar en la fase física, priorízalo en esta fase." +
                "<br>" +
                "· Si no, <b>prioriza el objetivo $target</b> si para impactarle con la mayoría de daño necesita menos de 10." +
                "<br>" +
                "· Si no aplica o es demasiado difícil de impactar, <b>prioriza el objetivo $target2</b> si para impactarle con la mayoría de daño necesita menos de 10." +
                "<br>" +
                "· Si no, prioriza el objetivo más sencillo de impactar con la mayoría del daño. En caso de igual dificultad, sigue las prioridades antes establecidas en orden" +
                "<br><br>" +
                "<b>Armas:</b> " +
                "Dispara con el máximo número de armas <b>sin superar $heat de temperatura</b> y priorizando <b>las armas $weaponsPriority</b>"
    }
}