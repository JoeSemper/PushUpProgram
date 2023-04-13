package com.joesemper.pushupprogram.data.datasourse.room.main.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "Program",
    foreignKeys = [ForeignKey(
        entity = DatabaseWorkoutExercise::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("exercise_one"),
        onDelete = ForeignKey.NO_ACTION,
        onUpdate = ForeignKey.NO_ACTION
    ), ForeignKey(
        entity = DatabaseWorkoutExercise::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("exercise_two"),
        onDelete = ForeignKey.NO_ACTION,
        onUpdate = ForeignKey.NO_ACTION
    )]
)
@Parcelize
data class DatabaseWorkout(
    @PrimaryKey()
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "date") val date: Long = 0,
    @ColumnInfo(name = "exercise_one") val exerciseOne: Int?,
    @ColumnInfo(name = "exercise_one_repeats") val exerciseOneRepeats: Int = 0,
    @ColumnInfo(name = "exercise_one_repeats_done") val exerciseOneRepeatsDone: Int = 0,
    @ColumnInfo(name = "exercise_two") val exerciseTwo: Int?,
    @ColumnInfo(name = "exercise_two_repeats") val exerciseTwoRepeats: Int = 0,
    @ColumnInfo(name = "exercise_two_repeats_done") val exerciseTwoRepeatsDone: Int = 0,
) : Parcelable