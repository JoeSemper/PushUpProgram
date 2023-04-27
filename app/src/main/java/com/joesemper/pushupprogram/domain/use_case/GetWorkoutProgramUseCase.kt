package com.joesemper.pushupprogram.domain.use_case

import com.joesemper.pushupprogram.domain.repository.WorkoutProgramRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetWorkoutProgramUseCase(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val workoutProgramRepository: WorkoutProgramRepository
) {
    suspend operator fun invoke() = withContext(defaultDispatcher) {
        workoutProgramRepository.getWorkouts()
    }
}