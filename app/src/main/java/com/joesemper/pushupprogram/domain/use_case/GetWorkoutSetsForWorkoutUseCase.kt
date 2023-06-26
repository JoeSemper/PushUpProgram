package com.joesemper.pushupprogram.domain.use_case

import com.joesemper.pushupprogram.domain.repository.WorkoutProgramRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetWorkoutSetsForWorkoutUseCase (
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val workoutProgramRepository: WorkoutProgramRepository
) {
    suspend operator fun invoke(workoutId: Int) = withContext(defaultDispatcher) {
        workoutProgramRepository.getWorkoutSetsForWorkout(workoutId)
    }
}