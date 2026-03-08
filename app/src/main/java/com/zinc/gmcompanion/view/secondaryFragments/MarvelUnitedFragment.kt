package com.zinc.gmcompanion.view.secondaryFragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.zinc.gmcompanion.R
import com.zinc.gmcompanion.view.OnFragmentInteractionListener
import com.zinc.gmcompanion.databinding.MarvelUnitedFragmentBinding

class MarvelUnitedFragment : Fragment(), ISecondaryFragment, View.OnClickListener {

    private var _binding: MarvelUnitedFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var mListener: OnFragmentInteractionListener

    companion object {
        fun newInstance() = MarvelUnitedFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MarvelUnitedFragmentBinding.inflate(inflater, container, false)

        binding.iaGenerateScene.setOnClickListener {
            mListener.generateMarvelEvent(binding, requireContext())
        }
        binding.generateGame.setOnClickListener {
            mListener.generateMarvelGame(binding, requireContext())
        }

        binding.clearScene.setOnClickListener {
            binding.clearScene.visibility = GONE
            binding.scene.visibility = GONE
        }

        configureNumberOfPlayers()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun configureNumberOfPlayers() {
        binding.btnMore.setOnClickListener {
            val playersValue = binding.playersValue.text.toString().toInt()
            if (playersValue < 4) binding.playersValue.setText((playersValue + 1).toString())
        }
        binding.btnLess.setOnClickListener {
            val playersValue = binding.playersValue.text.toString().toInt()
            if (playersValue > 1) binding.playersValue.setText((playersValue - 1).toString())
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

//    override fun onClick(v: View?) {
//        when (v?.id) {
//            impossible.id -> view?.fate_result?.text = Html.fromHtml(
//                mListener.getRandomFate(
//                    IMPOSSIBLE,
//                    chaos_value.text.toString().toInt()
//                )
//            )
//            no_way.id -> view?.fate_result?.text =
//                Html.fromHtml(mListener.getRandomFate(NO_WAY, chaos_value.text.toString().toInt()))
//            very_unlikely.id -> view?.fate_result?.text = Html.fromHtml(
//                mListener.getRandomFate(
//                    VERY_UNLIKELY,
//                    chaos_value.text.toString().toInt()
//                )
//            )
//            unlikely.id -> view?.fate_result?.text = Html.fromHtml(
//                mListener.getRandomFate(
//                    UNLIKELY,
//                    chaos_value.text.toString().toInt()
//                )
//            )
//            fifty_fifty.id -> view?.fate_result?.text = Html.fromHtml(
//                mListener.getRandomFate(
//                    FIFTY_FIFTY,
//                    chaos_value.text.toString().toInt()
//                )
//            )
//            somewhat_likely.id -> view?.fate_result?.text = Html.fromHtml(
//                mListener.getRandomFate(
//                    SOMEWHAT_LIKELY,
//                    chaos_value.text.toString().toInt()
//                )
//            )
//            likely.id -> view?.fate_result?.text =
//                Html.fromHtml(mListener.getRandomFate(LIKELY, chaos_value.text.toString().toInt()))
//            very_likely.id -> view?.fate_result?.text = Html.fromHtml(
//                mListener.getRandomFate(
//                    VERY_LIKELY,
//                    chaos_value.text.toString().toInt()
//                )
//            )
//            near_sure_thing.id -> view?.fate_result?.text = Html.fromHtml(
//                mListener.getRandomFate(
//                    NEAR_SURE_THING,
//                    chaos_value.text.toString().toInt()
//                )
//            )
//            a_sure_thing.id -> view?.fate_result?.text = Html.fromHtml(
//                mListener.getRandomFate(
//                    A_SURE_THING,
//                    chaos_value.text.toString().toInt()
//                )
//            )
//            has_to_be.id -> view?.fate_result?.text = Html.fromHtml(
//                mListener.getRandomFate(
//                    HAS_TO_BE,
//                    chaos_value.text.toString().toInt()
//                )
//            )
//        }
//        view?.fate_result?.visibility = VISIBLE
//        view?.clear_fate?.visibility = VISIBLE
//    }

    override fun setRandomLocation(randomLocationText: String) {
        throw IllegalStateException("setRandomLocation called in AdventureGenerator")
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}