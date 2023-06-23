package com.joesemper.pushupprogram.domain.use_case

import com.joesemper.pushupprogram.domain.repository.WorkoutProgramRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateWorkoutSetRepsDoneUseCase(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val workoutProgramRepository: WorkoutProgramRepository
) {
    suspend operator fun invoke(workoutSetId: Int, repsDone: Int) =
        withContext(defaultDispatcher) {
            workoutProgramRepository.updateWorkoutSetRepsDone(workoutSetId, repsDone)
        }
}