package com.zinc.gmcompanion.view.secondaryFragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.model.AlphaStrikeMechType
import com.zinc.gmcompanion.model.BattletechAlphaStrike
import com.zinc.gmcompanion.model.MechIA
import com.zinc.gmcompanion.view.OnFragmentInteractionListener
import kotlinx.android.synthetic.main.alpha_strike_ia_fragment.*
import kotlinx.android.synthetic.main.alpha_strike_ia_fragment.view.*

class AlphaStrikeIAFragment : Fragment(), ISecondaryFragment, View.OnClickListener {

    private lateinit var mListener: OnFragmentInteractionListener
    val addedMechList: MutableList<MechIA> = arrayListOf()

    companion object {
        fun newInstance() = AlphaStrikeIAFragment()
    }

    private fun configureNewMechSelector(
        mechSpinner: Spinner?,
        roleSpinner: Spinner?,
        btnAdd: Button?
    ) {
        val mechArrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            BattletechAlphaStrike.getMechModelList()
        )
        mechArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mechSpinner?.adapter = mechArrayAdapter


        val roleArrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            AlphaStrikeMechType.values()
        )
        roleArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        roleSpinner?.adapter = roleArrayAdapter

        btnAdd?.setOnClickListener {
            addMech(
                AlphaStrikeMechType.valueOf(roleSpinner?.selectedItem.toString()),
                mechSpinner?.selectedItem.toString()
            )
        }
    }

    private fun addMech(role: AlphaStrikeMechType, mech: String) {
        for (addedMech in addedMechList.toList()) {
            if (addedMech.mech == mech) {
                Toast.makeText(context, "Mech already added", Toast.LENGTH_SHORT).show()
                return
            }
        }
        addedMechList.add(MechIA(mech, role))
        when (addedMechList.count()) {
            1 -> addFirstMech(mech, role)
            2 -> addSecondMech(mech, role)
            3 -> addThirdMech(mech, role)
            4 -> addFourthMech(mech, role)
        }

        if (addedMechList.count() >= 4) new_mech_group.visibility = GONE
    }

    private fun addFirstMech(mech: String, role: AlphaStrikeMechType) {
        mech1.text = mech
        mech1_role.text = role.toString()
        mech1_buttons.visibility = VISIBLE

        mech1_init_value.text = ""
        mech1_init.visibility = VISIBLE

        mech1_move_value.text = ""
        mech1_move_layout.visibility = VISIBLE
        mech1_move_btn.setOnClickListener { mech1_move_value.visibility = VISIBLE }

        mech1_fire_value.text = ""
        mech1_fire_layout.visibility = VISIBLE
        mech1_fire_btn.setOnClickListener { mech1_fire_value.visibility = VISIBLE }

//        mech1_remove_btn.visibility = VISIBLE
//        mech1_remove_btn.setOnClickListener {
//            addedMechList.removeAt(0)
//            mech1_buttons.visibility = GONE
//            mech1_init.visibility = GONE
//            mech1_move_layout.visibility = GONE
//            mech1_fire_layout.visibility = GONE
//            mech1_remove_btn.visibility = GONE
//        }
    }

    private fun addSecondMech(mech: String, role: AlphaStrikeMechType) {
        mech1and2_divisor.visibility = VISIBLE

        mech2.text = mech
        mech2_role.text = role.toString()
        mech2_buttons.visibility = VISIBLE

        mech2_init_value.text = ""
        mech2_init.visibility = VISIBLE

        mech2_move_value.text = ""
        mech2_move_layout.visibility = VISIBLE
        mech2_move_btn.setOnClickListener { mech2_move_value.visibility = VISIBLE }

        mech2_fire_value.text = ""
        mech2_fire_layout.visibility = VISIBLE
        mech2_fire_btn.setOnClickListener { mech2_fire_value.visibility = VISIBLE }

//        mech2_remove_btn.visibility = VISIBLE
//        mech2_remove_btn.setOnClickListener {
//            addedMechList.removeAt(0)
//            mech2_buttons.visibility = GONE
//            mech2_init.visibility = GONE
//            mech2_move_layout.visibility = GONE
//            mech2_fire_layout.visibility = GONE
//            mech2_remove_btn.visibility = GONE
//        }
    }

    private fun addThirdMech(mech: String, role: AlphaStrikeMechType) {
        mech2and3_divisor.visibility = VISIBLE
        mech3.text = mech
        mech3_role.text = role.toString()
        mech3_buttons.visibility = VISIBLE

        mech3_init_value.text = ""
        mech3_init.visibility = VISIBLE

        mech3_move_value.text = ""
        mech3_move_layout.visibility = VISIBLE
        mech3_move_btn.setOnClickListener { mech3_move_value.visibility = VISIBLE }

        mech3_fire_value.text = ""
        mech3_fire_layout.visibility = VISIBLE
        mech3_fire_btn.setOnClickListener { mech3_fire_value.visibility = VISIBLE }

//        mech3_remove_btn.visibility = VISIBLE
//        mech3_remove_btn.setOnClickListener {
//            addedMechList.removeAt(0)
//            mech3_buttons.visibility = GONE
//            mech3_init.visibility = GONE
//            mech3_move_layout.visibility = GONE
//            mech3_fire_layout.visibility = GONE
//            mech3_remove_btn.visibility = GONE
//        }
    }

    private fun addFourthMech(mech: String, role: AlphaStrikeMechType) {
        mech3and4_divisor.visibility = VISIBLE

        mech4.text = mech
        mech4_role.text = role.toString()
        mech4_buttons.visibility = VISIBLE

        mech4_init_value.text = ""
        mech4_init.visibility = VISIBLE

        mech4_move_value.text = ""
        mech4_move_layout.visibility = VISIBLE
        mech4_move_btn.setOnClickListener { mech4_move_value.visibility = VISIBLE }

        mech4_fire_value.text = ""
        mech4_fire_layout.visibility = VISIBLE
        mech4_fire_btn.setOnClickListener { mech4_fire_value.visibility = VISIBLE }

//        mech4_remove_btn.visibility = VISIBLE
//        mech4_remove_btn.setOnClickListener {
//            addedMechList.removeAt(0)
//            mech4_buttons.visibility = GONE
//            mech4_init.visibility = GONE
//            mech4_move_layout.visibility = GONE
//            mech4_fire_layout.visibility = GONE
//            mech4_remove_btn.visibility = GONE
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.alpha_strike_ia_fragment, container, false)
        configureNewMechSelector(view?.mech_spinner, view?.role_spinner, view?.btn_add)

        view?.new_turn_btn?.setOnClickListener {
            newTurn()
        }
        return view
    }

    private fun newTurn() {
        for (addedMech in addedMechList) {
            when (addedMechList.indexOf(addedMech)) {
                0 -> newTurnFirstMech()
                1 -> newTurnSecondMech()
                2 -> newTurnThirdMech()
                3 -> newTurnFourthMech()
            }
        }
    }

    private fun newTurnFirstMech() {
        val card = mListener.getRandomAlphaStrikeIACard(addedMechList[0].role)
        mech1_init_value.text = card.initiative

        mech1_move_value.text = HtmlCompat.fromHtml(card.movement, HtmlCompat.FROM_HTML_MODE_LEGACY)

        mech1_move_value.visibility = GONE

        mech1_fire_value.text = HtmlCompat.fromHtml(card.combat, HtmlCompat.FROM_HTML_MODE_LEGACY)
        mech1_fire_value.visibility = GONE
    }

    private fun newTurnSecondMech() {
        val card = mListener.getRandomAlphaStrikeIACard(addedMechList[1].role)
        mech2_init_value.text = card.initiative

        mech2_move_value.text = HtmlCompat.fromHtml(card.movement, HtmlCompat.FROM_HTML_MODE_LEGACY)

        mech2_move_value.visibility = GONE

        mech2_fire_value.text = HtmlCompat.fromHtml(card.combat, HtmlCompat.FROM_HTML_MODE_LEGACY)
        mech2_fire_value.visibility = GONE
    }

    private fun newTurnThirdMech() {
        val card = mListener.getRandomAlphaStrikeIACard(addedMechList[2].role)
        mech3_init_value.text = card.initiative

        mech3_move_value.text = HtmlCompat.fromHtml(card.movement, HtmlCompat.FROM_HTML_MODE_LEGACY)

        mech3_move_value.visibility = GONE

        mech3_fire_value.text = HtmlCompat.fromHtml(card.combat, HtmlCompat.FROM_HTML_MODE_LEGACY)
        mech3_fire_value.visibility = GONE
    }

    private fun newTurnFourthMech() {
        val card = mListener.getRandomAlphaStrikeIACard(addedMechList[3].role)
        mech4_init_value.text = card.initiative

        mech4_move_value.text = HtmlCompat.fromHtml(card.movement, HtmlCompat.FROM_HTML_MODE_LEGACY)

        mech4_move_value.visibility = GONE

        mech4_fire_value.text = HtmlCompat.fromHtml(card.combat, HtmlCompat.FROM_HTML_MODE_LEGACY)
        mech4_fire_value.visibility = GONE
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun setRandomLocation(randomLocationText: String) {
        throw IllegalStateException("setRandomLocation called in AdventureGenerator")
    }

    override fun onClick(v: View?) {
    }
}