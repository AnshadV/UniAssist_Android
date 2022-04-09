package com.android.uniassist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.uniassist.data.Course
import com.android.uniassist.data.University
import kotlinx.android.synthetic.main.layout_course.view.*

class CourseAdapter(val courses : List<University>) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    class CourseViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_course, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]

        holder.view.uniName.text = course.uniName
        holder.view.cityName.text = course.city
        holder.view.uniImage.setImageResource(course.uniImage)
    }

    override fun getItemCount() = courses.size
}