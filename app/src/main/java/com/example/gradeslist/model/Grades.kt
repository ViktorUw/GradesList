package com.example.gradeslist.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "grades_table")
data class Grades(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val subject: String,
    val grade: String
): Parcelable