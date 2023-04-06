package com.joesemper.pushupprogram.data.datasourse.room.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Exercises")
@Parcelize
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "exercise_name") val exerciseName: String?
) : Parcelable