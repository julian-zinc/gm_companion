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
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.view.OnFragmentInteractionListener
import com.zinc.gmcompanion.databinding.LanceGeneratorFragmentBinding

class LanceGeneratorFragment : Fragment(), ISecondaryFragment, View.OnClickListener {

    private var _binding: LanceGeneratorFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var mListener: OnFragmentInteractionListener

    companion object {
        fun newInstance() = LanceGeneratorFragment()
    }

    private fun configureToleranceSelector() {
        binding.toleranceMore.setOnClickListener {
            val toleranceValue = binding.toleranceValue.text.toString().toInt()
            if (toleranceValue < 200) binding.toleranceValue.setText((toleranceValue + 5).toString())
        }
        binding.toleranceLess.setOnClickListener {
            val toleranceValue = binding.toleranceValue.text.toString().toInt()
            if (toleranceValue > 0) binding.toleranceValue.setText((toleranceValue - 5).toString())
        }
    }

    private fun configureMinSelector() {
        binding.minMore.setOnClickListener {
            val minValue = binding.minValue.text.toString().toInt()
            if (minValue < 4) binding.minValue.setText((minValue + 1).toString())
        }
        binding.minLess.setOnClickListener {
            val minValue = binding.minValue.text.toString().toInt()
            if (minValue > 1) binding.minValue.setText((minValue - 1).toString())
        }
    }

    private fun configureMaxSelector() {
        binding.maxMore.setOnClickListener {
            val maxValue = binding.maxValue.text.toString().toInt()
            if (maxValue < 4) binding.maxValue.setText((maxValue + 1).toString())
        }
        binding.maxLess.setOnClickListener {
            val maxValue = binding.maxValue.text.toString().toInt()
            if (maxValue > 1) binding.maxValue.setText((maxValue - 1).toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LanceGeneratorFragmentBinding.inflate(inflater, container, false)

        binding.createMechList.setOnClickListener {
            if (binding.pointsValue.text.toString().toInt() < 1 ||
                binding.minValue.text.toString().toInt() > binding.maxValue.text.toString().toInt()
            ) {
                Toast.makeText(context, "Wrong parameters", Toast.LENGTH_SHORT).show()
            } else {
                val listAndBV = mListener.getMechListAndBV(
                    binding.pointsValue.text.toString().toInt(),
                    binding.toleranceValue.text.toString().toInt(),
                    binding.minValue.text.toString().toInt(),
                    binding.maxValue.text.toString().toInt()
                )
                binding.mechList.text = Html.fromHtml(listAndBV)
                binding.clearMechList.visibility = VISIBLE
                binding.mechList.visibility = VISIBLE
            }
        }

        binding.createMechLances.setOnClickListener {
            if (binding.pointsValue.text.toString().toInt() < 1 ||
                binding.minValue.text.toString().toInt() > binding.maxValue.text.toString().toInt()
            ) {
                Toast.makeText(context, "Wrong parameters", Toast.LENGTH_SHORT).show()
            } else {
                val mechLances = mListener.getMechLances(
                    binding.pointsValue.text.toString().toInt(),
                    binding.toleranceValue.text.toString().toInt(),
                    binding.minValue.text.toString().toInt(),
                    binding.maxValue.text.toString().toInt()
                )
                binding.mechList.text = Html.fromHtml(mechLances)
                binding.clearMechList.visibility = VISIBLE
                binding.mechList.visibility = VISIBLE
            }
        }

        binding.clearMechList.setOnClickListener {
            binding.clearMechList.visibility = GONE
            binding.mechList.visibility = GONE
        }

        configureToleranceSelector()
        configureMinSelector()
        configureMaxSelector()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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