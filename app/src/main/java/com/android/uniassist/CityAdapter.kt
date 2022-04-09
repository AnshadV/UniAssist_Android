package com.android.uniassist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.uniassist.data.City
import kotlinx.android.synthetic.main.layout_city.view.*

class CityAdapter(val cities : List<City>) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    class CityViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_city, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cities[position]

        holder.view.cityName.text = city.name
        holder.view.city_image.setImageResource(city.image)
    }

    override fun getItemCount() = cities.size
}