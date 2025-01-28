package com.example.gradeslist.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.gradeslist.model.Grades

@Dao
interface GradesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGrade(grade: Grades)

    @Update
    fun updateGrade(grade: Grades)

    @Delete
    fun deleteGrade(grade: Grades)

    @Query("DELETE FROM grades_table")
    fun deleteAllGrades()

    @Query("SELECT AVG(grade) FROM grades_table")
    fun countAverage(): LiveData<Float>

    @Query("SELECT * FROM grades_table ORDER BY id ASC")
    fun readAllGrades(): LiveData<List<Grades>>
}