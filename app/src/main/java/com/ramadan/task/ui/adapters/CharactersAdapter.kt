package com.ramadan.task.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ramadan.task.data.response.Character
import com.ramadan.task.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso
import javax.inject.Inject

class CharactersAdapter @Inject constructor() : PagingDataAdapter <Character , CharactersAdapter.CharacterViewHolder>(CharacterComparator)  {

    class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
     fun bind(character: Character){
       with(binding){
           characterName.text = character.name
           Picasso.get().load(character.image).into(characterImageview)
       }
     }
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )

    }

    object CharacterComparator : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }

    }
}