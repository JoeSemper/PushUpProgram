package com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Exercises")
@Parcelize
data class PrepopulatedWorkoutExercise(
    @PrimaryKey()
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "exercise_name") val exerciseName: String?
) : Parcelable