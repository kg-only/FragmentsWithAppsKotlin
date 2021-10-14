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

class DiceFragment : Fragment() {


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



        binding.btnThrow.setOnClickListener {
            binding.btnThrow.text = getString(R.string.lets_roll)
            rollDice()
        }

    }

    private fun rollDice() {
        val drawableResource = when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (Random().nextInt(6) + 1) {
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
}
