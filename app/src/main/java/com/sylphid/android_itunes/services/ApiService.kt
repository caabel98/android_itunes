package com.sylphid.android_itunes.services

import com.sylphid.android_itunes.models.Root
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //Initial implementations of searches are likely incorrect and will require an update

    //https://itunes.apple.com/search?term=rock&amp;media=music&amp;entity=song&amp;limit=50
    @GET("search")
    fun getRockMusic(
        @Query("term") term: String = "rock",
        @Query("media") media: String = "music",
        @Query("entity") entity: String = "song"
    ): Call<Root>

    //https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50
    @GET("search")
    fun getClassicMusic(
        @Query("term") term: String = "classic",
        @Query("media") media: String = "music",
        @Query("entity") entity: String = "song"
    ): Call<Root>

    //https://itunes.apple.com/search?term=pop&amp;media=music&amp;entity=song&amp;limit=50
    @GET("search")
    fun getPopMusic(
        @Query("term") term: String = "pop",
        @Query("media") media: String = "music",
        @Query("entity") entity: String = "song"
    ): Call<Root>

    companion object{
        val baseUrl: String = "https://itunes.apple.com/"
        var retrofit: Retrofit? = null

        fun getRetrofitInstance(): Retrofit {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}