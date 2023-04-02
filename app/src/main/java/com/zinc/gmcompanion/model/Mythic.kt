package com.zinc.gmcompanion.model

import android.content.Context
import kotlin.random.Random

enum class FateOdds {IMPOSSIBLE, NO_WAY, VERY_UNLIKELY, UNLIKELY, FIFTY_FIFTY, SOMEWHAT_LIKELY, LIKELY, VERY_LIKELY, NEAR_SURE_THING, A_SURE_THING, HAS_TO_BE}

class Mythic {
    fun generateSceneChanges(applicationContext: Context?, chaosValue: Int): String {
        val d10 = Random.nextInt(1, 11)
        return if (d10 < chaosValue) {
            when (d10) {
                1, 3, 5, 7, 9 -> "La escena resulta alterada, haz alguna pregunta y tira en la tabla de Destino para ver cómo"
                2, 4, 6, 8 -> "La escena es interrumpida y aparece una nueva escena inesperada, tira en la tabla de Random Event para ver qué nueva escena aparece"
                else -> "Error"
            }
        } else {
            "La escena sucede sin cambios"
        }
    }

    fun generateEvent(context: Context): String {
        val focus = getFocus()
        val action = getAction()
        val subject = getSubject()
        return focus +
                "<br>" +
                "<b>Significado: </b>$action + $subject"
    }

    private fun getSubject(): String = when (Random.nextInt(1, 101)) {
        1 -> "Metas"
        2 -> "Sueños"
        3 -> "Medio ambiente"
        4 -> "Exterior"
        5 -> "Interior"
        6 -> "Realidad"
        7 -> "Aliados"
        8 -> "Enemigos"
        9 -> "Maldad"
        10 -> "Bondad"
        11 -> "Emociones"
        12 -> "Oposición"
        13 -> "Guerra"
        14 -> "Paz"
        15 -> "El inocente"
        16 -> "Amor"
        17 -> "Lo espiritual"
        18 -> "El intelectual"
        19 -> "Nuevas ideas"
        20 -> "Alegría"
        21 -> "Mensajes"
        22 -> "Energía"
        23 -> "Equilibrio"
        24 -> "Tensión"
        25 -> "Amistad"
        26 -> "El físico"
        27 -> "Un proyecto"
        28 -> "Placeres"
        29 -> "Dolor"
        30 -> "Posesiones"
        31 -> "Beneficios"
        32 -> "Planes"
        33 -> "Mentiras"
        34 -> "Expectativas"
        35 -> "Asuntos legales"
        36 -> "Burocracia"
        37 -> "Negocios"
        38 -> "Un camino"
        39 -> "Noticias"
        40 -> "Factores externos"
        41 -> "Consejo"
        42 -> "Una conspiración"
        43 -> "Competencia"
        44 -> "Prisión"
        45 -> "Enfermedad"
        46 -> "Comida"
        47 -> "Atención"
        48 -> "Éxito"
        49 -> "Fracaso"
        50 -> "Viajar"
        51 -> "Celos"
        52 -> "Disputa"
        53 -> "Hogar"
        54 -> "Inversión"
        55 -> "Sufrimiento"
        56 -> "Deseos"
        57 -> "Tácticas"
        58 -> "Estancamiento"
        59 -> "Aleatoriedad"
        60 -> "Desgracia"
        61 -> "Muerte"
        62 -> "Interrupción"
        63 -> "Poder"
        64 -> "Una carga"
        65 -> "Intrigas"
        66 -> "Miedos"
        67 -> "Emboscada"
        68 -> "Rumores"
        69 -> "Heridas"
        70 -> "Extravagancia"
        71 -> "Un representante"
        72 -> "Adversidades"
        73 -> "Opulencia"
        74 -> "Libertad"
        75 -> "Militar"
        76 -> "Lo mundano"
        77 -> "Ensayos"
        78 -> "Misas"
        79 -> "Vehículo"
        80 -> "Arte"
        81 -> "Victoria"
        82 -> "Disputa"
        83 -> "Riquezas"
        84 -> "Status quo"
        85 -> "Tecnología"
        86 -> "Esperanza"
        87 -> "Magia"
        88 -> "Ilusiones"
        89 -> "Portales"
        90 -> "Peligro"
        91 -> "Armas"
        92 -> "Animales"
        93 -> "Tiempo"
        94 -> "Elementos"
        95 -> "Naturaleza"
        96 -> "El público"
        97 -> "Liderazgo"
        98 -> "Fama"
        99 -> "Ira"
        100 -> "Información"
        else -> ""
    }

    private fun getAction(): String = when (Random.nextInt(1, 101)) {
        1 -> "Lograr"
        2 -> "Empezar"
        3 -> "Descuidar"
        4 -> "Luchar"
        5 -> "Reclutar"
        6 -> "Triunfar"
        7 -> "Violar"
        8 -> "Oponerse"
        9 -> "Intención maliciosa"
        10 -> "Comunicar"
        11 -> "Perseguir"
        12 -> "Aumentar"
        13 -> "Disminuir"
        14 -> "Abandonar"
        15 -> "Gratificar"
        16 -> "Averiguar"
        17 -> "Antagonizar"
        18 -> "Moverse"
        19 -> "Desperdiciar"
        20 -> "Realizar una tregua"
        21 -> "Liberar"
        22 -> "Hacerse amigo"
        23 -> "Juzgar"
        24 -> "Desertar"
        25 -> "Dominar"
        26 -> "Procrastinar"
        27 -> "Alabar"
        28 -> "Separar"
        29 -> "Coger"
        30 -> "Descansar"
        31 -> "Curar"
        32 -> "Retrasas"
        33 -> "Parar"
        34 -> "Mentir"
        35 -> "Volver"
        36 -> "Imitar"
        37 -> "Esforzarse"
        38 -> "Informar"
        39 -> "Otorgar"
        40 -> "Posponer"
        41 -> "Exponer"
        42 -> "Regatear"
        43 -> "Encarcelar"
        44 -> "Liberar"
        45 -> "Celebrar"
        46 -> "Desarrollar"
        47 -> "Viajar"
        48 -> "Bloquear"
        49 -> "Dañar"
        50 -> "Degradar"
        51 -> "Sobreindulgencia"
        52 -> "Aplazar"
        53 -> "Adversidad"
        54 -> "Matar"
        55 -> "Interrumpir"
        56 -> "Usurpar"
        57 -> "Crear"
        58 -> "Traicionar"
        59 -> "Acordar"
        60 -> "Abusar"
        61 -> "Oprimir"
        62 -> "Inspeccionar"
        63 -> "Emboscar"
        64 -> "Espiar"
        65 -> "Adjuntar"
        66 -> "Llevar"
        67 -> "Abrir"
        68 -> "Descuidar"
        69 -> "Arruinar"
        70 -> "Extravagancia"
        71 -> "Hacer trampas"
        72 -> "Llegar"
        73 -> "Proponer"
        74 -> "Dividir"
        75 -> "Rechazar"
        76 -> "Desconfiar"
        77 -> "Engañar"
        78 -> "Ser cruel"
        79 -> "No tolerar"
        80 -> "Confiar"
        81 -> "Emocionar"
        82 -> "Actividad"
        83 -> "Ayudar"
        84 -> "Cuidar"
        85 -> "Ser negligente"
        86 -> "Pasión"
        87 -> "Trabajar duro"
        88 -> "Controlar"
        89 -> "Atraer"
        90 -> "Fracasar"
        91 -> "Perseguir"
        92 -> "Vengar"
        93 -> "Procedimientos"
        94 -> "Disputar"
        95 -> "Castigar"
        96 -> "Guíar"
        97 -> "Transformar"
        98 -> "Derrocard"
        99 -> "Oprimir"
        100 -> "Cambiar"
        else -> ""
    }

    private fun getFocus(): String = when (Random.nextInt(1, 101)) {
        in 1..7 -> "<b>Remote event:</b> Ha sucedido algo importante mientras el PJ no estaba ahí"
        in 8..28 -> "<b>NPC action:</b> Un PNJ aleatorio ya existente hace algo por sorpresa"
        in 29..35 -> "<b>Introduce a new NPC:</b> Aparece un nuevo PNJ o grupo de PNJs"
        in 36..45 -> "<b>Move toward a thread:</b> Una oportunidad para acercarse a resolver un Thread aleatorio"
        in 46..52 -> "<b>Move away from a thread:</b> Sucede algo que dificulta un Thread aleatorio"
        in 53..55 -> "<b>Close a thread:</b> Sucede algo que cierra y finaliza un Thread aleatorio"
        in 56..67 -> "<b>PC negative:</b> Le sucede algo malo al PJ"
        in 68..75 -> "<b>PC positive:</b> Le sucede algo bueno al PJ"
        in 76..83 -> "<b>Ambiguous event:</b> Sucede algo ambiguo, ni bueno ni malo, no necesariamente importante o especial"
        in 84..92 -> "<b>NPC negative:</b> Le sucede algo malo a un PNJ aleatorio"
        in 93..100 -> "<b>NPC positive:</b> Le sucede algo bueno a un PNJ aleatorio"
        else -> ""
    }

    fun generateFate(context: Context, odds: FateOdds, chaos: Int): String {
        val oddRanges = getOdds(odds, chaos)
        val d100 = Random.nextInt(1, 101)
        return if (d100 <= oddRanges.first) "Sí Excepcional"
        else if (d100 <= oddRanges.second) "Sí"
        else if (d100 >= oddRanges.third) "No Excepcional"
        else "No"
    }

    private fun getOdds(odds: FateOdds, chaos: Int): Triple<Int, Int, Int> {
        when (odds) {
            FateOdds.IMPOSSIBLE -> {
                when (chaos) {
                    1 -> return tripleMinus20()
                    2 -> return triple0()
                    3 -> return triple0()
                    4 -> return triple5()
                    5 -> return triple5()
                    6 -> return triple10()
                    7 -> return triple15()
                    8 -> return triple25()
                    9 -> return triple50()
                }
            }
            FateOdds.NO_WAY -> {
                when (chaos) {
                    1 -> return triple0()
                    2 -> return triple5()
                    3 -> return triple5()
                    4 -> return triple10()
                    5 -> return triple15()
                    6 -> return triple25()
                    7 -> return triple35()
                    8 -> return triple50()
                    9 -> return triple75()
                }
            }
            FateOdds.VERY_UNLIKELY -> {
                when (chaos) {
                    1 -> return triple5()
                    2 -> return triple5()
                    3 -> return triple10()
                    4 -> return triple15()
                    5 -> return triple25()
                    6 -> return triple45()
                    7 -> return triple50()
                    8 -> return triple65()
                    9 -> return triple85()
                }
            }
            FateOdds.UNLIKELY -> {
                when (chaos) {
                    1 -> return triple5()
                    2 -> return triple10()
                    3 -> return triple15()
                    4 -> return triple20()
                    5 -> return triple35()
                    6 -> return triple50()
                    7 -> return triple55()
                    8 -> return triple75()
                    9 -> return triple90()
                }
            }
            FateOdds.FIFTY_FIFTY -> {
                when (chaos) {
                    1 -> return triple10()
                    2 -> return triple15()
                    3 -> return triple25()
                    4 -> return triple35()
                    5 -> return triple50()
                    6 -> return triple65()
                    7 -> return triple75()
                    8 -> return triple85()
                    9 -> return triple95()
                }
            }
            FateOdds.SOMEWHAT_LIKELY -> {
                when (chaos) {
                    1 -> return triple20()
                    2 -> return triple25()
                    3 -> return triple45()
                    4 -> return triple50()
                    5 -> return triple65()
                    6 -> return triple80()
                    7 -> return triple85()
                    8 -> return triple90()
                    9 -> return triple95()
                }
            }
            FateOdds.LIKELY -> {
                when (chaos) {
                    1 -> return triple25()
                    2 -> return triple35()
                    3 -> return triple50()
                    4 -> return triple55()
                    5 -> return triple75()
                    6 -> return triple85()
                    7 -> return triple90()
                    8 -> return triple95()
                    9 -> return triple100()
                }
            }
            FateOdds.VERY_LIKELY -> {
                when (chaos) {
                    1 -> return triple45()
                    2 -> return triple50()
                    3 -> return triple65()
                    4 -> return triple75()
                    5 -> return triple85()
                    6 -> return triple90()
                    7 -> return triple95()
                    8 -> return triple95()
                    9 -> return triple105()
                }
            }
            FateOdds.NEAR_SURE_THING -> {
                when (chaos) {
                    1 -> return triple50()
                    2 -> return triple55()
                    3 -> return triple75()
                    4 -> return triple80()
                    5 -> return triple90()
                    6 -> return triple95()
                    7 -> return triple95()
                    8 -> return triple100()
                    9 -> return triple115()
                }
            }
            FateOdds.A_SURE_THING -> {
                when (chaos) {
                    1 -> return triple55()
                    2 -> return triple65()
                    3 -> return triple80()
                    4 -> return triple85()
                    5 -> return triple90()
                    6 -> return triple95()
                    7 -> return triple95()
                    8 -> return triple110()
                    9 -> return triple125()
                }
            }
            FateOdds.HAS_TO_BE -> {
                when (chaos) {
                    1 -> return triple80()
                    2 -> return triple85()
                    3 -> return triple90()
                    4 -> return triple95()
                    5 -> return triple95()
                    6 -> return triple100()
                    7 -> return triple100()
                    8 -> return triple130()
                    9 -> return triple145()
                }
            }
        }
        return Triple(0, 0, 0)
    }

    private fun tripleMinus20(): Triple<Int, Int, Int> = Triple(0, -20, 77)
    private fun triple0(): Triple<Int, Int, Int> = Triple(0, 0, 81)
    private fun triple5(): Triple<Int, Int, Int> = Triple(1, 5, 82)
    private fun triple10(): Triple<Int, Int, Int> = Triple(2, 10, 83)
    private fun triple15(): Triple<Int, Int, Int> = Triple(3, 15, 84)
    private fun triple20(): Triple<Int, Int, Int> = Triple(4, 20, 85)
    private fun triple25(): Triple<Int, Int, Int> = Triple(5, 25, 86)
    private fun triple35(): Triple<Int, Int, Int> = Triple(7, 35, 88)
    private fun triple45(): Triple<Int, Int, Int> = Triple(9, 45, 90)
    private fun triple50(): Triple<Int, Int, Int> = Triple(10, 50, 91)
    private fun triple55(): Triple<Int, Int, Int> = Triple(11, 55, 92)
    private fun triple65(): Triple<Int, Int, Int> = Triple(13, 65, 94)
    private fun triple75(): Triple<Int, Int, Int> = Triple(15, 75, 96)
    private fun triple80(): Triple<Int, Int, Int> = Triple(16, 80, 97)
    private fun triple85(): Triple<Int, Int, Int> = Triple(16, 85, 97)
    private fun triple90(): Triple<Int, Int, Int> = Triple(18, 90, 99)
    private fun triple95(): Triple<Int, Int, Int> = Triple(19, 95, 100)
    private fun triple100(): Triple<Int, Int, Int> = Triple(20, 100, 0)
    private fun triple105(): Triple<Int, Int, Int> = Triple(21, 105, 0)
    private fun triple110(): Triple<Int, Int, Int> = Triple(22, 110, 0)
    private fun triple115(): Triple<Int, Int, Int> = Triple(23, 115, 0)
    private fun triple125(): Triple<Int, Int, Int> = Triple(25, 125, 0)
    private fun triple130(): Triple<Int, Int, Int> = Triple(26, 130, 0)
    private fun triple145(): Triple<Int, Int, Int> = Triple(26, 145, 0)
}