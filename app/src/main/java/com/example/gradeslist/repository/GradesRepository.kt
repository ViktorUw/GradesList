package com.example.gradeslist.repository

import androidx.lifecycle.LiveData
import com.example.gradeslist.model.Grades
import com.example.gradeslist.data.GradesDao

class GradesRepository(private val gradesDao: GradesDao) {

    val readAllData: LiveData<List<Grades>> = gradesDao.readAllGrades()

     fun addGrades(grade: Grades) {
        gradesDao.addGrade(grade)
    }

     fun updateGrades(grades: Grades) {
        gradesDao.updateGrade(grades)
    }

     fun deleteGrade(grades: Grades) {
        gradesDao.deleteGrade(grades)
    }
    fun deleteAllGrades() {
        gradesDao.deleteAllGrades()
    }

    fun countAverage(){
        gradesDao.countAverage()
    }
}