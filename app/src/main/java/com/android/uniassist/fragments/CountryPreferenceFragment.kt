package com.android.uniassist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.FragmentManager
import com.android.uniassist.R
import com.android.uniassist.databinding.FragmentCountryPreferenceBinding
import kotlinx.coroutines.NonDisposableHandle.parent
import android.R.id






class CountryPreferenceFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentCountryPreferenceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountryPreferenceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countries = resources.getStringArray(R.array.countries)

        val arrayAdapter = activity?.let { ArrayAdapter(it, R.layout.dropdown_item, countries) }

        val autocompleteTV = binding.autoCompleteTextView

        autocompleteTV.setAdapter(arrayAdapter)






    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (p0 != null) {
            p0.getItemAtPosition(p2)
        }




    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}