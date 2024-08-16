package com.example.kotlinappfood.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinappfood.databinding.OnBoradingItemBinding
import com.example.kotlinappfood.models.OnBoardingModel

class OnBoardingAdapter(private val onBoardingList: List<OnBoardingModel>) : RecyclerView.Adapter<OnBoardingAdapter.MyHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder =
        MyHolder(OnBoradingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bindDate(onBoardingList[position])
    }

    override fun getItemCount(): Int = onBoardingList.size

    class MyHolder(private val binding: OnBoradingItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindDate(onBoardingList: OnBoardingModel){
            Glide.with(binding.root).load(onBoardingList.image).into(binding.onBoardingImageView)
            binding.onBoardingTextViewTitle.text = onBoardingList.title
            binding.onBoardingTextViewDescription.text = onBoardingList.description
        }
    }

}