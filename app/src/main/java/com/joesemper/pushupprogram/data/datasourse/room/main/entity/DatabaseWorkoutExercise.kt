package com.joesemper.pushupprogram.data.datasourse.room.main.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity.PrepopulatedMuscleGroup
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "Exercises",
    foreignKeys = [ForeignKey(
        entity = DatabaseMuscleGroup::class,
        parentColumns = arrayOf("muscle_group_id"),
        childColumns = arrayOf("muscle_group_id"),
        onDelete = ForeignKey.NO_ACTION,
        onUpdate = ForeignKey.NO_ACTION
    )]
)
@Parcelize
data class DatabaseWorkoutExercise(
    @PrimaryKey()
    @ColumnInfo(name = "exercise_id") val exercise_id: Int,
    @ColumnInfo(name = "exercise_name") val exerciseName: String = "",
    @ColumnInfo(name = "muscle_group_id") val muscleGroupId: Int = 0,
    @ColumnInfo(name = "description") val description: String = ""
) : Parcelable