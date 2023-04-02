package com.zinc.gmcompanion.view.secondaryFragments

import android.content.Context
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.model.WitcherHomeland
import com.zinc.gmcompanion.view.OnFragmentInteractionListener
import kotlinx.android.synthetic.main.witcher_life_fragment.*
import kotlinx.android.synthetic.main.witcher_life_fragment.view.*

class WitcherLifeEventsFragment : Fragment(), ISecondaryFragment, View.OnClickListener {

    private lateinit var mListener: OnFragmentInteractionListener

    companion object {
        fun newInstance() = WitcherLifeEventsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.witcher_life_fragment, container, false)
        view?.north?.setOnClickListener(this)
        view?.nilfgaard?.setOnClickListener(this)
        view?.elf?.setOnClickListener(this)
        view?.dwarf?.setOnClickListener(this)
        view?.age_button?.setOnClickListener(this)
        view?.roll_style?.setOnClickListener(this)
        view?.roll_values?.setOnClickListener(this)
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

    override fun setRandomLocation(randomLocationText: String) {
        throw IllegalStateException("setRandomLocation called in WitcherLifeEvents")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            north.id -> setEarlyLife(mListener.getRandomEarlyLife(WitcherHomeland.NORTHERN_KINGDOMS))
            nilfgaard.id -> setEarlyLife(mListener.getRandomEarlyLife(WitcherHomeland.NILFGAARD))
            elf.id -> setEarlyLife(mListener.getRandomEarlyLife(WitcherHomeland.ELF))
            dwarf.id -> setEarlyLife(mListener.getRandomEarlyLife(WitcherHomeland.DWARF))
            age_button.id -> setLifeEvents(mListener.getRandomLifeEvents(age_seekbar.progress))
            roll_style.id -> setStyle(mListener.getRandomStyle())
            roll_values.id -> setValues(mListener.getRandomValues())
        }
    }

    private fun setValues(randomValues: String) {
        values.text = Html.fromHtml(randomValues)
    }

    private fun setStyle(randomStyle: String) {
        style.text = Html.fromHtml(randomStyle)
    }

    private fun setLifeEvents(randomLifeEvents: String) {
        life_events.text = Html.fromHtml(randomLifeEvents)
    }

    private fun setEarlyLife(randomEarlyLife: List<String>) {
        val builder = StringBuilder()
        builder.append(getString(R.string.early_life))
        for (text in randomEarlyLife) {
            builder.append(text)
            builder.append("<br>")
        }
        val text = builder.toString()
        early_life.text = Html.fromHtml(text)
        life_events.text = ""
        age_seekbar.visibility = VISIBLE
        age_layout.visibility = VISIBLE
        insert_age.visibility = VISIBLE
        age_seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                age_textview.text = Html.fromHtml(getString(R.string.age, progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //Don't do anything
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //Don't do anything
            }
        })
    }
}