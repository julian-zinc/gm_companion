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
import kotlinx.android.synthetic.main.battleetch_classic_ia_fragment.*
import kotlinx.android.synthetic.main.battleetch_classic_ia_fragment.view.*

class BattletechIAFragment : Fragment(), ISecondaryFragment, View.OnClickListener {

    private lateinit var mListener: OnFragmentInteractionListener

    companion object {
        fun newInstance() = BattletechIAFragment()
    }

    private fun configureAggressivitySelector(
        btnLess: Button?,
        btnMore: Button?,
        aggressivityEditText: EditText?
    ) {
        btnMore?.setOnClickListener {
            val aggressivityValue = aggressivityEditText?.text.toString().toInt()
            if (aggressivityValue < 9) aggressivityEditText?.setText(
                Integer.valueOf(
                    aggressivityValue + 1
                ).toString()
            )
        }
        btnLess?.setOnClickListener {
            val aggressivityValue = aggressivityEditText?.text.toString().toInt()
            if (aggressivityValue > 1) aggressivityEditText?.setText(
                Integer.valueOf(
                    aggressivityValue - 1
                ).toString()
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.battleetch_classic_ia_fragment, container, false)

        view?.brawler?.setOnClickListener(this)
        view?.skirmisher?.setOnClickListener(this)
        view?.flanker?.setOnClickListener(this)
        view?.smasher?.setOnClickListener(this)
        view?.striker?.setOnClickListener(this)
        view?.cavalry?.setOnClickListener(this)
        view?.artillery?.setOnClickListener(this)
        view?.support?.setOnClickListener(this)
        view?.sniper?.setOnClickListener(this)

        view?.attack?.setOnClickListener {
            view.mech_attack?.text = Html.fromHtml(
                mListener.getRandomMechAttack(
                    aggressivity_value.text.toString().toInt()
                )
            )
            view.clear_attack?.visibility = VISIBLE
            view.mech_attack?.visibility = VISIBLE
        }

        view?.clear_movement?.setOnClickListener {
            view.clear_movement?.visibility = GONE
            view.mech_movement?.visibility = GONE
        }

        view?.clear_attack?.setOnClickListener {
            view.clear_attack?.visibility = GONE
            view.mech_attack?.visibility = GONE
        }

        configureAggressivitySelector(view?.btn_less, view?.btn_more, view?.aggressivity_value)
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
            brawler.id -> view?.mech_movement?.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    BRAWLER,
                    aggressivity_value.text.toString().toInt()
                )
            )
            skirmisher.id -> view?.mech_movement?.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    SKIRMISHER,
                    aggressivity_value.text.toString().toInt()
                )
            )
            flanker.id -> view?.mech_movement?.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    FLANKER,
                    aggressivity_value.text.toString().toInt()
                )
            )
            smasher.id -> view?.mech_movement?.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    SMASHER,
                    aggressivity_value.text.toString().toInt()
                )
            )
            striker.id -> view?.mech_movement?.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    STRIKER,
                    aggressivity_value.text.toString().toInt()
                )
            )
            cavalry.id -> view?.mech_movement?.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    CAVALRY,
                    aggressivity_value.text.toString().toInt()
                )
            )
            artillery.id -> view?.mech_movement?.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    ARTILLERY,
                    aggressivity_value.text.toString().toInt()
                )
            )
            support.id -> view?.mech_movement?.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    SUPPORT,
                    aggressivity_value.text.toString().toInt()
                )
            )
            sniper.id -> view?.mech_movement?.text = Html.fromHtml(
                mListener.getRandomMechMovement(
                    SNIPER,
                    aggressivity_value.text.toString().toInt()
                )
            )
        }
        view?.mech_movement?.visibility = VISIBLE
        view?.clear_movement?.visibility = VISIBLE
    }

    override fun setRandomLocation(randomLocationText: String) {
        throw IllegalStateException("setRandomLocation called in AdventureGenerator")
    }
}