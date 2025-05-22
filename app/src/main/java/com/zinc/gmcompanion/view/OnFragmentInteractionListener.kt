package com.zinc.gmcompanion.view

import android.view.View
import com.zinc.gmcompanion.model.*
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
    fun getRandomAlphaStrikeIACard(mechRole: AlphaStrikeMechType): MechIACard
    fun getRandomFate(odds: FateOdds, chaosValue: Int): String
    fun getRandomEvent(): String
    fun getRandomSceneChanges(chaosValue: Int): String
    fun getMechListAndBV(totalBV: Int, tolerance: Int, minMechs: Int, maxMechs: Int): String
    fun getMechLances(totalBV: Int, tolerance: Int, minMechs: Int, maxMechs: Int): String
    fun getASMechListAndPoints(totalBV: Int, tolerance: Int, minMechs: Int, maxMechs: Int): String
    fun getASMechLances(totalBV: Int, tolerance: Int, minMechs: Int, maxMechs: Int): String
    fun generateMarvelEvent(event: View)
    fun generateMarvelGame(event: View)
}