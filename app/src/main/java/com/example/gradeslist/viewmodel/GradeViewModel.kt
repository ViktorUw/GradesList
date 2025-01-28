package com.example.gradeslist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.gradeslist.data.GradesDao
import com.example.gradeslist.model.Grades
import com.example.gradeslist.data.GradesDatabase
import com.example.gradeslist.repository.GradesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GradeViewModel(aplication: Application) : AndroidViewModel(aplication) {
    val readAllData: LiveData<List<Grades>>
    val repository: GradesRepository

    private val gradesDao: GradesDao = GradesDatabase.getDatabase(aplication).gradesDao()
    val averageGrade: LiveData<Float> = gradesDao.countAverage()

    init {
        val gradesDao = GradesDatabase.Companion.getDatabase(aplication).gradesDao()
        repository = GradesRepository(gradesDao)
        readAllData = repository.readAllData

    }

    fun addGrade(grade: Grades){
        viewModelScope.launch(Dispatchers.IO){
            repository.addGrades(grade)
        }
    }
    fun updateGrade(grade: Grades) {
        viewModelScope.launch(Dispatchers.IO){
           repository.updateGrades(grade)
        }
    }

    fun deleteGrade(grade: Grades) {
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteGrade(grade)
        }
    }

    fun deleteAllGrades() {
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllGrades()
        }
    }

}