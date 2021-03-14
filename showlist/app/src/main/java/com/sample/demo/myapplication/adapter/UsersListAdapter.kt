package com.sample.demo.myapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.demo.myapplication.R
import com.sample.demo.myapplication.bean.ResultsItem
import com.sample.demo.myapplication.bean.Zoobean
import kotlinx.android.synthetic.main.animal_list_item.view.*


class UsersListAdapter(val partItemList: Zoobean, val clickListener: (ResultsItem) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.animal_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        partItemList.result.results?.let { (holder as PartViewHolder).bind(it.get(position), clickListener) }
    }

    override fun getItemCount(): Int = partItemList.result.results!!.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: ResultsItem, clickListener: (ResultsItem) -> Unit) {
            Glide
                .with(itemView.avatar_image_view)
                .load(part.ePicURL)
                .centerCrop()
                .into(itemView.avatar_image_view)
            itemView.login_text_view.text = part.eName
            itemView.login_text_view2.text = part.eInfo
            itemView.setOnClickListener { clickListener(part) }
        }

//        private fun clickListener(eName: String) {
//
//        }
    }
}