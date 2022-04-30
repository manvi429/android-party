package com.jb.project.roomdb

import androidx.room.Dao
import androidx.room.Transaction
import com.jb.project.roomdb.CategoryHelper
import com.jb.project.ui.dashboard.CountryListResponse
import com.jb.project.ui.dashboard.CountryListResponseItem

@Dao
abstract class LocalDBDao : CategoryHelper {

//    fun clearDB() {
//        AppDatabase.instance.clearAllTables()
//    }

    @Transaction
    open fun replaceCategories(data: List<CountryListResponseItem>) {
        clearCategories()
        insertCategories(data)
    }
}