package com.zinc.gmcompanion.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.databinding.MainFragmentBinding
import com.zinc.gmcompanion.view.secondaryFragments.*

class MainFragment : Fragment(), View.OnClickListener {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var mListener: OnFragmentInteractionListener

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.itemWitcherCombatFlow.id -> mListener.setFragment(WitcherCombatFlowFragment())
            binding.itemWitcherLifeEvents.id -> mListener.setFragment(WitcherLifeEventsFragment())
            binding.itemMarvelUnited.id -> mListener.setFragment(MarvelUnitedFragment())
            binding.itemAdventureGenerator.id -> mListener.setFragment(AdventureGeneratorFragment())
            binding.itemBattletechIa.id -> mListener.setFragment(BattletechIAFragment())
            binding.itemAlphaStrikeIa.id -> mListener.setFragment(AlphaStrikeIAFragment())
//            item_battletech_kaiju.id -> mListener.setFragment(BattletechKaijuIAFragment())
            binding.itemMythic.id -> mListener.setFragment(MythicFragment())
            binding.itemAlphaStrikeGenerator.id -> mListener.setFragment(AlphaStrikeGeneratorFragment())
            binding.itemLanceGenerator.id -> mListener.setFragment(LanceGeneratorFragment())
            binding.item3.id, binding.itemBattletechKaiju.id -> Toast.makeText(
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
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.itemWitcherCombatFlow.setOnClickListener(this)
        binding.itemWitcherLifeEvents.setOnClickListener(this)
        binding.itemMarvelUnited.setOnClickListener(this)
        binding.itemAdventureGenerator.setOnClickListener(this)
        binding.itemBattletechIa.setOnClickListener(this)
        binding.itemAlphaStrikeIa.setOnClickListener(this)
        binding.itemLanceGenerator.setOnClickListener(this)
        binding.itemAlphaStrikeGenerator.setOnClickListener(this)
        binding.itemBattletechKaiju.setOnClickListener(this)
        binding.itemMythic.setOnClickListener(this)
        binding.item3.setOnClickListener(this)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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