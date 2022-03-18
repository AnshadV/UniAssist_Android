package com.android.uniassist.fragments


import android.app.LauncherActivity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.uniassist.CityAdapter
import com.android.uniassist.CourseAdapter
import com.android.uniassist.MainActivity

import com.android.uniassist.R
import com.android.uniassist.auth.LoginActivity
import com.android.uniassist.data.City
import com.android.uniassist.data.Course
import com.android.uniassist.data.universityL
import com.android.uniassist.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * HomeFragment
 *  2 Buttons
 *  Nav graph start fragment
 */

class HomeFragment : Fragment(), View.OnClickListener { //OnClickListener

    private lateinit var navController: NavController
    private lateinit var binding: FragmentHomeBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var viewModel: HomeViewModel

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController() //Initialising navController

        //Initialising button click event listener

        auth = Firebase.auth
    }

    override fun onClick(v: View?) { //When click occurs this function is triggered
        when(v?.id) { //Check for the id of the view i which click event happened

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val city = listOf(
            City(1,"","Berlin"),
            City(2,"", "Tronto"),
            City(3,"","Munich"),
            City(4,"", "Rome"),


        )
        recyclerViewCities.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewCities.adapter = CityAdapter(city)


        recyclerViewCourses.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCourses.adapter = CourseAdapter(universityL)

        recyclerViewCourses2.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCourses2.adapter = CourseAdapter(universityL)

        recyclerViewCourses3.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCourses3.adapter = CourseAdapter(universityL)

    }


    private fun goToNextFragment() {
        val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment() //if needed pass values to frag here NB: add that arguments to nav_graph also
        navController.navigate(action) //navigation
    }

    private fun closeApp() {
        auth.signOut()
    }

}
