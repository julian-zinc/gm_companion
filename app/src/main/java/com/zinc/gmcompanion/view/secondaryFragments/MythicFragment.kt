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
import com.zinc.gmcompanion.model.FateOdds.*
import com.zinc.gmcompanion.view.OnFragmentInteractionListener
import com.zinc.gmcompanion.databinding.MythicFragmentBinding

class MythicFragment : Fragment(), ISecondaryFragment, View.OnClickListener {

    private var _binding: MythicFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var mListener: OnFragmentInteractionListener

    companion object {
        fun newInstance() = MythicFragment()
    }

    private fun configureChaosSelector() {
        binding.btnMore.setOnClickListener {
            val chaosValue = binding.chaosValue.text.toString().toInt()
            if (chaosValue < 9) binding.chaosValue.setText((chaosValue + 1).toString())
        }
        binding.btnLess.setOnClickListener {
            val chaosValue = binding.chaosValue.text.toString().toInt()
            if (chaosValue > 1) binding.chaosValue.setText((chaosValue - 1).toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MythicFragmentBinding.inflate(inflater, container, false)

        binding.impossible.setOnClickListener(this)
        binding.noWay.setOnClickListener(this)
        binding.veryUnlikely.setOnClickListener(this)
        binding.unlikely.setOnClickListener(this)
        binding.fiftyFifty.setOnClickListener(this)
        binding.somewhatLikely.setOnClickListener(this)
        binding.likely.setOnClickListener(this)
        binding.veryLikely.setOnClickListener(this)
        binding.nearSureThing.setOnClickListener(this)
        binding.aSureThing.setOnClickListener(this)
        binding.hasToBe.setOnClickListener(this)

        binding.clearFate.setOnClickListener {
            binding.clearFate.visibility = GONE
            binding.fateResult.visibility = GONE
        }


        binding.randomEvent.setOnClickListener {
            binding.event.text = Html.fromHtml(
                mListener.getRandomEvent()
            )
            binding.clearEvent.visibility = VISIBLE
            binding.event.visibility = VISIBLE
        }

        binding.clearEvent.setOnClickListener {
            binding.clearEvent.visibility = GONE
            binding.event.visibility = GONE
        }

        binding.newScene.setOnClickListener {
            binding.sceneChanges.text = Html.fromHtml(
                mListener.getRandomSceneChanges(binding.chaosValue.text.toString().toInt())
            )
            binding.clearSceneChanges.visibility = VISIBLE
            binding.sceneChanges.visibility = VISIBLE
        }

        binding.clearSceneChanges.setOnClickListener {
            binding.clearSceneChanges.visibility = GONE
            binding.sceneChanges.visibility = GONE
        }

        configureChaosSelector()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.impossible.id -> binding.fateResult.text = Html.fromHtml(mListener.getRandomFate(IMPOSSIBLE, binding.chaosValue.text.toString().toInt()))
            binding.noWay.id -> binding.fateResult.text = Html.fromHtml(mListener.getRandomFate(NO_WAY, binding.chaosValue.text.toString().toInt()))
            binding.veryUnlikely.id -> binding.fateResult.text = Html.fromHtml(mListener.getRandomFate(VERY_UNLIKELY, binding.chaosValue.text.toString().toInt()))
            binding.unlikely.id -> binding.fateResult.text = Html.fromHtml(mListener.getRandomFate(UNLIKELY, binding.chaosValue.text.toString().toInt()))
            binding.fiftyFifty.id -> binding.fateResult.text = Html.fromHtml(mListener.getRandomFate(FIFTY_FIFTY, binding.chaosValue.text.toString().toInt()))
            binding.somewhatLikely.id -> binding.fateResult.text = Html.fromHtml(mListener.getRandomFate(SOMEWHAT_LIKELY, binding.chaosValue.text.toString().toInt()))
            binding.likely.id -> binding.fateResult.text = Html.fromHtml(mListener.getRandomFate(LIKELY, binding.chaosValue.text.toString().toInt()))
            binding.veryLikely.id -> binding.fateResult.text = Html.fromHtml(mListener.getRandomFate(VERY_LIKELY, binding.chaosValue.text.toString().toInt()))
            binding.nearSureThing.id -> binding.fateResult.text = Html.fromHtml(mListener.getRandomFate(NEAR_SURE_THING, binding.chaosValue.text.toString().toInt()))
            binding.aSureThing.id -> binding.fateResult.text = Html.fromHtml(mListener.getRandomFate(A_SURE_THING, binding.chaosValue.text.toString().toInt()))
            binding.hasToBe.id -> binding.fateResult.text = Html.fromHtml(mListener.getRandomFate(HAS_TO_BE, binding.chaosValue.text.toString().toInt()))
        }
        binding.fateResult.visibility = VISIBLE
        binding.clearFate.visibility = VISIBLE
    }

    override fun setRandomLocation(randomLocationText: String) {
        throw IllegalStateException("setRandomLocation called in AdventureGenerator")
    }
}