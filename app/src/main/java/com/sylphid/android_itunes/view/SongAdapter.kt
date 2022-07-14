package com.sylphid.android_itunes.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sylphid.android_itunes.R
import com.sylphid.android_itunes.databinding.SongListItemBinding
import com.sylphid.android_itunes.models.SongResponse

class SongAdapter(
    private val list: List<SongResponse>
): RecyclerView.Adapter<SongAdapter.SongViewHolder>() {


    inner class SongViewHolder(private val binding: SongListItemBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun onBind(song: SongResponse){
                binding.tvSongTitle.text = song.trackName
                binding.tvArtistName.text = song.artistName
                binding.tvPrice.text = song.getFullPrice()

                Glide.with(binding.albumPhoto)
                    .load(song.artworkUrl100)
                    .placeholder(R.drawable.loading_icon)
                    .into(binding.albumPhoto)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(
            SongListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}