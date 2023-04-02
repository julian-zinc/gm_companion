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
import kotlinx.android.synthetic.main.adventure_generator_fragment.*
import kotlinx.android.synthetic.main.adventure_generator_fragment.view.*
import kotlin.random.Random

class AdventureGeneratorFragment: Fragment(), ISecondaryFragment, View.OnClickListener {

    private lateinit var mListener: OnFragmentInteractionListener

    companion object {
        fun newInstance() = AdventureGeneratorFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.adventure_generator_fragment, container, false)
        view?.reroll_intro?.setOnClickListener(this)
        view?.reroll_thinking?.setOnClickListener(this)
        view?.reroll_surprise?.setOnClickListener(this)
        view?.reroll_conflict?.setOnClickListener(this)
        view?.reroll_ending?.setOnClickListener(this)
        return view
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
            reroll_intro.id -> generateRolls(INTRO)
            reroll_thinking.id -> generateRolls(THINKING)
            reroll_surprise.id -> generateRolls(SURPRISE)
            reroll_conflict.id -> generateRolls(CONFLICT)
            reroll_ending.id -> generateRolls(ENDING)
        }
    }

    private fun generateRolls(part: AdventurePart) {
        val views = when (part) {
            INTRO -> listOf(intro_1, intro_2, intro_3)
            THINKING -> listOf(thinking_1, thinking_2, thinking_3)
            SURPRISE -> listOf(surprise_1, surprise_2, surprise_3)
            CONFLICT -> listOf(conflict_1, conflict_2, conflict_3)
            ENDING -> listOf(ending_1, ending_2, ending_3)
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