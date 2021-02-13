package com.uzdev.guidebook.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uzdev.guidebook.databinding.GuideItemRowBinding
import com.uzdev.guidebook.model.Data
import com.uzdev.guidebook.ui.fragment.MainFragmentDirections

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var items = emptyList<Data>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            GuideItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindTo(items[position])
    }

    override fun getItemCount(): Int = items.size


    fun setListData(data: List<Data>) {
        this.items = data
        notifyDataSetChanged()
    }


    class MyViewHolder(private val binding: GuideItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bindTo(data: Data) {
            binding.guideName.text = data.name
            binding.endDate.text = data.endDate
            binding.startDate.text = data.startDate
            Glide.with(binding.root).load(data.icon).into(binding.appCompatImageView)

            binding.root.setOnClickListener {

                val action = MainFragmentDirections.actionMainFragmentToWebFragment(data)

                itemView.findNavController()
                    .navigate(action)

            }
        }

    }
}