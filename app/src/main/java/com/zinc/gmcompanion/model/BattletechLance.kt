package com.zinc.gmcompanion.model

import android.content.Context

data class Mech(var battleValue: Int, var model: String, var variant: String)

class BattletechLance {
    fun getFullMechList(): List<Mech> = listOf(
        Mech(1790, "Archer", "ARC-2K"),
        Mech(1950, "Archer", "ARC-2R"),
        Mech(2119, "Awesome", "AWS-8Q"),
        Mech(2103, "Awesome", "AWS-8T"),
        Mech(2005, "Battlemaster", "BLR-1G"),
        Mech(1989, "Battlemaster", "BLR-12"),
        Mech(1639, "Catapult", "CPLT-C1 'Butterbee'"),
        Mech(1847, "Catapult", "CPLT-C1"),
        Mech(737, "Commando", "COM-1D"),
        Mech(713, "Commando", "COM-3A"),
        Mech(1085, "Fire Falcon", "A"),
        Mech(1444, "Fire Falcon", "E"),
        Mech(668, "Flea", "FLE-16"),
        Mech(570, "Flea", "FLE-4"),
        Mech(1679, "Griffin", "GRF-1N"),
        Mech(1654, "Griffin", "GRF-1S"),
        Mech(940, "Jenner", "JR7-A"),
        Mech(1155, "Jenner", "JR7-D"),
        Mech(3864, "Kodiak", "Standard"),
        Mech(3601, "Kodiak", "4"),
        Mech(560, "Locust", "LCT-1M"),
        Mech(570, "Locust", "LCT-1V"),
        Mech(1762, "Marauder", "MAD-3M"),
        Mech(1799, "Marauder", "MAD-3R"),
        Mech(1886, "Orion", "ON1-K"),
        Mech(1713, "Orion", "ON1-V"),
        Mech(1374, "Phoenix Hawk", "PXH-1"),
        Mech(1416, "Phoenix Hawk", "PXH-1K"),
        Mech(1407, "Rifleman", "RFL-3C"),
        Mech(1371, "Rifleman", "RFL-3N"),
        Mech(1404, "Shadow Hawk", "SHD-2H"),
        Mech(1514, "Shadow Hawk", "SHD-2K"),
        Mech(656, "Stinger", "STG-3G"),
        Mech(474, "Stinger", "STG-3R"),
        Mech(1625, "Thunderbolt", "TDR-5D"),
        Mech(1762, "Thunderbolt", "TDR-5S"),
        Mech(954, "Valkyrie", "VLK-QA"),
        Mech(842, "Valkyrie", "VLK-QD2"),
        Mech(1942, "Warhammer", "WHM-6D"),
        Mech(1715, "Warhammer", "WHM-6R"),
        Mech(507, "Wasp", "WSP-1A"),
        Mech(492, "Wasp", "WSP-1W"),
        Mech(1472, "Wolverine", "WVR-6D"),
        Mech(1453, "Wolverine", "WVR-6R"),
    )

    private fun add1MechViableLances(
        filteredList: ArrayList<Mech>,
        viableLances: ArrayList<List<Mech>>,
        bvRange: IntRange
    ) {
        filteredList.forEach {
            if (bvRange.contains(it.battleValue)) {
                viableLances.add(arrayListOf(it))
            }
        }
    }

    private fun add2MechViableLances(
        filteredList: ArrayList<Mech>,
        viableLances: ArrayList<List<Mech>>,
        bvRange: IntRange
    ) {
        for (mech1 in filteredList) {
            for (mech2 in filteredList) {
                if (mech1.model != mech2.model
                    && bvRange.contains(mech1.battleValue + mech2.battleValue)
                ) {
                    if (!viableLances.contains(listOf(mech1, mech2).sortedBy { it.model })) {
                        viableLances.add(listOf(mech1, mech2).sortedBy { it.model })
                    }
                }
            }
        }
    }

    private fun add3MechViableLances(
        filteredList: ArrayList<Mech>,
        viableLances: ArrayList<List<Mech>>,
        bvRange: IntRange
    ) {
        for (mech1 in filteredList) {
            for (mech2 in filteredList) {
                for (mech3 in filteredList) {
                    if (mech1.model != mech2.model
                        && mech1.model != mech3.model
                        && mech2.model != mech3.model
                        && bvRange.contains(mech1.battleValue + mech2.battleValue + mech3.battleValue)
                    ) {
                        if (!viableLances.contains(
                                listOf(
                                    mech1,
                                    mech2,
                                    mech3
                                ).sortedBy { it.model })
                        ) {
                            viableLances.add(listOf(mech1, mech2, mech3).sortedBy { it.model })
                        }
                    }
                }
            }
        }
    }

    private fun add4MechViableLances(
        filteredList: ArrayList<Mech>,
        viableLances: ArrayList<List<Mech>>,
        bvRange: IntRange
    ) {
        for (mech1 in filteredList) {
            for (mech2 in filteredList) {
                for (mech3 in filteredList) {
                    for (mech4 in filteredList) {
                        if (mech1.model != mech2.model
                            && mech1.model != mech3.model
                            && mech1.model != mech4.model
                            && mech2.model != mech3.model
                            && mech2.model != mech4.model
                            && mech3.model != mech4.model
                            && bvRange.contains(mech1.battleValue + mech2.battleValue + mech3.battleValue + mech4.battleValue)
                        ) {
                            if (!viableLances.contains(
                                    listOf(
                                        mech1,
                                        mech2,
                                        mech3,
                                        mech4
                                    ).sortedBy { it.model })
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
    }

    private fun getAllViableLances(
        totalBV: Int,
        tolerance: Int,
        minMechs: Int,
        maxMechs: Int
    ): ArrayList<List<Mech>> {
        val filteredList = arrayListOf<Mech>()
        getFullMechList().forEach { if (it.battleValue <= totalBV) filteredList.add(it) }
        val viableLances = arrayListOf<List<Mech>>()
        val minBV = totalBV - tolerance
        val maxBV = totalBV + tolerance
        val bvRange = IntRange(minBV, maxBV)


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
        return viableLances
    }

    fun generateMechList(
        applicationContext: Context?,
        totalBV: Int,
        tolerance: Int,
        minMechs: Int,
        maxMechs: Int
    ): String = lancesToString(getAllViableLances(totalBV, tolerance, minMechs, maxMechs))

    private fun lancesToString(viableLances: java.util.ArrayList<List<Mech>>): String {
        val sb = StringBuilder()
        viableLances.forEach { it ->
            sb.append("<b>·Lance: </b>")
            it.forEach {
                sb.append("${it.model} ${it.variant}(${it.battleValue}), ")
            }
            sb.append("<br>")
        }

        return sb.toString()
    }

    fun getMechLances(
        applicationContext: Context?,
        totalBV: Int,
        tolerance: Int,
        minMechs: Int,
        maxMechs: Int
    ): String {
        val viableLances = getAllViableLances(totalBV, tolerance, minMechs, maxMechs)
        val okLances = arrayListOf<List<Mech>>()
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
}