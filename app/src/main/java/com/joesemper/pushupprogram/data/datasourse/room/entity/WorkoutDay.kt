package com.joesemper.pushupprogram.data.datasourse.room.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

@Entity(tableName = "Program")
@Parcelize
data class WorkoutDay(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "exercise_one") val exerciseOne: Int?,
    @ColumnInfo(name = "exercise_one_repeats") val exerciseOneRepeats: Int?,
    @ColumnInfo(name = "exercise_two") val exerciseTwo: Int?,
    @ColumnInfo(name = "exercise_two_repeats") val exerciseTwoRepeats: Int?,
) : Parcelable
