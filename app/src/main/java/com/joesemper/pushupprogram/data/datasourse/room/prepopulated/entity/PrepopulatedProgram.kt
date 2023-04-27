package com.joesemper.pushupprogram.data.datasourse.room.prepopulated.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "Programs"
)
@Parcelize
data class PrepopulatedProgram(
    @PrimaryKey()
    @ColumnInfo(name = "program_id") val programId: Int?,
    @ColumnInfo(name = "duration_weeks") val durationWeeks: Int?,
    @ColumnInfo(name = "program_name") val programName: String?,
) : Parcelable