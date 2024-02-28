package com.zinc.gmcompanion.view.secondaryFragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.view.OnFragmentInteractionListener
import kotlinx.android.synthetic.main.lance_generator_fragment.*
import kotlinx.android.synthetic.main.lance_generator_fragment.view.*

class AlphaStrikeGeneratorFragment : Fragment(), ISecondaryFragment, View.OnClickListener {

    private lateinit var mListener: OnFragmentInteractionListener

    companion object {
        fun newInstance() = AlphaStrikeGeneratorFragment()
    }

    private fun configureToleranceSelector(
        btnLess: Button?,
        btnMore: Button?,
        toleranceEditText: EditText?
    ) {
        btnMore?.setOnClickListener {
            val toleranceValue = toleranceEditText?.text.toString().toInt()
            if (toleranceValue < 200) toleranceEditText?.setText(
                Integer.valueOf(
                    toleranceValue + 1
                ).toString()
            )
        }
        btnLess?.setOnClickListener {
            val toleranceValue = toleranceEditText?.text.toString().toInt()
            if (toleranceValue > 0) toleranceEditText?.setText(
                Integer.valueOf(
                    toleranceValue - 1
                ).toString()
            )
        }
    }

    private fun configureMinSelector(
        btnLess: Button?,
        btnMore: Button?,
        minEditText: EditText?
    ) {
        btnMore?.setOnClickListener {
            val minValue = minEditText?.text.toString().toInt()
            if (minValue < 4) minEditText?.setText(
                Integer.valueOf(
                    minValue + 1
                ).toString()
            )
        }
        btnLess?.setOnClickListener {
            val minValue = minEditText?.text.toString().toInt()
            if (minValue > 1) minEditText?.setText(
                Integer.valueOf(
                    minValue - 1
                ).toString()
            )
        }
    }

    private fun configureMaxSelector(
        btnLess: Button?,
        btnMore: Button?,
        maxEditText: EditText?
    ) {
        btnMore?.setOnClickListener {
            val maxValue = maxEditText?.text.toString().toInt()
            if (maxValue < 4) maxEditText?.setText(
                Integer.valueOf(
                    maxValue + 1
                ).toString()
            )
        }
        btnLess?.setOnClickListener {
            val maxValue = maxEditText?.text.toString().toInt()
            if (maxValue > 1) maxEditText?.setText(
                Integer.valueOf(
                    maxValue - 1
                ).toString()
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.alpha_strike_generator_fragment, container, false)

        view?.create_mech_list?.setOnClickListener {
            if (points_value.text.toString().toInt() < 1 ||
                min_value.text.toString().toInt() > max_value.text.toString().toInt()
            ) {
                Toast.makeText(context, "Wrong parameters", Toast.LENGTH_SHORT).show()
            } else {
                val listAndBV = mListener.getASMechListAndPoints(
                    points_value.text.toString().toInt(),
                    tolerance_value.text.toString().toInt(),
                    min_value.text.toString().toInt(),
                    max_value.text.toString().toInt()
                )
                Log.d("patata", "Mech list ${listAndBV.length}")
                view.mech_list?.text = if (listAndBV.length > 80000) {
                    "Lista demasiado compleja para procesarla (${listAndBV.length}), reduce las probabilidades"
                } else {
                    HtmlCompat.fromHtml(listAndBV, HtmlCompat.FROM_HTML_MODE_LEGACY)
                }
                view.clear_mech_list?.visibility = VISIBLE
                view.mech_list?.visibility = VISIBLE
                Log.d("patata", "Mech list FINISH")
            }
        }

        view?.create_mech_lances?.setOnClickListener {
            if (points_value.text.toString().toInt() < 1 ||
                min_value.text.toString().toInt() > max_value.text.toString().toInt()
            ) {
                Toast.makeText(context, "Wrong parameters", Toast.LENGTH_SHORT).show()
            } else {
                val mechLances = mListener.getASMechLances(
                    points_value.text.toString().toInt(),
                    tolerance_value.text.toString().toInt(),
                    min_value.text.toString().toInt(),
                    max_value.text.toString().toInt()
                )
                Log.d("patata", "Lances list ${mechLances.length}")
                view.mech_list?.text = if (mechLances.length > 100000) {
                    "Lista demasiado compleja para procesarla (${mechLances.length}), reduce las probabilidades"
                } else {
                    HtmlCompat.fromHtml(mechLances, HtmlCompat.FROM_HTML_MODE_LEGACY)
                }
                view.clear_mech_list?.visibility = VISIBLE
                view.mech_list?.visibility = VISIBLE
                Log.d("patata", "Lances list FINISH")
            }
        }

        view?.clear_mech_list?.setOnClickListener {
            view.clear_mech_list?.visibility = GONE
            view.mech_list?.visibility = GONE
        }

        configureToleranceSelector(
            view?.tolerance_less,
            view?.tolerance_more,
            view?.tolerance_value
        )
        configureMinSelector(view?.min_less, view?.min_more, view?.min_value)
        configureMaxSelector(view?.max_less, view?.max_more, view?.max_value)
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
        throw IllegalStateException("setRandomLocation called in AdventureGenerator")
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}