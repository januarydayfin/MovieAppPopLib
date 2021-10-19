package com.krayapp.movieapppoplib.data.retrofit2.DTO

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.krayapp.movieapppoplib.data.ActorInfo
import com.krayapp.movieapppoplib.data.MovieInfo

@Entity(tableName = "actor_list",
    foreignKeys = [ForeignKey(
        entity = MovieInfo::class,
        parentColumns = ["id"],
        childColumns = ["movieId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ActorListDTO(
    @Expose
    @PrimaryKey
    @ColumnInfo(name = "movieId", index = true)
    val id: Int,
    @Expose
    val cast: List<ActorInfo>
)
