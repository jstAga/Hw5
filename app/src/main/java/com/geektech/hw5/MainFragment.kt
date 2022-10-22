package com.geektech.hw5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geektech.hw5.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var isItPlus = true     //проверяет плюс ли сейчас
        binding.btnPlus.setOnClickListener(View.OnClickListener {
            var numAtTheMoment = binding.tvCounter.text.toString().toInt()

            if (isItPlus) {
                var newNum = numAtTheMoment + 1
                binding.tvCounter.text = newNum.toString()

                if (newNum == 10) {
                    isItPlus = false
                    binding.btnPlus.text = "-"
                }

            } else{
                var newNum = numAtTheMoment - 1
                binding.tvCounter.text = newNum.toString()

                if (newNum == 0){
                    MAIN.navController.navigate(R.id.action_mainFragment_to_secondFragment)
                }
            }
        })
    }
}