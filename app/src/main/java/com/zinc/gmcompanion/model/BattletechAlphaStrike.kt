package com.zinc.gmcompanion.model

import android.content.Context
import android.util.Log

data class ASMech(var points: Int, var model: String, var variant: String)

class BattletechAlphaStrike {

    private fun add1MechViableLances(
        filteredList: ArrayList<ASMech>,
        viableLances: ArrayList<List<ASMech>>,
        bvRange: IntRange
    ) {
        filteredList.forEach {
            if (bvRange.contains(it.points)) {
                viableLances.add(arrayListOf(it))
            }
        }
    }

    private fun add2MechViableLances(
        filteredList: ArrayList<ASMech>,
        viableLances: ArrayList<List<ASMech>>,
        bvRange: IntRange
    ) {
        for (mech1 in filteredList) {
            for (mech2 in filteredList) {
                if (mech1.model == mech2.model) continue
                if (bvRange.contains(mech1.points + mech2.points)
                ) {
                    viableLances.add(listOf(mech1, mech2).sortedBy { it.model })
                }
            }
        }
    }

    private fun add3MechViableLances(
        filteredList: ArrayList<ASMech>,
        viableLances: ArrayList<List<ASMech>>,
        bvRange: IntRange
    ) {
        for (mech1 in filteredList) {
            for (mech2 in filteredList) {
                if (mech1.model == mech2.model) continue
                for (mech3 in filteredList) {
//                    Log.d("patata", "mech 3 check")
                    if (mech1.model == mech2.model
                        || mech1.model == mech3.model
                        || mech2.model == mech3.model
                    ) continue
//                    Log.d("patata", "mech 3 go")
                    if (bvRange.contains(mech1.points + mech2.points + mech3.points)) {
                        viableLances.add(listOf(mech1, mech2, mech3).sortedBy { it.model })
                    }
                }
            }
        }
    }

    private fun add4MechViableLances(
        filteredList: ArrayList<ASMech>,
        viableLances: ArrayList<List<ASMech>>,
        bvRange: IntRange
    ) {
        for (mech1 in filteredList) {
            for (mech2 in filteredList) {
                if (mech1.model == mech2.model) continue
                for (mech3 in filteredList) {
                    if (mech1.model == mech3.model
                        || mech2.model == mech3.model
                    ) continue
                    val sumaPuntos = mech1.points + mech2.points + mech3.points
                    for (mech4 in filteredList) {
                        if (mech1.model == mech4.model
                            || mech2.model == mech4.model
                            || mech3.model == mech1.model
                            || mech3.model == mech2.model
                            || mech3.model == mech4.model
                        ) continue

                        if (bvRange.contains(sumaPuntos + mech4.points)
                        ) {
                            viableLances.add(
                                listOf(
                                    mech1,
                                    mech2,
                                    mech3,
                                    mech4
                                ).sortedBy { it.model })
                        }
                    }
                }
            }
        }
    }

    private fun getAllViableLances(
        totalPoints: Int,
        tolerance: Int,
        minMechs: Int,
        maxMechs: Int
    ): ArrayList<List<ASMech>> {
        Log.d("patata", "get viableLances")
        val filteredList = arrayListOf<ASMech>()
        getFullMechList().forEach { if (it.points <= totalPoints) filteredList.add(it) }
        val viableLances = arrayListOf<List<ASMech>>()
        val minPoints = totalPoints - tolerance
        val maxPoints = totalPoints + tolerance
        val bvRange = IntRange(minPoints, maxPoints)


        if (maxMechs == 1) {
            add1MechViableLances(filteredList, viableLances, bvRange)
        } else if (minMechs == 1 && maxMechs == 2) {
            add1MechViableLances(filteredList, viableLances, bvRange)
            add2MechViableLances(filteredList, viableLances, bvRange)
        } else if (minMechs == 1 && maxMechs == 3) {
            add1MechViableLances(filteredList, viableLances, bvRange)
            add2MechViableLances(filteredList, viableLances, bvRange)
            add3MechViableLances(filteredList, viableLances, bvRange)
        } else if (minMechs == 1 && maxMechs == 4) {
            add1MechViableLances(filteredList, viableLances, bvRange)
            add2MechViableLances(filteredList, viableLances, bvRange)
            add3MechViableLances(filteredList, viableLances, bvRange)
            add4MechViableLances(filteredList, viableLances, bvRange)
        } else if (minMechs == 2 && maxMechs == 2) {
            add2MechViableLances(filteredList, viableLances, bvRange)
        } else if (minMechs == 2 && maxMechs == 3) {
            add2MechViableLances(filteredList, viableLances, bvRange)
            add3MechViableLances(filteredList, viableLances, bvRange)
        } else if (minMechs == 2 && maxMechs == 4) {
            add2MechViableLances(filteredList, viableLances, bvRange)
            add3MechViableLances(filteredList, viableLances, bvRange)
            add4MechViableLances(filteredList, viableLances, bvRange)
        } else if (minMechs == 3 && maxMechs == 3) {
            add3MechViableLances(filteredList, viableLances, bvRange)
        } else if (minMechs == 3 && maxMechs == 4) {
            add3MechViableLances(filteredList, viableLances, bvRange)
            add4MechViableLances(filteredList, viableLances, bvRange)
        } else if (minMechs == 4 && maxMechs == 4) {
            add4MechViableLances(filteredList, viableLances, bvRange)
        }

        viableLances.shuffle()
        Log.d("patata", "viableLances size: ${viableLances.size}")
        return viableLances
    }

    fun generateMechList(
        applicationContext: Context?,
        totalPoints: Int,
        tolerance: Int,
        minMechs: Int,
        maxMechs: Int
    ): String = lancesToString(getAllViableLances(totalPoints, tolerance, minMechs, maxMechs))

    private fun lancesToString(viableLances: java.util.ArrayList<List<ASMech>>): String {
        val sb = StringBuilder()
        viableLances.forEach { it ->
            sb.append("<b>·Lance: </b>")
            it.forEach {
                sb.append("${it.model} ${it.variant}(${it.points}), ")
            }
            sb.append("<br>")
        }

        return sb.toString()
    }

    fun getMechLances(
        applicationContext: Context?,
        totalPoints: Int,
        tolerance: Int,
        minMechs: Int,
        maxMechs: Int
    ): String {
        Log.d("patata", "getMechLances")
        val viableLances = getAllViableLances(totalPoints, tolerance, minMechs, maxMechs)
        Log.d("patata", "getMechLances post getAllViableLances")
        val okLances = arrayListOf<List<ASMech>>()
        val alreadyUsedMechs = arrayListOf<String>()
        viableLances.forEach { lance ->
            var isAnyMechOfLanceAlreadyUsed = false
            lance.forEach { mech ->
                if (alreadyUsedMechs.contains(mech.model)) {
                    isAnyMechOfLanceAlreadyUsed = true
                }
            }
            if (!isAnyMechOfLanceAlreadyUsed) {
                lance.forEach { mech ->
                    alreadyUsedMechs.add(mech.model)
                }
                okLances.add(lance)
            }
        }
        return lancesToString(okLances)
    }

    companion object {
        fun getMechModelList(): ArrayList<String> {
            val arrayList = arrayListOf<String>()
            for (mech in BattletechAlphaStrike.getFullMechList()) if (!arrayList.contains(mech.model)) arrayList.add(
                mech.model
            )
            return arrayList
        }
    }
}

private fun BattletechAlphaStrike.Companion.getFullMechList(): List<ASMech> {
    return listOf(
        ASMech(34, "Archer", "ARC-2K"),
        ASMech(39, "Archer", "ARC-2R"),
        ASMech(39, "Awesome", "AWS-8Q"),
        ASMech(38, "Awesome", "AWS-8R"),
        ASMech(40, "Battlemaster", "BLR-1D"),
        ASMech(42, "Battlemaster", "BLR-1S"),
        ASMech(32, "Catapult", "CPLT-K2"),
        ASMech(31, "Catapult", "CPLT-A1"),
        ASMech(17, "Commando", "COM-2D"),
        ASMech(14, "Commando", "COM-1C"),
        ASMech(27, "Fire Falcon", "A"),
        ASMech(34, "Fire Falcon", "C"),
        ASMech(19, "Flea", "FLE-16"),
        ASMech(14, "Flea", "FLE-15"),
        ASMech(31, "Griffin", "GRF-1N"),
        ASMech(31, "Griffin", "GRF-1S"),
        ASMech(20, "Jenner", "JR7-A"),
        ASMech(26, "Jenner", "JR7-D"),
        ASMech(53, "Kodiak", "Standard"),
        ASMech(59, "Kodiak", "4"),
        ASMech(21, "Locust", "LCT-1M"),
        ASMech(19, "Locust", "LCT-1E"),
        ASMech(34, "Marauder", "MAD-3M"),
        ASMech(35, "Marauder", "MAD-3R"),
        ASMech(39, "Orion", "ON1-K"),
        ASMech(35, "Orion", "ON1-V"),
        ASMech(26, "Phoenix Hawk", "PXH-1"),
        ASMech(29, "Phoenix Hawk", "PXH-1K"),
        ASMech(28, "Rifleman", "RFL-3C"),
        ASMech(27, "Rifleman", "RFL-4D"),
        ASMech(30, "Shadow Hawk", "SHD-2H"),
        ASMech(26, "Shadow Hawk", "SHD-2D"),
        ASMech(22, "Stinger", "STG-3Gb"),
        ASMech(14, "Stinger", "STG-3G"),
        ASMech(35, "Thunderbolt", "TDR-5D"),
        ASMech(35, "Thunderbolt", "TDR-5SE"),
        ASMech(22, "Valkyrie", "VLK-QA"),
        ASMech(19, "Valkyrie", "VLK-QF"),
        ASMech(36, "Warhammer", "WHM-6D"),
        ASMech(31, "Warhammer", "WHM-6L"),
        ASMech(14, "Wasp", "WSP-1A"),
        ASMech(12, "Wasp", "WSP-1W"),
        ASMech(35, "Wolverine", "WVR-6K"),
        ASMech(30, "Wolverine", "WVR-6R"),
    )

}
