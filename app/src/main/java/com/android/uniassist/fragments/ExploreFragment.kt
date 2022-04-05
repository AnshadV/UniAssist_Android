package com.android.uniassist.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.android.uniassist.R

import kotlinx.android.synthetic.main.fragment_explore.*
import kotlinx.android.synthetic.main.fragment_explore.view.*

/**
 * AccountsFragment
 */

class ExploreFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun onRadioButtonClicked(view: View) {
            if(view is RadioButton) {
                val checked = view.isChecked

                when (view.id) {
                    R.id.isBachelorRadio ->
                        if (checked) {

                        }
                    R.id.isMasterRadio ->
                        if (checked) {

                        }
                }
            }
        }

    }

}
