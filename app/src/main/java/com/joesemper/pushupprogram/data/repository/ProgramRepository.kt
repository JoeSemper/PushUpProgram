package com.joesemper.pushupprogram.data.repository

import com.joesemper.pushupprogram.data.datasourse.room.dao.ProgramDao

class ProgramRepository(
    private val programDao: ProgramDao
) {
    suspend fun getAll() = programDao.getAll()
}