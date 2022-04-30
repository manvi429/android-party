package com.jb.project.ui.dashboard
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


class CountryListResponse : ArrayList<CountryListResponseItem>()

@Entity
data class CountryListResponseItem(
    @SerializedName("distance")
    val distance: Int,
    @PrimaryKey(autoGenerate = true)
    @SerializedName("Id")
    val Id: Int,
    @SerializedName("name")
    val name: String
)


