package com.example.gradeslist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gradeslist.model.Grades

@Database(entities = [Grades::class], version = 1, exportSchema = false)
abstract class GradesDatabase : RoomDatabase() {
    abstract fun gradesDao(): GradesDao

    companion object{
        @Volatile
        private var INSTANCE: GradesDatabase? = null

        fun getDatabase(context: Context): GradesDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GradesDatabase::class.java,
                    "grades_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}