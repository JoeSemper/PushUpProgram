package com.joesemper.pushupprogram.domain.use_case

import com.joesemper.pushupprogram.domain.repository.WorkoutProgramRepository
import kotlinx.coroutines.*

class UpdateWorkoutSetRepsDoneUseCase(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val workoutProgramRepository: WorkoutProgramRepository,
    private val updateWorkoutCompleteStatus: UpdateWorkoutCompleteStatusUseCase,
) {
    suspend operator fun invoke(workoutId: Int, workoutSetId: Int, repsDone: Int) =
        withContext(defaultDispatcher) {

            workoutProgramRepository.updateWorkoutSetRepsDone(
                workoutSetId = workoutSetId,
                repsDone = if (repsDone <= 0) 0 else repsDone
            )

            updateWorkoutCompleteStatus(
                workoutId = workoutId
            )

        }
}