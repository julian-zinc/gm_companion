package com.zinc.gmcompanion.view.secondaryFragments

import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.model.WitcherHomeland
import com.zinc.gmcompanion.view.OnFragmentInteractionListener
import com.zinc.gmcompanion.databinding.WitcherLifeFragmentBinding

class WitcherLifeEventsFragment : Fragment(), ISecondaryFragment, View.OnClickListener {

    private var _binding: WitcherLifeFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var mListener: OnFragmentInteractionListener

    companion object {
        fun newInstance() = WitcherLifeEventsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WitcherLifeFragmentBinding.inflate(inflater, container, false)
        binding.north.setOnClickListener(this)
        binding.nilfgaard.setOnClickListener(this)
        binding.elf.setOnClickListener(this)
        binding.dwarf.setOnClickListener(this)
        binding.ageButton.setOnClickListener(this)
        binding.rollStyle.setOnClickListener(this)
        binding.rollValues.setOnClickListener(this)
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
        throw IllegalStateException("setRandomLocation called in WitcherLifeEvents")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.north.id -> setEarlyLife(mListener.getRandomEarlyLife(WitcherHomeland.NORTHERN_KINGDOMS))
            binding.nilfgaard.id -> setEarlyLife(mListener.getRandomEarlyLife(WitcherHomeland.NILFGAARD))
            binding.elf.id -> setEarlyLife(mListener.getRandomEarlyLife(WitcherHomeland.ELF))
            binding.dwarf.id -> setEarlyLife(mListener.getRandomEarlyLife(WitcherHomeland.DWARF))
            binding.ageButton.id -> setLifeEvents(mListener.getRandomLifeEvents(binding.ageSeekbar.progress))
            binding.rollStyle.id -> setStyle(mListener.getRandomStyle())
            binding.rollValues.id -> setValues(mListener.getRandomValues())
        }
    }

    private fun setValues(randomValues: String) {
        binding.values.text = Html.fromHtml(randomValues)
    }

    private fun setStyle(randomStyle: String) {
        binding.style.text = Html.fromHtml(randomStyle)
    }

    private fun setLifeEvents(randomLifeEvents: String) {
        binding.lifeEvents.text = Html.fromHtml(randomLifeEvents)
    }

    private fun setEarlyLife(randomEarlyLife: List<String>) {
        val builder = StringBuilder()
        builder.append(getString(R.string.early_life))
        for (text in randomEarlyLife) {
            builder.append(text)
            builder.append("<br>")
        }
        val text = builder.toString()
        binding.earlyLife.text = Html.fromHtml(text)
        binding.lifeEvents.text = ""
        binding.ageSeekbar.visibility = VISIBLE
        binding.ageLayout.visibility = VISIBLE
        binding.insertAge.visibility = VISIBLE
        binding.ageSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.ageTextview.text = Html.fromHtml(getString(R.string.age, progress))
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