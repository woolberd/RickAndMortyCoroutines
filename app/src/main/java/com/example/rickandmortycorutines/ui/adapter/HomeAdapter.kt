package com.example.rickandmortycorutines.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortycorutines.base.BaseDiffUtilItemCallback
import com.example.rickandmortycorutines.databinding.ItemHomeBinding
import com.example.rickandmortycorutines.models.CharacterAndLocationModel

class HomeAdapter: ListAdapter<CharacterAndLocationModel, HomeAdapter.HomeViewHolder>(BaseDiffUtilItemCallback()) {

    class HomeViewHolder(private var binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: CharacterAndLocationModel) {
            binding.tvDimension.text = item.location.dimension
            binding.itemNameCharacter.text = item.character.name
            binding.tvTypeLocation.text = item.location.type
            Glide.with(binding.actionImageCharacter).load(item.character.image)
                .into(binding.actionImageCharacter)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}