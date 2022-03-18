package com.android.uniassist.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

import com.android.uniassist.R
import com.android.uniassist.databinding.FragmentHomeBinding
import com.android.uniassist.databinding.FragmentProfileBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * ProfileFragment
 */

class ProfileFragment : Fragment(), View.OnClickListener {

    private lateinit var binding : FragmentProfileBinding
    private lateinit var chipGroup: ChipGroup
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        binding.countryActionChip.setOnClickListener{
            val action = ProfileFragmentDirections.actionProfileFragmentToCountryPreferenceFragment()
            navController.navigate(action)
        }

        openDoc.setOnClickListener{
            val action = ProfileFragmentDirections.actionProfileFragmentToDocumentFragment()
            navController.navigate(action)
        }


        chipGroup = binding.countryChipGroup
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.countryActionChip -> addCountry()
            R.id.countryActionChip -> addCourse()
        }
    }

    private fun addCountry() {

    }

    private fun addCourse() {

    }

    fun addChip(text: String) {
        val chip = Chip(activity)
        chip.text = text
        chip.isCloseIconVisible = true
        chip.setOnCloseIconClickListener{
            chipGroup.removeView(chip)
        }
        chipGroup.addView(chip)
    }


}
