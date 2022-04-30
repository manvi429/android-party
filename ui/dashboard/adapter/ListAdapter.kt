package com.jb.project.ui.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jb.project.R
import com.jb.project.ui.dashboard.CountryListResponseItem
import kotlinx.android.synthetic.main.item_view_list.view.*


class ListAdapter(private val countryListResponse: List<CountryListResponseItem>) : RecyclerView.Adapter<ListAdapter.ViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return countryListResponse.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(countryListResponse[position])

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(countryListResponseItem: CountryListResponseItem) {
            itemView.tvname.text=countryListResponseItem.name
            itemView.tvdistance.text=countryListResponseItem.distance.toString()+"km"
        }


    }


}