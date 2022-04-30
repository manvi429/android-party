package com.jb.project.roomdb

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jb.project.ui.dashboard.CountryListResponse
import com.jb.project.ui.dashboard.CountryListResponseItem

interface CategoryHelper {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(data: CountryListResponseItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(data: List<CountryListResponseItem>)

    @Query("DELETE FROM CountryListResponseItem")
    fun clearCategories()

    @Query("SELECT * FROM CountryListResponseItem")
    fun getCategories(): List<CountryListResponseItem>


    @Query("Select * from CountryListResponseItem")
    fun getAllContact(): List<CountryListResponseItem>


}