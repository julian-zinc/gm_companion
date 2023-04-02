package com.zinc.gmcompanion.model

import android.content.Context
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.model.WitcherHomeland.*
import kotlin.random.Random

enum class WitcherHomeland {NORTHERN_KINGDOMS, NILFGAARD, ELF, DWARF}

class TheWitcher {
    fun getRandomLocationText(context: Context): String {
        return when (Random.nextInt(10) + 1) {
            1 -> context.getString(R.string.damage_head)
            2, 3, 4 -> context.getString(R.string.damage_body)
            5 -> context.getString(R.string.damage_r_arm)
            6 -> context.getString(R.string.damage_l_arm)
            7, 8 -> context.getString(R.string.damage_r_leg)
            9, 10 -> context.getString(R.string.damage_l_leg)
            else -> context.getString(R.string.error)
        }
    }

    fun generateEarlyLife(context: Context, homeland: WitcherHomeland): List<String> =
        listOf(
            generateHomeland(context, homeland),
            generateFamily(context, homeland),
            generateInfluencer(context, homeland),
            generateBrothers(context, homeland)
        )

    private fun generateInfluencer(context: Context, homeland: WitcherHomeland): String {
        return when (homeland) {
            NORTHERN_KINGDOMS -> {
                when (Random.nextInt(10)) {
                    0 -> context.getString(R.string.influencer_north_1)
                    1 -> context.getString(R.string.influencer_north_2)
                    2 -> context.getString(R.string.influencer_north_3)
                    3 -> context.getString(R.string.influencer_north_4)
                    4 -> context.getString(R.string.influencer_north_5)
                    5 -> context.getString(R.string.influencer_north_6)
                    6 -> context.getString(R.string.influencer_north_7)
                    7 -> context.getString(R.string.influencer_north_8)
                    8 -> context.getString(R.string.influencer_north_9)
                    9 -> context.getString(R.string.influencer_north_10)
                    else -> "Error"
                }
            }
            NILFGAARD -> {
                when (Random.nextInt(10)) {
                    0 -> "Lo que más te influyó fue la Iglesia. Pasaste años aprendiendo cánticos y rituales. Equipo: Máscara ceremonial"
                    1 -> "Quien más te influyó fue un marginado social que te enseñó a cuestionar siempre la sociedad. Equipo: Emblema colorido y llamativo"
                    2 -> "Quien más te influyó fue un conde que te enseñó a liderar y a implantar el orden. Equipo: Collar de plata"
                    3 -> "Quien más te influyó fue un mago que te enseñó la importancia del orden y la precaución. Equipo: Emblema"
                    4 -> "Quien más te influyó fue un detective imperial. Pasasteis mucho tiempo resolviendo misterios. Equipo: Lupa"
                    5 -> "Quien más te influyó fue un cazador de magos que te enseñó a tener cuidado con la magia y sus usuarios. Equipo: Anillo con dimerita"
                    6 -> "Quien más te influyó fue un soldado que te contaba historias llenas de peligros y emoción. Equipo: Trofeo de una batalla"
                    7 -> "Quien más te influyó fue un artesano que te enseñó a apreciar la técnica y la precisión. Equipo: Baratija que hiciste"
                    8 -> "Quien más te influyó fue un monstruo racional que te enseñó que no todos los monstruos son malvados. Equipo: Tótem extraño"
                    9 -> "Quien más te influyó fue un artista que te enseñó a expresarte. Equipo: Recuerdo de un admirador"
                    else -> "Error"
                }
            }
            ELF, DWARF -> {
                when (Random.nextInt(10)) {
                    0 -> "Quien más te influyó fue un humano que te enseñó que a veces el racismo carece de fundamento. Equipo: Muñeca de paja"
                    1 -> "Quien más te influyó fue un artesano que te enseñó a apreciar el magnífico arte del pueblo antiguo. Equipo: Un recuerdo que hiciste"
                    2 -> "Quien más te influyó fue un Danzarín de Guerra o un Defensor de Mahakam que te enseñó lo que es el honor. Equipo: Un recuerdo de una batalla"
                    3 -> "Quien más te influyó fue un aristócrata que te enseñó lo que es el orgullo y cómo comportarte. Equipo: Anillo de sello"
                    4 -> "Quien más te influyó fue un artista que te enseñó la importancia de la felicidad y la belleza. Equipo: Cartel o entrada"
                    5 -> "Quien más te influyó fue un incursor que te enseñó que tienes derecho a tomar lo que necesites. Equipo: Zurrón"
                    6 -> "Quien más te influyó fue un sabio que te enseñó la importancia de la historia del pueblo antiguo. Equipo: Libro de cuentos"
                    7 -> "Quien más te influyó fue un criminal que te enseñó a vivir según tus propias normas. Equipo: Máscara"
                    8 -> "Quien más te influyó fue un cazador que te enseñó a sobrevivir en la naturaleza. Equipo: Trofeo de caza"
                    9 -> "Quien más te influyó fue un granjero de las tierras bajas que te enseñó a vivir feliz. Equipo: Pala de granjero"
                    else -> "Error"
                }
            }
        }
    }

    private fun generateHomeland(context: Context, homeland: WitcherHomeland): String {
        return when (homeland) {
            NORTHERN_KINGDOMS -> {
                when (Random.nextInt(10)) {
                    0 -> context.getString(R.string.homeland_north_1)
                    1 -> context.getString(R.string.homeland_north_2)
                    2 -> context.getString(R.string.homeland_north_3)
                    3 -> context.getString(R.string.homeland_north_4)
                    4 -> context.getString(R.string.homeland_north_5)
                    5 -> context.getString(R.string.homeland_north_6)
                    6 -> context.getString(R.string.homeland_north_7)
                    7 -> context.getString(R.string.homeland_north_8)
                    8 -> context.getString(R.string.homeland_north_9)
                    9 -> context.getString(R.string.homeland_north_10)
                    else -> "Error"
                }
            }
            NILFGAARD -> {
                if (Random.nextInt(10) < 3) {
                    "Corazón de Nilfgaard (+1 a Engaño)"
                } else {
                    when (Random.nextInt(10)) {
                        0 -> "Vicovaro (+1 a Cultura)"
                        1 -> "Angren (+1 a Supervivencia)"
                        2 -> "Nazair (+1 a Pelea)"
                        3 -> "Mettina (+1 a Montar)"
                        4 -> "Mag Turga (+1 a Resistencia)"
                        5 -> "Gheso (+1 a Sigilo)"
                        6 -> "Ebbing (+1 a Deducción)"
                        7 -> "Maecht (+1 a Carisma)"
                        8 -> "Gemmeria (+1 a Intimidar)"
                        9 -> "Etolia (+1 a Coraje)"
                        else -> "Error"
                    }
                }
            }
            ELF -> "Dol Blathanna (+1 a Etiqueta)"
            DWARF -> "Mahakam (+1 a Aetesanía)"
        }
    }

    private fun generateFamily(context: Context, homeland: WitcherHomeland): String {
        return if (Random.nextBoolean()) {
            if (Random.nextBoolean()) {
                generateFamilyStatus(context, homeland)
            } else {
                generateParentFate(context, homeland)
            }
        } else {
            generateFamilyFate(context, homeland)
        }
    }

    private fun generateFamilyStatus(context: Context, homeland: WitcherHomeland): String {
        return when (homeland) {
            NORTHERN_KINGDOMS -> {
                when (Random.nextInt(10)) {
                    0 -> "Creciste en una mansión señorial, con sirvientes que te atendían, pero siempre se esperó que te comportases e impresionases a los demás. Equipo Inicial: Documento nobiliario (+2 a Reputación)"
                    1 -> "Siendo joven, te entregaron a un mago. Viviste holgadamente, pero apenas veías a tu tutor, que siempre estaba ocupado. Equipo Inicial: Crónica (+1 a Cultura)"
                    2 -> "Creciste en una mansión señorial donde aprendiste a ser la perfecta dama (o señor). Tienes un destino fijado desde que naciste. Equipo Inicial: Heráldica personal (+1 a Reputación)"
                    3 -> "Creciste entre mercaderes, siempre rodeado de gritos, regateos y dinero. Equipo Inicial: 2 Conocidos"
                    4 -> "Creciste en un taller de artesano. Tus días, a menudo largos, estaban llenos del incesante sonido de la creación. Equipo Inicial: 3 Diagramas/Fórmulas Comunes"
                    5, 6 -> "Creciste con una troupe de actores. Puede que viajases o que actuasen en un teatro. Equipo Inicial: 1 Instrumento y 1 Amigo"
                    7, 8, 9 -> "Creciste en una granja en el campo. No tenías muchas propiedades y tu vida era sencilla, aunque peligrosa. Equipo Inicial: Amuleto de la Suerte (+1 a Suerte)"
                    else -> "Error"
                }
            }
            NILFGAARD -> {
                when (Random.nextInt(10)) {
                    0 -> "Creciste en una mansión y te formaron para que conocieses bien el mundo de la corte. El lujo era solo un incentivo para ti. Equipo Inicial: Documento nobiliario (+2 a Reputación)"
                    1 -> "Te criaste entre el clero del Gran Sol. Te volviste una persona beata y siempre tuviste presente que la Iglesia te guiaría. Equipo Inicial: Símbolo sagrado (+1 a Coraje)"
                    2 -> "Creciste sabiendo que tu deber era servir al Emperador como caballero y que todos esos lujos eran una recompensa por tus servicios. Equipo Inicial: Heráldica personal (+1 a Reputación)"
                    3 -> "Creciste en un taller de artesano, aprendiendo a fabricar productos que se venderían por todo el mundo. Aprendiste a valorar la calidad. Equipo Inicial: 3 Diagramas/Fórmulas Comunes"
                    4 -> "Creciste vendiendo artículos por todo el Imperio. Viste toda clase de productos exóticos de todo el mundo. Equipo Inicial: 2 Conocidos"
                    5, 6 -> "Naciste como plebeyo y vivías en un barrio humilde. Tenías pocas posesiones y trabajabas mucho en los campos. Equipo Inicial: 1 Ave/Serpiente adiestrada"
                    7, 8, 9 -> "Creciste en una de las miles de granjas que hay en todo el Imperio. Tenías pocas posesiones pero la vida era sencilla. Equipo Inicial: Amuleto de la Suerte (+1 a Suerte)"
                    else -> "Error"
                }
            }
            ELF, DWARF -> {
                when (Random.nextInt(10)) {
                    0 -> "Creciste en un palacio y se te recordó constantemente la gloria del pasado. Se esperaba que estuvieses a la altura de tu legado. Equipo Inicial: Documento nobiliario (+2 a Reputación)"
                    1 -> "Creciste como descendiente de un noble guerrero y se espera que estés a la altura de la reputación de tu familia y que nunca deshonres su memoria. Equipo Inicial: Heráldica personal (+1 a Reputación)"
                    2 -> "Creciste entre mercaderes ambulantes. En ocasiones la vida fue dura, pero la artesanía no-humana siempre resulta valiosa. Equipo Inicial: 2 Conocidos"
                    3 -> "Creciste en una familia de escribas, registrando y protegiendo tanto como fuera posible de la historia del pueblo antiguo. Equipo Inicial: Crónica (+1 a Cultura)"
                    4 -> "Creciste cantando e interpretando en una familia de artistas. Trabajabas entre bambalinas, ayudabas a componer canciones y arreglabas instrumentos. Equipo Inicial: 1 Instrumento y 1 Amigo"
                    5, 6 -> "Creciste en una familia de artesanos, visitando palacios antiguos para inspirarte y dedicando muchas horas al día a diversos proyectos. Equipo Inicial: 3 Diagramas/Fórmulas Comunes"
                    7, 8, 9 -> "Creciste en una familia humilde, sirviendo en mansiones ajenas o desempeñando trabajos sin importancia por tu ciudad. Equipo Inicial: Amuleto de la Suerte (+1 a Suerte)"
                    else -> "Error"
                }
            }
        }
    }

    private fun generateParentFate(context: Context, homeland: WitcherHomeland): String {
        return when (homeland) {
            NORTHERN_KINGDOMS -> {
                when (Random.nextInt(10)) {
                    0 -> "Uno de tus padres murió en las Guerras del Norte. Lo más probable es que fuera tu padre, pero también es posible que tu madre luchase o fuese una baja colateral."
                    1 -> "Uno de tus padres (o ambos) te abandonó en el campo para que te buscases la vida. Puede que no pudieran mantenerte o que fueras un accidente."
                    2 -> "Uno de tus padres (o ambos) quedó maldito por un mago o por el intenso odio de alguien a quien se enfrentó. La maldición le costó la vida."
                    3 -> "Uno de tus padres (o ambos) te vendió por dinero, o tal vez por bienes o servicios. Tus padres lo necesitaban más que a ti."
                    4 -> "Uno de tus padres (o ambos) se unió a una banda. Veías a menudo a dicha banda y a veces tenías que trabajar para ellos."
                    5 -> "Uno de tus padres (o ambos) murió a manos de un monstruo. Debes decidir qué lo mató."
                    6 -> "Uno de tus padres (o ambos) fue ejecutado injustamente. Puede que fuera un chivo expiatorio de alguien o que simplemente estuviera en el lugar equivocado."
                    7 -> "Uno de tus padres (o ambos) murió a causa de una epidemia. No se podía hacer nada salvo evitarle el sufrimiento."
                    8 -> "Uno de tus padres (o ambos) huyó a Nilfgaard. Puede que le ofreciesen algo por su información o que cruzase la frontera sin más."
                    9 -> "Uno de tus padres (o ambos) fue secuestrado por nobles. Probablemente fue tu madre quien llamó la atención de un señor local o de su hijo."
                    else -> "Error"
                }
            }
            NILFGAARD -> {
                when (Random.nextInt(10)) {
                    0 -> "Tu padre murió en una de las Guerras del Norte. Puede que fuera un militar de carrera o que lo reclutasen durante dicha guerra."
                    1 -> "Uno de tus padres (o ambos) fue envenenado. Puede que fuera obra de un rival profesional o que alguien intentase quitar de en medio a tus padres."
                    2 -> "La policía secreta se llevó a uno de tus padres (o a ambos) para “interrogarlos”. La semana siguiente aparecieron ahorcados en las calles de la ciudad."
                    3 -> "Uno de tus padres (o ambos) murió a manos de un mago rebelde. Lo más probable es que intentase denunciar a dicho mago al Imperio y pagase por ello."
                    4 -> "Uno de tus padres (o ambos) fue encarcelado por practicar magia ilegal. Quizá cometiera el crimen realmente, o quizá fuera una trampa."
                    5 -> "Uno de tus padres (o ambos) fue exiliado al Desierto de Korath. Probablemente cometió un crimen grave, pero matarle era problemático."
                    6 -> "Uno de tus padres (o ambos) quedó maldito por un mago. Probablemente el mago le guardase rencor por algo."
                    7 -> "Un día, tus padres te abandonaron sin más. Puede que ni siquiera sepas por qué; simplemente, desaparecieron."
                    8 -> "Uno de tus padres (o ambos) fue esclavizado. O cometió un crimen contra el Imperio o un rival le puso una trampa."
                    9 -> "Uno de tus padres (o ambos) fue enviado al Norte como agente doble. Probablemente ni siquiera sepas dónde está, pero sirve al Emperador."
                    else -> "Error"
                }
            }
            ELF, DWARF -> {
                when (Random.nextInt(10)) {
                    0 -> "Uno de tus padres (o ambos) fue acusado de ser scoia’tael. La gente que te rodea le mira con desdén."
                    1 -> "Uno de tus padres se volvió contra su gente y vendió al pueblo antiguo a los humanos. Tus padres no son bien recibidos en tu tierra natal."
                    2 -> "Uno de tus padres (o ambos) se suicidó, fruto de la desesperación. Sin esperanzas de recuperar la gloria del pasado, se rindió y acabó con su vida."
                    3 -> "Mientras viajaba, uno de tus padres (o ambos) cayó presa del racismo humano. Murió en un pogromo y su cuerpo se expuso en una pica."
                    4 -> "Uno de tus padres (o ambos) se obsesionó con recuperar la antigua gloria de su raza. Está dispuesto a sacrificarlo todo por su causa."
                    5 -> "Uno de tus padres (o ambos) fue exiliado de tu tierra natal. Hay muchas razones posibles, desde un crimen a tener opiniones discordantes."
                    6 -> "Uno de tus padres (o ambos) quedó maldito. Puedes decidir la naturaleza de esta maldición o dejar que lo haga el Director de Juego."
                    7 -> "Tus padres te entregaron a otra familia para que sobrevivieras porque ellos no podían cuidarte."
                    8 -> "Uno de tus padres (o ambos) se unió a los scoia’tael en un intento de vengarse de los humanos, que considera que arruinan vuestras vidas."
                    9 -> "Uno de tus padres (o ambos) murió en un “accidente”. Lo más probable es que se ganase un poderoso enemigo que finalmente encontró una manera de librarse de él/ella."
                    else -> "Error"
                }
            }
        }
    }

    private fun generateFamilyFate(context: Context, homeland: WitcherHomeland): String {
        return when (homeland) {
            NORTHERN_KINGDOMS -> {
                when (Random.nextInt(10)) {
                    0 -> "La guerra dispersó a tu familia a los cuatro vientos y no tienes ni idea de dónde están."
                    1 -> "Tu familia fue encarcelada por sus crímenes o bajo cargos falsos. Solo tú escapaste. Puede que quieras liberarlos... o no."
                    2 -> "El hogar familiar quedó maldito y ahora sus cultivos no dan fruto o los espectros moran por sus salones. Se volvió demasiado peligroso quedarse en esa casa."
                    3 -> "Con tantas guerras, tu familia perdió su medio de subsistencia y empezó a delinquir para sobrevivir."
                    4 -> "Tu familia contrajo una gran deuda apostando o pidiendo prestado. Necesitas dinero desesperadamente."
                    5 -> "Tu familia está enzarzada en una reyerta con otra familia. Puede que ni siquiera recordéis cómo empezó."
                    6 -> "Por acción u omisión, en vuestra ciudad odian a tu familia y nadie quiere tener nada que ver con vosotros."
                    7 -> "Un día, un grupo de bandidos os quitó todo lo que teníais. Tu familia fue masacrada y te quedaste totalmente solo."
                    8 -> "Tu familia tiene un oscuro secreto que, si se descubriera, la arruinaría por completo. Puedes decidir cuál es o dejar que lo haga el Director de Juego."
                    9 -> "Los miembros de tu familia se odian. Las personas con las que creciste no se hablan y tú tienes suerte de que tus hermanos te saluden al pasar."
                    else -> "Error"
                }
            }
            NILFGAARD -> {
                when (Random.nextInt(10)) {
                    0 -> "Tu familia fue condenada a trabajos forzosos por crímenes contra el Imperio o bajo cargos falsos. Solo tú escapaste."
                    1 -> "Tu familia fue exiliada al Desierto de Korath y probablemente pasaste la mayor parte de tu infancia luchando por sobrevivir en ese yermo."
                    2 -> "Tu familia murió a manos de un mago rebelde que tenía rencillas con tu familia o simplemente buscaba sangre. En todo caso, estás solo."
                    3 -> "Tu familia desapareció y no tienes ni idea de dónde fueron. Un buen día se largaron sin más."
                    4 -> "Tu familia fue ejecutada por traición al Imperio. Fuiste el único que escapó a este destino."
                    5 -> "Por alguna razón, tu familia fue despojada de sus títulos. Os echaron de vuestro hogar y lucháis por sobrevivir entre la plebe."
                    6 -> "El nombre de tu familia quedó empañado por un pariente mago que hizo alarde de su don escandalosamente, como un mago norteño."
                    7 -> "Deshonraste a tu familia a ojos del Imperio. Algo que hiciste (o que no lograste hacer) ha echado por tierra tu nombre y perjudicado a tu familia."
                    8 -> "Tu familia tiene un oscuro secreto que, si se descubriera, arruinaría para siempre su nombre y sus vidas. Debes protegerlo con tu vida."
                    9 -> "Tu familia fue asesinada. Puede que se interpusiesen en los planes de alguien o que los utilizasen para perjudicar a alguien más poderoso. En cualquier caso, ya no están."
                    else -> "Error"
                }
            }
            ELF, DWARF -> {
                when (Random.nextInt(10)) {
                    0 -> "Tu familia está marcada como simpatizante de los humanos y no es especialmente apreciada en su tierra."
                    1 -> "Tu familia quedó marginada por tener opiniones distintas y tu pueblo no socializa en absoluto contigo ni con tu familia."
                    2 -> "Tu familia murió en las Guerras del Norte. Puede que luchasen en la guerra o que fuesen víctimas inocentes que estaban en el lugar equivocado."
                    3 -> "Tu familia lleva siglos enzarzada en una reyerta familiar. Quizá no se recuerde cómo empezó, pero es encarnizada."
                    4 -> "Por alguna razón, a tu familia se le despojó de sus títulos. Os echaron de vuestro hogar y lucháis por sobrevivir."
                    5 -> "Cuando eras muy joven, tu familia empezó a asaltar asentamientos humanos para obtener comida y quizá vengarse de ellos."
                    6 -> "Vuestra residencia familiar está maldita. Lo más probable es que se deba a que fue escenario de muchísimas muertes durante la guerra contra los humanos."
                    7 -> "Tu familia está dividida desde que un pariente tuyo se casó con un humano. A una parte de tu familia le gusta, pero otros lo odian."
                    8 -> "Tu familia mató humanos que los confundieron con scoia’tael. Puede que haya sido masacrada o ahorcada sin juicio previo."
                    9 -> "Tu familia desciende de un infame traidor. Eso afecta a todas las interacciones de tu familia con otros sujetos de las razas antiguas y os ha complicado la vida en las tierras antiguas."
                    else -> "Error"
                }
            }
        }
    }

    private fun generateBrothers(context: Context, homeland: WitcherHomeland): String {
        val roll = Random.nextInt(1, 11)
        val builder = StringBuilder()
        return when (homeland) {
            NORTHERN_KINGDOMS -> {
                if (roll < 9) {
                    for (i in 1..roll) {
                        builder.append("$i. ")
                        builder.append(generateOneBrother(context))
                        builder.append("<br>")
                    }
                    builder.toString()
                } else {
                    "Sin hermanos"
                }
            }
            NILFGAARD, DWARF -> {
                if (roll < 6) {
                    for (i in 1..roll) {
                        builder.append("$i. ")
                        builder.append(generateOneBrother(context))
                        builder.append("<br>")
                    }
                    builder.toString()
                } else {
                    "Sin hermanos"
                }
            }
            ELF -> {
                when {
                    roll < 3 -> {
                        for (i in 1..roll) {
                            builder.append("$i. ")
                            builder.append(generateOneBrother(context))
                            builder.append("<br>")
                        }
                        builder.toString()
                    }
                    roll < 9 -> "Sin hermanos"
                    else -> {
                        for (i in 1..2) {
                            builder.append("$i. ")
                            builder.append(generateOneBrother(context))
                            builder.append("<br>")
                        }
                        builder.toString()
                    }
                }
            }
        }
    }

    private fun generateOneBrother(context: Context): String {
        val gender = if (Random.nextBoolean()) "Hombre" else "Mujer"
        val ageRoll = Random.nextInt(1, 11)
        val age = when {
            ageRoll < 6 -> "Menor"
            ageRoll < 10 -> "Mayor"
            else -> "Gemelo"
        }
        val feelings = when (Random.nextInt(1, 11)) {
            1 -> "Quiere verte muerto"
            2 -> "No te soporta"
            3 -> "Te envidia"
            4, 5, 6, 7 -> "Indiferente hacia ti"
            8 -> "Le gustas"
            9 -> "Te admira"
            10 -> "Es posesivo contigo"
            else -> "Error"
        }
        val trait = when (Random.nextInt(1, 11)) {
            1 -> "Tímido"
            2 -> "Agresivo"
            3 -> "Amable"
            4 -> "Extraño"
            5 -> "Reflexivo"
            6 -> "Elocuente"
            7 -> "Romántico"
            8 -> "Serio"
            9 -> "Depresivo"
            10 -> "Inmaduro"
            else -> "Error $this"
        }
        val dead = Random.nextInt(0, 10) < 2
        return "Hermano $age, $gender. Es $trait y $feelings.${if (dead) " Está muerto." else ""}"
    }

    fun generateLifeEvents(context: Context, age: Int): String {
        val builder = StringBuilder()
        for (i in 1..age / 10) {
            builder.append("${i*10}. ")
            builder.append(generateOneLifeEvent(context))
            builder.append("<br>")
        }
        return builder.toString()
    }

    private fun generateOneLifeEvent(context: Context): String {
        return when (Random.nextInt(1, 11)) {
            1, 2, 3, 4 -> if (Random.nextBoolean()) generateOneFortune(context) else generateOneMisfortune(
                context
            )
            5, 6, 7 -> if (Random.nextBoolean()) generateOneAlly(context) else generateOneEnemy(
                context
            )
            else -> generateOneRomance(context)
        }
    }

    private fun generateOneFortune(context: Context): String =
        "<b>Ventura:</b> ${when (Random.nextInt(1, 11)) {
            1 -> "Algún acontecimiento importante o un golpe de suerte te aporta 1d10x100 coronas."
            2 -> "Entrenaste con un profesor. Recibes +1 a una habilidad de INT o desarrollas una nueva habilidad de INT a +2."
            3 -> "Algo que hiciste te valió 1 favor por parte de un noble."
            4 -> "Entrenaste con un soldado. Recibes +1 a una habilidad de combate o desarrollas una nueva habilidad de combate a +2."
            5 -> "Encontraste a un brujo en una ocasión y lograste granjearte un favor suyo."
            6 -> "Te relacionaste con una compañía de bandidos. Una vez al mes, puedes pedir 1 favor a uno de ellos."
            7 -> {
                val animal = if (Random.nextInt(1, 11) < 8) "Perro salvaje" else "Lobo"
                "Domaste un $animal que encontraste en campo abierto."
            }
            8 -> "Lograste granjearte 1 favor de un poderoso mago al que ayudaste."
            9 -> "Recibiste un símbolo sagrado que puedes mostrar a los seguidores de dicha fe para recibir un +2 a Carisma al tratar con ellos."
            10 -> "Te nombraron caballero por el valor mostrado en un reino aleatorio. En dicho reino recibes +2 a Reputación y se reconoce tu título."
            else -> context.getString(R.string.error)
        }}"

    private fun generateOneMisfortune(context: Context): String =
        "<b>Desventura:</b> ${when (Random.nextInt(1, 11)) {
            1 -> "Te endeudaste hasta el punto de deber alrededor de ${Random.nextInt(1, 11) * 100} coronas."
            2 -> "Algo que hiciste (o una acusación en falso) llevó a que te encarcelasen ${Random.nextInt(1, 11)} meses"
            3 -> "Contrajiste una adicción. Puedes escogerla. Consulta la nota al margen (pág. 32)."
            4 -> {
                val deathCause = when (Random.nextInt(1, 11)) {
                    1, 2, 3, 4, 5 -> "murió en un accidente"
                    6, 7, 8 -> "murió a manos de monstruos"
                    else -> "murió a manos de bandidos"
                }
                "Un amante, amigo o pariente $deathCause"
            }
            5 -> {
                val fake = when (Random.nextInt(1, 11)) {
                    1, 2, 3 -> "robo"
                    4, 5 -> "cobardía o traición"
                    6, 7, 8 -> "asesinato"
                    9 -> "violación"
                    else -> "brujería ilegal"
                }
                "Te acusaron falsamente del delito de $fake"
            }
            6 -> {
                val size = when (Random.nextInt(1, 11)) {
                    1, 2, 3 -> "Unos cuantos guardias"
                    4, 5, 6 -> "Todo un pueblo"
                    7, 8 -> "Una ciudad importante"
                    else -> "Todo un reino"
                }
                "$size te persigue para que respondas ante la ley"
            }
            7 -> {
                when (Random.nextInt(1, 11)) {
                    1, 2, 3 -> "Alguien te chantajea"
                    4, 5, 6, 7 -> "Se reveló un secreto traicionero"
                    else -> "Alguien muy cercano a ti te traicionó"
                }
            }
            8 -> {
                val sequels = when (Random.nextInt(1, 11)) {
                    1, 2, 3, 4 -> "quedaste desfigurado (cambia tu Estatus social a Temido)"
                    5, 6 -> "pasaste ${Random.nextInt(1, 11)} meses en tratamiento"
                    7, 8 -> "perdiste ${Random.nextInt(1, 11)} meses de recuerdos de aquel año"
                    else -> "ahora 7 de cada 10 noches sufres horribles pesadillas"
                }
                "Sufriste un accidente y $sequels"
            }
            9 -> {
                when (Random.nextInt(1, 11)) {
                    1, 2, 3 -> "Te envenenaron, pierdes permanentemente 5PV"
                    4, 5, 6, 7 -> "Sufres ataques de ansiedad y, en situaciones de estrés, debes realizar tiradas de salvación contra Aturdimiento cada 5 turnos"
                    else -> "Sufres una psicosis grave, oyes voces y eres violento, irracional y depresivo (el DJ controla dichas voces)"
                }
            }
            10 -> "Te maldijeron. Consulta la sección de Maldiciones, en la página 230, para determinar los detalles."
            else -> context.getString(R.string.error)
        }}"

    private fun generateOneAlly(context: Context): String {
        val gender = if (Random.nextBoolean()) "Hombre" else "Mujer"
        val position = when (Random.nextInt(1, 11)) {
            1 -> "Cazarrecompensas"
            2 -> "Mago"
            3 -> "Mentor o Maestro"
            4 -> "Amigo de la infancia"
            5 -> "Artesano"
            6 -> "Antiguo enemigo"
            7 -> "Duque"
            8 -> "Sacerdote"
            9 -> "Soldado"
            10 -> "Bardo"
            else -> context.getString(R.string.error)
        }
        val howYouMet = when (Random.nextInt(1, 11)) {
            1 -> "Le salvaste de algo"
            2 -> "Os conocisteis en una taberna"
            3 -> "Te salvó de algo"
            4 -> "Te contrató para algo"
            5 -> "Os quedasteis atrapados juntos"
            6 -> "Os obligaron a colaborar"
            7 -> "Le contrataste para algo"
            8 -> "Os conocisteis borrachos e hicisteis buenas migas"
            9 -> "Os conocisteis viajando"
            10 -> "Luchasteis juntos"
            else -> context.getString(R.string.error)
        }
        val relation = when (Random.nextInt(1, 11)) {
            1, 2, 3, 4 -> "Sois conocidos"
            5, 6 -> "Sois amigos"
            7, 8 -> "Sois amigos Íntimos"
            9 -> "Sois inseparables"
            10 -> "Compartís un Vínculo"
            else -> context.getString(R.string.error)
        }
        val whereIsShe = when (Random.nextInt(1, 11)) {
            1, 2, 3 -> "Los Reinos del Norte"
            4, 5, 6 -> "El Imperio de Nilfgaard"
            7, 8 -> "Las Tierras Antiguas"
            9, 10 -> "Algún lugar más allá de los Límites Conocidos"
            else -> context.getString(R.string.error)
        }
        return "<b>Aliado:</b> $position $gender. $howYouMet y ahora $relation. Está en $whereIsShe"
    }

    private fun generateOneEnemy(context: Context): String {
        val whoWhereWronged = if (Random.nextBoolean()) "Él te agravió" else "Tú le agraviaste"
        val gender = if (Random.nextBoolean()) "Hombre" else "Mujer"
        val position = when (Random.nextInt(1, 11)) {
            1 -> "Examigo"
            2 -> "Examante"
            3 -> "Pariente"
            4 -> "Enemigo de la infancia"
            5 -> "Sectario"
            6 -> "Bardo"
            7 -> "Soldado"
            8 -> "Bandido"
            9 -> "Duque"
            10 -> "Mago"
            else -> context.getString(R.string.error)
        }
        val cause = when (Random.nextInt(1, 11)) {
            1 -> "Uno atacó al otro"
            2 -> "Uno causó la pérdida de un ser querido"
            3 -> "Uno causó una gran humillación"
            4 -> "Uno provocó una maldición"
            5 -> "Uno acusó al otro de brujería ilegal"
            6 -> "Uno rechazó románticamente al otro"
            7 -> "Uno causó una terrible herida al otro"
            8 -> "Chantaje"
            9 -> "Uno frustró los planes del otro"
            10 -> "Uno provocó el ataque de un monstruo"
            else -> context.getString(R.string.error)
        }
        val power = Random.nextInt(1, 11)
        val howIsNow = when (Random.nextInt(1, 11)) {
            1, 2 -> "Está prácticamente olvidado"
            3, 4 -> "Piensa jugártela o piensas jugársela"
            5, 6 -> "Atacará o atacarás si os encontráis"
            7, 8 -> "Te busca para vengarse o le buscas para vengarte"
            9, 10 -> "Busca o buscas sangre"
            else -> context.getString(R.string.error)
        }
        val powerType = when (Random.nextInt(1, 11)) {
            1, 2 -> "Social"
            3, 4 -> "Conocimiento"
            5, 6 -> "Físico"
            7, 8 -> "Secuaces"
            9, 10 -> "Magia"
            else -> context.getString(R.string.error)
        }
        return "<b>Enemigo:</b> $position $gender. $whoWhereWronged, $cause. Ahora $howIsNow y él tiene poder $powerType de nivel $power"
    }

    private fun generateOneRomance(context: Context): String {
        return "<b>Romance:</b> ${when (Random.nextInt(1, 11)) {
            1 -> "Relación Feliz"
            2, 3, 4 -> when (Random.nextInt(1, 11)) {
                1 -> "Hace algún tiempo, unos bandidos capturaron a tu amante y sigue cautivo."
                2 -> "Un día, tu amante desapareció misteriosamente y no sabes adónde fue."
                3 -> "Encarcelaron o exiliaron a tu amante por delitos que quizá no cometiera."
                4 -> "Una poderosa maldición os separó a ti y a tu amante."
                5 -> "Algo se interpuso entre vosotros y te viste obligado a matar a tu amante"
                6 -> "Tu amante se suicidó; puede que no sepas por qué"
                7 -> "Un noble secuestró a tu amante, a quien tomó en concubinato"
                8 -> "Un rival se libró de ti y se hizo con el amor de tu amante"
                9 -> "Unos monstruos mataron a tu amante; puede que fuese un accidente o que estuviera planeado"
                10 -> "Tu amante es un mago (o maga), un brujo o un monstruo racional, por lo que el romance está abocado al fracaso"
                else -> context.getString(R.string.error)
            }
            5, 6 -> when (Random.nextInt(1, 11)) {
                1 -> "La familia o amigos de tu amante te odian y no aprueban vuestro romance"
                2 -> "Tu amante se prostituye y se niega a abandonar su trabajo"
                3 -> "Tu amante padece una maldición menor, como paranoia u horribles pesadillas"
                4 -> "Tu amante se acostaba con cualquiera y se negó a parar cuando os conocisteis"
                5 -> "Tu amante tiene unos celos enfermizos y no soporta verte con un posible rival"
                6 -> "Discutís constantemente y nada puede impedirlo durante mucho tiempo. Siempre acabáis gritándoos"
                7 -> "Sois rivales profesionales. A menudo os robáis clientes mutuamente."
                8 -> "Uno de los dos es humano y el otro es no-humano, lo que os complica la vida"
                9 -> "Tu amante está casado. Puede que esté dispuesto a dejar a su pareja, o no"
                10 -> "Tus amigos o familiares odian a tu amante y no aprueban vuestro romance"
                else -> context.getString(R.string.error)
            }
            7, 8, 9, 10 -> "Prostitución y Libertinaje"
            else -> context.getString(R.string.error)
        }}"
    }

    fun generateStyle(context: Context): String {
        val clothing = when (Random.nextInt(1, 11)) {
            1 -> "Uniforme"
            2 -> "Ropa de Viaje"
            3 -> "Ropa Elegante"
            4 -> "Ropa Harapienta"
            5 -> "Ropa Práctica"
            6 -> "Ropa Tradicional"
            7 -> "Ropa Provocativa"
            8 -> "Ropa Pesada"
            9 -> "Ropa Extraña"
            10 -> "Ropa Extravagante"
            else -> context.getString(R.string.error)
        }
        val personality = when (Random.nextInt(1, 11)) {
            1 -> "Reservada"
            2 -> "Rebelde"
            3 -> "Violenta"
            4 -> "Idealista"
            5 -> "Contemplativa"
            6 -> "Seria"
            7 -> "Engañosa"
            8 -> "Simpática"
            9 -> "Arrogante"
            10 -> "Nerviosa"
            else -> context.getString(R.string.error)
        }
        val hairStyle = when (Random.nextInt(1, 11)) {
            1 -> "Largo y Suelto"
            2 -> "Rapado"
            3 -> "Corto e irregular"
            4 -> "Trenzado"
            5 -> "Largo y Despeinado"
            6 -> "Calvo"
            7 -> "Corto Uniforme"
            8 -> "Desgreñado y Desastrado"
            9 -> "Peinado Complejo"
            10 -> "Rapado por los Lados"
            else -> context.getString(R.string.error)
        }
        val affectations = when (Random.nextInt(1, 11)) {
            1 -> "Trofeos"
            2 -> "Anillos y Joyas"
            3 -> "Baratijas"
            4 -> "Tatuajes"
            5 -> "Pintura de Guerra"
            6 -> "Capa Sombría"
            7 -> "Pañuelos Llamativos"
            8 -> "Parche en un Ojo"
            9 -> "Pieles"
            10 -> "Insignias y Placas"
            else -> context.getString(R.string.error)
        }
        return "<b>Estilo:</b> Vistes con $clothing y llevas el pelo $hairStyle. Tienes una personalidad $personality y llevas $affectations"
    }

    fun generateValues(context: Context): String {
        val valuedPerson = when (Random.nextInt(1, 11)) {
            1 -> "tu Padre o Madre"
            2 -> "un Hermano/a"
            3 -> "tu Amante"
            4 -> "un Amigo"
            5 -> "Tú mismo"
            6 -> "una Mascota"
            7 -> "un Mentor"
            8 -> "un Personaje Público"
            9 -> "un Ídolo Personal"
            10 -> "Nadie"
            else -> context.getString(R.string.error)
        }
        val value = when (Random.nextInt(1, 11)) {
            1 -> "el Dinero"
            2 -> "el Honor"
            3 -> "Tu Palabra"
            4 -> "la Búsqueda del Placer"
            5 -> "el Conocimiento"
            6 -> "la Venganza"
            7 -> "el Poder"
            8 -> "el Amor"
            9 -> "la Supervivencia"
            10 -> "la Amistad"
            else -> context.getString(R.string.error)
        }
        val feelingsOnPeople = when (Random.nextInt(1, 11)) {
            1 -> "Las personas son herramientas que usar."
            2 -> "Solo los míos, a los demás que les den."
            3 -> "No se puede confiar en nadie."
            4 -> "Las personas tienen que demostrar lo que valen."
            5, 6 -> "Neutral."
            7 -> "La gente es genial"
            8 -> "Todos merecen la muerte"
            9 -> "Todos son unos cerdos hedonistas"
            10 -> "Toda vida es valiosa"
            else -> context.getString(R.string.error)
        }
        return "<b>Valores:</b> Tu valor principal es $value y tu persona apreciada es $valuedPerson. Definirías tus sentimientos hacia los demás así: \"$feelingsOnPeople\""
    }
}