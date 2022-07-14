package com.sylphid.android_itunes.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.sylphid.android_itunes.R
import com.sylphid.android_itunes.databinding.FragmentSongListBinding
import com.sylphid.android_itunes.services.ApiService
import com.sylphid.android_itunes.models.Root
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SongListFragment(genre: String) : Fragment() {

    lateinit var binding: FragmentSongListBinding
    var songGenre = genre

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongListBinding.inflate(layoutInflater)

        fetchSongs()

        return binding.root
    }

    private fun fetchSongs() {
        ApiService.getRetrofitInstance()?.create(ApiService::class.java)
            ?.getMusic(songGenre)?.enqueue(object: Callback<Root> {
                override fun onResponse(
                    call: Call<Root>,
                    response: Response<Root>
                ) {
                    if (response.isSuccessful){
                        val songAdapter = SongAdapter(response.body()!!.results, ::playSong)
                        binding.rvSongList.adapter = songAdapter
                    } else{
                        Toast.makeText(context,"The query was unsuccessful", Toast.LENGTH_LONG)
                    }
                }

                override fun onFailure(call: Call<Root>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                }

                fun playSong(song: String){
                    val intent: Intent = Intent(Intent.ACTION_VIEW)
                    intent.setDataAndType(Uri.parse(song), "audio/mp4")
                    startActivity(intent)
                }
            })
    }
}