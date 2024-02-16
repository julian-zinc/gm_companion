package com.zinc.gmcompanion.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.view.secondaryFragments.*
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.main_fragment.view.*


class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var mListener: OnFragmentInteractionListener

    override fun onClick(v: View?) {
        when (v?.id) {
            item_witcher_combat_flow.id -> mListener.setFragment(WitcherCombatFlowFragment())
            item_witcher_life_events.id -> mListener.setFragment(WitcherLifeEventsFragment())
            item_adventure_generator.id -> mListener.setFragment(AdventureGeneratorFragment())
            item_battletech_classic.id -> mListener.setFragment(BattletechClassicIAFragment())
//            item_battletech_kaiju.id -> mListener.setFragment(BattletechKaijuIAFragment())
            item_mythic.id -> mListener.setFragment(MythicFragment())
            item_alpha_strike_generator.id -> mListener.setFragment(AlphaStrikeGeneratorFragment())
            item_lance_generator.id -> mListener.setFragment(LanceGeneratorFragment())
            item_2.id, item_3.id, item_battletech_kaiju.id -> Toast.makeText(
                context,
                getString(R.string.not_implemented),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        view.item_witcher_combat_flow.setOnClickListener(this)
        view.item_witcher_life_events.setOnClickListener(this)
        view.item_adventure_generator.setOnClickListener(this)
        view.item_battletech_classic.setOnClickListener(this)
        view.item_lance_generator.setOnClickListener(this)
        view.item_alpha_strike_generator.setOnClickListener(this)
        view.item_battletech_kaiju.setOnClickListener(this)
        view.item_mythic.setOnClickListener(this)
        view.item_2.setOnClickListener(this)
        view.item_3.setOnClickListener(this)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }
}