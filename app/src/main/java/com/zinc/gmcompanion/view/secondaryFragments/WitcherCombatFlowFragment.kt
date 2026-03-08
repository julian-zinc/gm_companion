package com.zinc.gmcompanion.view.secondaryFragments

import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.view.OnFragmentInteractionListener
import com.zinc.gmcompanion.databinding.WitcherCombatFlowFragmentBinding

class WitcherCombatFlowFragment: Fragment(), ISecondaryFragment, OnClickListener {

    private var _binding: WitcherCombatFlowFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var mListener: OnFragmentInteractionListener
    private var defenseOptionsShown = false
    private var attackOptionsShown = false
    private var randomLocationShown = false

    companion object {
        fun newInstance() = WitcherCombatFlowFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WitcherCombatFlowFragmentBinding.inflate(inflater, container, false)
        binding.rollLocation.setOnClickListener(this)

        binding.defenseOptions.setOnClickListener(this)
        binding.attackOptions.setOnClickListener(this)

        binding.fail.setOnClickListener(this)
        binding.hit.setOnClickListener(this)
        binding.crit7.setOnClickListener(this)
        binding.crit10.setOnClickListener(this)
        binding.crit13.setOnClickListener(this)
        binding.crit15.setOnClickListener(this)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        binding.randomLocation.text = ""
        randomLocationShown = false
        when (v?.id) {
            binding.defenseOptions.id -> {
                if (defenseOptionsShown) {
                    binding.defensesStr.visibility = GONE
                    binding.attacksStr.visibility = GONE
                } else {
                    binding.defensesStr.visibility = VISIBLE
                    binding.attacksStr.visibility = GONE
                }
                defenseOptionsShown = !defenseOptionsShown
                attackOptionsShown = false

            }
            binding.attackOptions.id -> {
                if (attackOptionsShown) {
                    binding.defensesStr.visibility = GONE
                    binding.attacksStr.visibility = GONE
                } else {
                    binding.defensesStr.visibility = GONE
                    binding.attacksStr.visibility = VISIBLE
                }
                attackOptionsShown = !attackOptionsShown
                defenseOptionsShown = false
            }
            binding.fail.id -> {
                binding.miss.visibility = VISIBLE
                binding.damage.visibility = GONE
                binding.criticalHit.visibility = GONE
                binding.rollLocation.visibility = GONE
            }
            binding.hit.id -> {
                binding.miss.visibility = GONE
                binding.damage.visibility = VISIBLE
                binding.criticalHit.visibility = GONE
                binding.rollLocation.visibility = VISIBLE
            }
            binding.crit7.id -> {
                binding.miss.visibility = GONE
                binding.damage.visibility = VISIBLE
                binding.criticalHit.visibility = VISIBLE
                binding.criticalHit.text = getString(R.string.critical, getString(R.string.simple), 3)
                binding.rollLocation.visibility = GONE
            }
            binding.crit10.id -> {
                binding.miss.visibility = GONE
                binding.damage.visibility = VISIBLE
                binding.criticalHit.visibility = VISIBLE
                binding.criticalHit.text = Html.fromHtml(getString(R.string.critical, getString(R.string.complex), 5))
                binding.rollLocation.visibility = GONE
            }
            binding.crit13.id -> {
                binding.miss.visibility = GONE
                binding.damage.visibility = VISIBLE
                binding.criticalHit.visibility = VISIBLE
                binding.criticalHit.text = getString(R.string.critical, getString(R.string.difficult), 8)
                binding.rollLocation.visibility = GONE
            }
            binding.crit15.id -> {
                binding.miss.visibility = GONE
                binding.damage.visibility = VISIBLE
                binding.criticalHit.visibility = VISIBLE
                binding.criticalHit.text = getString(R.string.critical, getString(R.string.deadly), 10)
                binding.rollLocation.visibility = GONE
            }
            binding.rollLocation.id -> {
                if (randomLocationShown) {
                    binding.randomLocation.visibility = GONE
                    binding.randomLocation.text = ""
                } else {
                    binding.randomLocation.visibility = VISIBLE
                    mListener.getRandomLocationText()
                }
                randomLocationShown = !randomLocationShown
            }
        }
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
        binding.randomLocation.text = randomLocationText
    }
}