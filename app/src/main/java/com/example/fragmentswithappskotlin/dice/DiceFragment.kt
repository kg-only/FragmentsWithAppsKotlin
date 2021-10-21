package com.example.fragmentswithappskotlin.dice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentswithappskotlin.R
import com.example.fragmentswithappskotlin.databinding.FragmentDiceBinding
import java.util.*

private lateinit var binding: FragmentDiceBinding
private var ranF = 0
private var ranS = 0

class DiceFragment : Fragment() {

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        ranF = savedInstanceState?.getInt("ranF",1)!!
        ranS = savedInstanceState.getInt("ranS",1)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ranF = Random().nextInt(6) + 1
        ranS = Random().nextInt(6) + 1

        binding.btnThrow.setOnClickListener {
            binding.btnThrow.text = getString(R.string.lets_roll)
            rollDice(ranF, ranS)
        }
        fun onViewStateRestored(savedInstanceState: Bundle?) {
            super.onViewStateRestored(savedInstanceState)
            ranF = savedInstanceState!!.getInt("ranF",1000)
            ranS = savedInstanceState.getInt("ranS",1000)
        }
        fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            outState.putInt("ranF", ranF)
            outState.putInt("ranS", ranS)
        }
    }


    private fun rollDice(x: Int, y: Int) {
        val drawableResource = when (x) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (y) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.imageView.setImageResource(drawableResource)
        binding.imageView2.setImageResource(drawableResource2)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ranF", ranF)
        outState.putInt("ranS", ranS)
    }
}
