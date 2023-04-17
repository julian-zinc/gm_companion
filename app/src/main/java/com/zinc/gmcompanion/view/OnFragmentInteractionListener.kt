package com.zinc.gmcompanion.view

import com.zinc.gmcompanion.model.AdventurePart
import com.zinc.gmcompanion.model.FateOdds
import com.zinc.gmcompanion.model.MechType
import com.zinc.gmcompanion.model.WitcherHomeland
import com.zinc.gmcompanion.view.secondaryFragments.ISecondaryFragment

interface OnFragmentInteractionListener {
    fun setFragment(fragmentI: ISecondaryFragment)
    fun getRandomLocationText()
    fun getRandomIcons(quantity: Int, part: AdventurePart): List<Pair<Int, String>>
    fun getRandomEarlyLife(homeland: WitcherHomeland): List<String>
    fun getRandomLifeEvents(age: Int): String
    fun getRandomStyle(): String
    fun getRandomValues(): String
    fun getRandomMechMovement(mechType: MechType, aggresivityValue: Int): String
    fun getRandomMechAttack(aggresivityValue: Int): String
    fun getRandomFate(odds: FateOdds, chaosValue: Int): String
    fun getRandomEvent(): String
    fun getRandomSceneChanges(chaosValue: Int): String
    fun getMechListAndBV(totalBV: Int, tolerance: Int, minMechs: Int, maxMechs: Int): String
}