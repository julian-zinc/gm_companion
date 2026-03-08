package com.zinc.gmcompanion.view.secondaryFragments

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.model.AdventurePart
import com.zinc.gmcompanion.model.AdventurePart.*
import com.zinc.gmcompanion.view.OnFragmentInteractionListener
import com.zinc.gmcompanion.databinding.AdventureGeneratorFragmentBinding
import kotlin.random.Random

class AdventureGeneratorFragment: Fragment(), ISecondaryFragment, View.OnClickListener {

    private var _binding: AdventureGeneratorFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var mListener: OnFragmentInteractionListener

    companion object {
        fun newInstance() = AdventureGeneratorFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AdventureGeneratorFragmentBinding.inflate(inflater, container, false)
        binding.rerollIntro.setOnClickListener(this)
        binding.rerollThinking.setOnClickListener(this)
        binding.rerollSurprise.setOnClickListener(this)
        binding.rerollConflict.setOnClickListener(this)
        binding.rerollEnding.setOnClickListener(this)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        generateAllRolls()
    }

    private fun generateAllRolls() {
        generateRolls(INTRO)
        generateRolls(THINKING)
        generateRolls(SURPRISE)
        generateRolls(CONFLICT)
        generateRolls(ENDING)
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
        when(v?.id) {
            binding.rerollIntro.id -> generateRolls(INTRO)
            binding.rerollThinking.id -> generateRolls(THINKING)
            binding.rerollSurprise.id -> generateRolls(SURPRISE)
            binding.rerollConflict.id -> generateRolls(CONFLICT)
            binding.rerollEnding.id -> generateRolls(ENDING)
        }
    }

    private fun generateRolls(part: AdventurePart) {
        val views = when (part) {
            INTRO -> listOf(binding.intro1, binding.intro2, binding.intro3)
            THINKING -> listOf(binding.thinking1, binding.thinking2, binding.thinking3)
            SURPRISE -> listOf(binding.surprise1, binding.surprise2, binding.surprise3)
            CONFLICT -> listOf(binding.conflict1, binding.conflict2, binding.conflict3)
            ENDING -> listOf(binding.ending1, binding.ending2, binding.ending3)
        }
        for (view in views) setSrcToViews(mListener.getRandomIcons(1, part)[0], view)
    }

    private fun setSrcToViews(image: Pair<Int, String>, view: LinearLayout?) {
        val img: ImageView = view?.get(0) as ImageView
        img.setImageResource(image.first)
        img.setColorFilter(Color.rgb(Random.nextInt(50, 256), Random.nextInt(50, 256), Random.nextInt(50, 256)), PorterDuff.Mode.DARKEN)
        val text: TextView = view[1] as TextView
        text.text = image.second
    }
}