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
import com.zinc.gmcompanion.view.OnFragmentInteractionListener
import kotlinx.android.synthetic.main.mythic_fragment.*
import kotlinx.android.synthetic.main.mythic_fragment.view.*
import com.zinc.gmcompanion.model.FateOdds.*
import kotlinx.android.synthetic.main.battleetch_classic_ia_fragment.*
import kotlinx.android.synthetic.main.battleetch_classic_ia_fragment.view.*
import kotlinx.android.synthetic.main.mythic_fragment.view.btn_less
import kotlinx.android.synthetic.main.mythic_fragment.view.btn_more

class MythicFragment : Fragment(), ISecondaryFragment, View.OnClickListener {

    private lateinit var mListener: OnFragmentInteractionListener

    companion object {
        fun newInstance() = MythicFragment()
    }

    private fun configureChaosSelector(
        btnLess: Button?,
        btnMore: Button?,
        chaosEditText: EditText?
    ) {
        btnMore?.setOnClickListener {
            val chaosValue = chaosEditText?.text.toString().toInt()
            if (chaosValue < 9) chaosEditText?.setText(
                Integer.valueOf(
                    chaosValue + 1
                ).toString()
            )
        }
        btnLess?.setOnClickListener {
            val chaosValue = chaosEditText?.text.toString().toInt()
            if (chaosValue > 1) chaosEditText?.setText(
                Integer.valueOf(
                    chaosValue - 1
                ).toString()
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.mythic_fragment, container, false)

        view?.impossible?.setOnClickListener(this)
        view?.no_way?.setOnClickListener(this)
        view?.very_unlikely?.setOnClickListener(this)
        view?.unlikely?.setOnClickListener(this)
        view?.fifty_fifty?.setOnClickListener(this)
        view?.somewhat_likely?.setOnClickListener(this)
        view?.likely?.setOnClickListener(this)
        view?.very_likely?.setOnClickListener(this)
        view?.near_sure_thing?.setOnClickListener(this)
        view?.a_sure_thing?.setOnClickListener(this)
        view?.has_to_be?.setOnClickListener(this)

        view?.clear_fate?.setOnClickListener {
            view.clear_fate?.visibility = GONE
            view.fate_result?.visibility = GONE
        }


        view?.random_event?.setOnClickListener {
            view.event?.text = Html.fromHtml(
                mListener.getRandomEvent()
            )
            view.clear_event?.visibility = VISIBLE
            view.event?.visibility = VISIBLE
        }

        view?.clear_event?.setOnClickListener {
            view.clear_event?.visibility = GONE
            view.event?.visibility = GONE
        }

        view?.new_scene?.setOnClickListener {
            view.scene_changes?.text = Html.fromHtml(
                mListener.getRandomSceneChanges(chaos_value.text.toString().toInt())
            )
            view.clear_scene_changes?.visibility = VISIBLE
            view.scene_changes?.visibility = VISIBLE
        }

        view?.clear_scene_changes?.setOnClickListener {
            view.clear_scene_changes?.visibility = GONE
            view.scene_changes?.visibility = GONE
        }

        configureChaosSelector(view?.btn_less, view?.btn_more, view?.chaos_value)
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

    override fun onClick(v: View?) {
        when (v?.id) {
            impossible.id -> view?.fate_result?.text = Html.fromHtml(mListener.getRandomFate(IMPOSSIBLE, chaos_value.text.toString().toInt()))
            no_way.id -> view?.fate_result?.text = Html.fromHtml(mListener.getRandomFate(NO_WAY, chaos_value.text.toString().toInt()))
            very_unlikely.id -> view?.fate_result?.text = Html.fromHtml(mListener.getRandomFate(VERY_UNLIKELY, chaos_value.text.toString().toInt()))
            unlikely.id -> view?.fate_result?.text = Html.fromHtml(mListener.getRandomFate(UNLIKELY, chaos_value.text.toString().toInt()))
            fifty_fifty.id -> view?.fate_result?.text = Html.fromHtml(mListener.getRandomFate(FIFTY_FIFTY, chaos_value.text.toString().toInt()))
            somewhat_likely.id -> view?.fate_result?.text = Html.fromHtml(mListener.getRandomFate(SOMEWHAT_LIKELY, chaos_value.text.toString().toInt()))
            likely.id -> view?.fate_result?.text = Html.fromHtml(mListener.getRandomFate(LIKELY, chaos_value.text.toString().toInt()))
            very_likely.id -> view?.fate_result?.text = Html.fromHtml(mListener.getRandomFate(VERY_LIKELY, chaos_value.text.toString().toInt()))
            near_sure_thing.id -> view?.fate_result?.text = Html.fromHtml(mListener.getRandomFate(NEAR_SURE_THING, chaos_value.text.toString().toInt()))
            a_sure_thing.id -> view?.fate_result?.text = Html.fromHtml(mListener.getRandomFate(A_SURE_THING, chaos_value.text.toString().toInt()))
            has_to_be.id -> view?.fate_result?.text = Html.fromHtml(mListener.getRandomFate(HAS_TO_BE, chaos_value.text.toString().toInt()))
        }
        view?.fate_result?.visibility = VISIBLE
        view?.clear_fate?.visibility = VISIBLE
    }

    override fun setRandomLocation(randomLocationText: String) {
        throw IllegalStateException("setRandomLocation called in AdventureGenerator")
    }
}