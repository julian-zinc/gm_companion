package com.zinc.gmcompanion.view.secondaryFragments

import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.model.MechType.*
import com.zinc.gmcompanion.view.OnFragmentInteractionListener
import com.zinc.gmcompanion.databinding.BattleetchClassicIaFragmentBinding

class BattletechIAFragment : Fragment(), ISecondaryFragment, View.OnClickListener {

    private var _binding: BattleetchClassicIaFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var mListener: OnFragmentInteractionListener

    companion object {
        fun newInstance() = BattletechIAFragment()
    }

    private fun configureAggressivitySelector() {
        binding.btnMore.setOnClickListener {
            val aggressivityValue = binding.aggressivityValue.text.toString().toInt()
            if (aggressivityValue < 9) binding.aggressivityValue.setText((aggressivityValue + 1).toString())
        }
        binding.btnLess.setOnClickListener {
            val aggressivityValue = binding.aggressivityValue.text.toString().toInt()
            if (aggressivityValue > 1) binding.aggressivityValue.setText((aggressivityValue - 1).toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BattleetchClassicIaFragmentBinding.inflate(inflater, container, false)

        binding.brawler.setOnClickListener(this)
        binding.skirmisher.setOnClickListener(this)
        binding.flanker.setOnClickListener(this)
        binding.smasher.setOnClickListener(this)
        binding.striker.setOnClickListener(this)
        binding.cavalry.setOnClickListener(this)
        binding.artillery.setOnClickListener(this)
        binding.support.setOnClickListener(this)
        binding.sniper.setOnClickListener(this)

        binding.attack.setOnClickListener {
            binding.mechAttack.text = Html.fromHtml(
                mListener.getRandomMechAttack(
                    binding.aggressivityValue.text.toString().toInt()
                )
            )
            binding.clearAttack.visibility = VISIBLE
            binding.mechAttack.visibility = VISIBLE
        }

        binding.clearMovement.setOnClickListener {
            binding.clearMovement.visibility = GONE
            binding.mechMovement.visibility = GONE
        }

        binding.clearAttack.setOnClickListener {
            binding.clearAttack.visibility = GONE
            binding.mechAttack.visibility = GONE
        }

        configureAggressivitySelector()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.brawler.id -> binding.mechMovement.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    BRAWLER,
                    binding.aggressivityValue.text.toString().toInt()
                )
            )
            binding.skirmisher.id -> binding.mechMovement.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    SKIRMISHER,
                    binding.aggressivityValue.text.toString().toInt()
                )
            )
            binding.flanker.id -> binding.mechMovement.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    FLANKER,
                    binding.aggressivityValue.text.toString().toInt()
                )
            )
            binding.smasher.id -> binding.mechMovement.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    SMASHER,
                    binding.aggressivityValue.text.toString().toInt()
                )
            )
            binding.striker.id -> binding.mechMovement.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    STRIKER,
                    binding.aggressivityValue.text.toString().toInt()
                )
            )
            binding.cavalry.id -> binding.mechMovement.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    CAVALRY,
                    binding.aggressivityValue.text.toString().toInt()
                )
            )
            binding.artillery.id -> binding.mechMovement.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    ARTILLERY,
                    binding.aggressivityValue.text.toString().toInt()
                )
            )
            binding.support.id -> binding.mechMovement.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    SUPPORT,
                    binding.aggressivityValue.text.toString().toInt()
                )
            )
            binding.sniper.id -> binding.mechMovement.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    SNIPER,
                    binding.aggressivityValue.text.toString().toInt()
                )
            )
        }
        binding.mechMovement.visibility = VISIBLE
        binding.clearMovement.visibility = VISIBLE
    }

    override fun setRandomLocation(randomLocationText: String) {
        throw IllegalStateException("setRandomLocation called in AdventureGenerator")
    }
}