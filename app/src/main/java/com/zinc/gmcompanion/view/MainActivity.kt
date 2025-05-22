package com.zinc.gmcompanion.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.model.*
import com.zinc.gmcompanion.presenter.Presenter
import com.zinc.gmcompanion.view.secondaryFragments.*


class MainActivity : AppCompatActivity(), OnFragmentInteractionListener, IView {
    companion object {
        const val WITCHER_COMBAT_FLOW_TAG = "WITCHER_COMBAT_FLOW_TAG"
        const val WITCHER_LIFE_TAG = "WITCHER_LIFE_TAG"
        const val ADVENTURE_GENERATOR_TAG = "ADVENTURE_GENERATOR_TAG"
        const val MARVEL_UNITED_TAG = "MARVEL_UNITED_TAG"
        const val BATTLETECH_IA_TAG = "BATTLETECH_IA_TAG"
        const val ALPHA_STRIKE_IA_TAG = "ALPHA_STRIKE_IA_TAG"
        const val BATTLETECH_KAIJU_TAG = "BATTLETECH_KAIJU_TAG"
        const val MYTHIC_TAG = "MYTHIC_TAG"
        const val LANCE_GENERATOR_TAG = "LANCE_GENERATOR_TAG"
        const val ALPHA_STRIKE_TAG = "ALPHA_STRIKE_TAG"
    }
    private val presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    MainFragment.newInstance()
                )
                .commitNow()
        }
        presenter.view = this
    }

    override fun setFragment(fragmentI: ISecondaryFragment) {
        val fragmentAndTag = getFragmentAndTag(fragmentI)
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                fragmentAndTag.first,
                fragmentAndTag.second
            )
            .addToBackStack(null).commit()
    }


    private fun getFragmentAndTag(secondaryFragment: ISecondaryFragment): Pair<Fragment, String> {
        return when (secondaryFragment) {
            is WitcherCombatFlowFragment -> WitcherCombatFlowFragment.newInstance() to WITCHER_COMBAT_FLOW_TAG
            is WitcherLifeEventsFragment -> WitcherLifeEventsFragment.newInstance() to WITCHER_LIFE_TAG
            is MarvelUnitedFragment -> MarvelUnitedFragment.newInstance() to MARVEL_UNITED_TAG
            is AdventureGeneratorFragment -> AdventureGeneratorFragment.newInstance() to ADVENTURE_GENERATOR_TAG
            is BattletechIAFragment -> BattletechIAFragment.newInstance() to BATTLETECH_IA_TAG
            is AlphaStrikeIAFragment -> AlphaStrikeIAFragment.newInstance() to ALPHA_STRIKE_IA_TAG
            is BattletechKaijuIAFragment -> BattletechKaijuIAFragment.newInstance() to BATTLETECH_KAIJU_TAG
            is MythicFragment -> MythicFragment.newInstance() to MYTHIC_TAG
            is LanceGeneratorFragment -> LanceGeneratorFragment.newInstance() to LANCE_GENERATOR_TAG
            is AlphaStrikeGeneratorFragment -> AlphaStrikeGeneratorFragment.newInstance() to ALPHA_STRIKE_TAG
            else -> throw IllegalArgumentException("Fragment $secondaryFragment not valid")
        }
    }

    override fun getRandomLocationText() {
        val witcherCombatFlowFragment: WitcherCombatFlowFragment =
            supportFragmentManager.findFragmentByTag(WITCHER_COMBAT_FLOW_TAG) as WitcherCombatFlowFragment
        if (witcherCombatFlowFragment.isVisible) {
            witcherCombatFlowFragment.setRandomLocation(
                presenter.theWitcher.getRandomLocationText(
                    applicationContext
                )
            )
        }
    }

    override fun getRandomIcons(quantity: Int, part: AdventurePart): List<Pair<Int, String>> =
        presenter.icons.getAdventureIcons(3)

    override fun getRandomEarlyLife(homeland: WitcherHomeland): List<String> =
        presenter.theWitcher.generateEarlyLife(applicationContext, homeland)

    override fun getRandomLifeEvents(age: Int): String =
        presenter.theWitcher.generateLifeEvents(applicationContext, age)

    override fun getRandomStyle(): String = presenter.theWitcher.generateStyle(applicationContext)
    override fun getRandomValues(): String = presenter.theWitcher.generateValues(applicationContext)
    override fun getRandomMechMovement(mechType: MechType, aggresivityValue: Int): String =
        presenter.battletechAI.generateMechMovement(applicationContext, mechType, aggresivityValue)

    override fun getRandomMechAttack(aggresivityValue: Int): String =
        presenter.battletechAI.generateMechAttack(applicationContext, aggresivityValue)

    override fun getRandomAlphaStrikeIACard(mechRole: AlphaStrikeMechType): MechIACard =
        presenter.alphaStrikeIA.generateCard(applicationContext, mechRole)

    override fun getRandomFate(odds: FateOdds, chaosValue: Int): String =
        presenter.mythic.generateFate(applicationContext, odds, chaosValue)

    override fun getRandomEvent(): String = presenter.mythic.generateEvent(applicationContext)
    override fun getRandomSceneChanges(chaosValue: Int): String =
        presenter.mythic.generateSceneChanges(applicationContext, chaosValue)

    override fun getMechListAndBV(
        totalBV: Int,
        tolerance: Int,
        minMechs: Int,
        maxMechs: Int
    ): String = presenter.battletechLance.generateMechList(
        applicationContext,
        totalBV,
        tolerance,
        minMechs,
        maxMechs
    )

    override fun getMechLances(
        totalBV: Int,
        tolerance: Int,
        minMechs: Int,
        maxMechs: Int
    ): String = presenter.battletechLance.getMechLances(
        applicationContext,
        totalBV,
        tolerance,
        minMechs,
        maxMechs
    )

    override fun getASMechListAndPoints(
        totalPoints: Int,
        tolerance: Int,
        minMechs: Int,
        maxMechs: Int
    ): String = presenter.battletechAlphaStrike.generateMechList(
        applicationContext,
        totalPoints,
        tolerance,
        minMechs,
        maxMechs
    )

    override fun getASMechLances(
        totalPoints: Int,
        tolerance: Int,
        minMechs: Int,
        maxMechs: Int
    ): String = presenter.battletechAlphaStrike.getMechLances(
        applicationContext,
        totalPoints,
        tolerance,
        minMechs,
        maxMechs
    )

    override fun generateMarvelEvent(view: View) = presenter.marvel.generateMarvelEvent(view)
    override fun generateMarvelGame(view: View) = presenter.marvel.generateMarvelGame(view)
}

