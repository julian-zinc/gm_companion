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
import com.zinc.gmcompanion.databinding.AlphaStrikeIaFragmentBinding

class AlphaStrikeIAFragment : Fragment(), ISecondaryFragment, View.OnClickListener {

    private var _binding: AlphaStrikeIaFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var mListener: OnFragmentInteractionListener
    val addedMechList: MutableList<MechIA> = arrayListOf()

    companion object {
        fun newInstance() = AlphaStrikeIAFragment()
    }

    private fun configureNewMechSelector() {
        val mechArrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            BattletechAlphaStrike.getMechModelList()
        )
        mechArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.mechSpinner.adapter = mechArrayAdapter


        val roleArrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            AlphaStrikeMechType.values()
        )
        roleArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.roleSpinner.adapter = roleArrayAdapter

        binding.btnAdd.setOnClickListener {
            addMech(
                AlphaStrikeMechType.valueOf(binding.roleSpinner.selectedItem.toString()),
                binding.mechSpinner.selectedItem.toString()
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

        if (addedMechList.count() >= 4) binding.newMechGroup.visibility = GONE
    }

    private fun addFirstMech(mech: String, role: AlphaStrikeMechType) {
        binding.mech1.text = mech
        binding.mech1Role.text = role.toString()
        binding.mech1Buttons.visibility = VISIBLE

        binding.mech1InitValue.text = ""
        binding.mech1Init.visibility = VISIBLE

        binding.mech1MoveValue.text = ""
        binding.mech1MoveLayout.visibility = VISIBLE
        binding.mech1MoveBtn.setOnClickListener { binding.mech1MoveValue.visibility = VISIBLE }

        binding.mech1FireValue.text = ""
        binding.mech1FireLayout.visibility = VISIBLE
        binding.mech1FireBtn.setOnClickListener { binding.mech1FireValue.visibility = VISIBLE }
    }

    private fun addSecondMech(mech: String, role: AlphaStrikeMechType) {
        binding.mech1and2Divisor.visibility = VISIBLE

        binding.mech2.text = mech
        binding.mech2Role.text = role.toString()
        binding.mech2Buttons.visibility = VISIBLE

        binding.mech2InitValue.text = ""
        binding.mech2Init.visibility = VISIBLE

        binding.mech2MoveValue.text = ""
        binding.mech2MoveLayout.visibility = VISIBLE
        binding.mech2MoveBtn.setOnClickListener { binding.mech2MoveValue.visibility = VISIBLE }

        binding.mech2FireValue.text = ""
        binding.mech2FireLayout.visibility = VISIBLE
        binding.mech2FireBtn.setOnClickListener { binding.mech2FireValue.visibility = VISIBLE }
    }

    private fun addThirdMech(mech: String, role: AlphaStrikeMechType) {
        binding.mech2and3Divisor.visibility = VISIBLE
        binding.mech3.text = mech
        binding.mech3Role.text = role.toString()
        binding.mech3Buttons.visibility = VISIBLE

        binding.mech3InitValue.text = ""
        binding.mech3Init.visibility = VISIBLE

        binding.mech3MoveValue.text = ""
        binding.mech3MoveLayout.visibility = VISIBLE
        binding.mech3MoveBtn.setOnClickListener { binding.mech3MoveValue.visibility = VISIBLE }

        binding.mech3FireValue.text = ""
        binding.mech3FireLayout.visibility = VISIBLE
        binding.mech3FireBtn.setOnClickListener { binding.mech3FireValue.visibility = VISIBLE }
    }

    private fun addFourthMech(mech: String, role: AlphaStrikeMechType) {
        binding.mech3and4Divisor.visibility = VISIBLE

        binding.mech4.text = mech
        binding.mech4Role.text = role.toString()
        binding.mech4Buttons.visibility = VISIBLE

        binding.mech4InitValue.text = ""
        binding.mech4Init.visibility = VISIBLE

        binding.mech4MoveValue.text = ""
        binding.mech4MoveLayout.visibility = VISIBLE
        binding.mech4MoveBtn.setOnClickListener { binding.mech4MoveValue.visibility = VISIBLE }

        binding.mech4FireValue.text = ""
        binding.mech4FireLayout.visibility = VISIBLE
        binding.mech4FireBtn.setOnClickListener { binding.mech4FireValue.visibility = VISIBLE }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AlphaStrikeIaFragmentBinding.inflate(inflater, container, false)
        configureNewMechSelector()

        binding.newTurnBtn.setOnClickListener {
            newTurn()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
        binding.mech1InitValue.text = card.initiative

        binding.mech1MoveValue.text = HtmlCompat.fromHtml(card.movement, HtmlCompat.FROM_HTML_MODE_LEGACY)

        binding.mech1MoveValue.visibility = GONE

        binding.mech1FireValue.text = HtmlCompat.fromHtml(card.combat, HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding.mech1FireValue.visibility = GONE
    }

    private fun newTurnSecondMech() {
        val card = mListener.getRandomAlphaStrikeIACard(addedMechList[1].role)
        binding.mech2InitValue.text = card.initiative

        binding.mech2MoveValue.text = HtmlCompat.fromHtml(card.movement, HtmlCompat.FROM_HTML_MODE_LEGACY)

        binding.mech2MoveValue.visibility = GONE

        binding.mech2FireValue.text = HtmlCompat.fromHtml(card.combat, HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding.mech2FireValue.visibility = GONE
    }

    private fun newTurnThirdMech() {
        val card = mListener.getRandomAlphaStrikeIACard(addedMechList[2].role)
        binding.mech3InitValue.text = card.initiative

        binding.mech3MoveValue.text = HtmlCompat.fromHtml(card.movement, HtmlCompat.FROM_HTML_MODE_LEGACY)

        binding.mech3MoveValue.visibility = GONE

        binding.mech3FireValue.text = HtmlCompat.fromHtml(card.combat, HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding.mech3FireValue.visibility = GONE
    }

    private fun newTurnFourthMech() {
        val card = mListener.getRandomAlphaStrikeIACard(addedMechList[3].role)
        binding.mech4InitValue.text = card.initiative

        binding.mech4MoveValue.text = HtmlCompat.fromHtml(card.movement, HtmlCompat.FROM_HTML_MODE_LEGACY)

        binding.mech4MoveValue.visibility = GONE

        binding.mech4FireValue.text = HtmlCompat.fromHtml(card.combat, HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding.mech4FireValue.visibility = GONE
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