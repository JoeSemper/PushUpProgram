package com.joesemper.pushupprogram.domain.use_case

import com.joesemper.pushupprogram.domain.entity.WorkoutSet
import com.joesemper.pushupprogram.domain.repository.WorkoutProgramRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.take

class UpdateWorkoutSetRepsDoneUseCase(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
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

    private suspend fun updateWorkoutCompleteStatus(workoutId: Int) {
        workoutProgramRepository.getWorkoutSetsForWorkout(workoutId)
            .take(1)
            .collect { workoutSets ->
                if (checkIfWorkoutComplete(workoutSets)) {
                    updateWorkoutCompleteStatus(
                        workoutId = workoutId,
                        isComplete = true
                    )
                }
            }
    }

    private fun checkIfWorkoutComplete(workoutSets: List<WorkoutSet>): Boolean {
        workoutSets.find { it.exerciseRepsDone < it.exerciseReps }
            ?.let { return false } ?: return true
    }
}
