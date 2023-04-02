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
import kotlinx.android.synthetic.main.witcher_combat_flow_fragment.*
import kotlinx.android.synthetic.main.witcher_combat_flow_fragment.view.*

class WitcherCombatFlowFragment: Fragment(), ISecondaryFragment, OnClickListener {

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
        val view = inflater.inflate(R.layout.witcher_combat_flow_fragment, container, false)
        view.roll_location.setOnClickListener(this)

        view.defense_options.setOnClickListener(this)
        view.attack_options.setOnClickListener(this)

        view.fail.setOnClickListener(this)
        view.hit.setOnClickListener(this)
        view.crit7.setOnClickListener(this)
        view.crit10.setOnClickListener(this)
        view.crit13.setOnClickListener(this)
        view.crit15.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        view?.random_location?.text = ""
        randomLocationShown = false
        when (v?.id) {
            defense_options.id -> {
                if (defenseOptionsShown) {
                    view?.defenses_str?.visibility = GONE
                    view?.attacks_str?.visibility = GONE
                } else {
                    view?.defenses_str?.visibility = VISIBLE
                    view?.attacks_str?.visibility = GONE
                }
                defenseOptionsShown = !defenseOptionsShown
                attackOptionsShown = false

            }
            attack_options.id -> {
                if (attackOptionsShown) {
                    view?.defenses_str?.visibility = GONE
                    view?.attacks_str?.visibility = GONE
                } else {
                    view?.defenses_str?.visibility = GONE
                    view?.attacks_str?.visibility = VISIBLE
                }
                attackOptionsShown = !attackOptionsShown
                defenseOptionsShown = false
            }
            fail.id -> {
                view?.miss?.visibility = VISIBLE
                view?.damage?.visibility = GONE
                view?.critical_hit?.visibility = GONE
                view?.roll_location?.visibility = GONE
            }
            hit.id -> {
                view?.miss?.visibility = GONE
                view?.damage?.visibility = VISIBLE
                view?.critical_hit?.visibility = GONE
                view?.roll_location?.visibility = VISIBLE
            }
            crit7.id -> {
                view?.miss?.visibility = GONE
                view?.damage?.visibility = VISIBLE
                view?.critical_hit?.visibility = VISIBLE
                view?.critical_hit?.text = getString(R.string.critical, getString(R.string.simple), 3)
                view?.roll_location?.visibility = GONE
            }
            crit10.id -> {
                view?.miss?.visibility = GONE
                view?.damage?.visibility = VISIBLE
                view?.critical_hit?.visibility = VISIBLE
                view?.critical_hit?.text = Html.fromHtml(getString(R.string.critical, getString(R.string.complex), 5))
                view?.roll_location?.visibility = GONE
            }
            crit13.id -> {
                view?.miss?.visibility = GONE
                view?.damage?.visibility = VISIBLE
                view?.critical_hit?.visibility = VISIBLE
                view?.critical_hit?.text = getString(R.string.critical, getString(R.string.difficult), 8)
                view?.roll_location?.visibility = GONE
            }
            crit15.id -> {
                view?.miss?.visibility = GONE
                view?.damage?.visibility = VISIBLE
                view?.critical_hit?.visibility = VISIBLE
                view?.critical_hit?.text = getString(R.string.critical, getString(R.string.deadly), 10)
                view?.roll_location?.visibility = GONE
            }
            roll_location.id -> {
                if (randomLocationShown) {
                    view?.random_location?.visibility = GONE
                    view?.random_location?.text = ""
                } else {
                    view?.random_location?.visibility = VISIBLE
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
        view?.random_location?.text = randomLocationText
    }
}