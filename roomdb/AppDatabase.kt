package com.jb.project.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jb.project.ui.dashboard.CountryListResponse
import com.jb.project.ui.dashboard.CountryListResponseItem

@Database(entities = [CountryListResponseItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun localDB(): LocalDBDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "word_database").allowMainThreadQueries().build()
                INSTANCE = instance
                // return instance
                return instance
            }

        }
    }

}