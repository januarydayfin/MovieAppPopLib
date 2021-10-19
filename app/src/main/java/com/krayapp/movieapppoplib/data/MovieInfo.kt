package com.krayapp.movieapppoplib.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "MovieList")
data class MovieInfo(
    @Expose
    @PrimaryKey
    val id: Int,
    @Expose
    val title: String,
    @Expose
    val overview: String,
    @Expose
    val vote_average: Float,
    @Expose
    val poster_path: String
) : Parcelable
