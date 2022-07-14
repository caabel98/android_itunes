package com.sylphid.android_itunes.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class Root(
    val resultCount: Int,
    val results: List<SongResponse>
)

@Parcelize
data class SongResponse(
    val wrapperType: String,
    val kind: String,
    val artistId: Int,
    val collectionId: Int,
    val trackId: Int,
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val collectionCensoredName: String,
    val trackCensoredName: String,
    val artistViewUrl: String,
    val collectionViewUrl: String,
    val trackViewUrl: String,
    val previewUrl: String,
    val artworkUrl100: String,
    val collectionPrice: Double,
    val trackPrice: Double,
    val releaseDate: String,
    val collectionExplicitness: String,
    val trackExplicitness: String,
    val discCount: Int,
    val discNumber: Int,
    val trackCount: Int,
    val trackNumber: Int,
    val trackTimeMillis: Int,
    val country: String,
    val currency: String,
    val primaryGenreName: String,
    val isStreamable: Boolean
): Parcelable{
    fun getFullPrice() = "$trackPrice $currency"
}

