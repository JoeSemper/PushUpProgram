package com.joesemper.pushupprogram.domain.use_case

import com.joesemper.pushupprogram.domain.entity.WorkoutSet
import com.joesemper.pushupprogram.domain.repository.WorkoutProgramRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.withContext

class UpdateWorkoutCompleteStatusUseCase(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val workoutProgramRepository: WorkoutProgramRepository
) {
    suspend operator fun invoke(workoutId: Int) =
        withContext(defaultDispatcher) {
            workoutProgramRepository.getWorkoutSetsForWorkout(workoutId)
                .take(1)
                .collect { workoutSets ->
                    if (checkIfWorkoutComplete(workoutSets)) {
                        onCompleteWorkout(workoutId)
                    }
                }
        }

    private fun checkIfWorkoutComplete(workoutSets: List<WorkoutSet>): Boolean {
        workoutSets.find { it.exerciseRepsDone < it.exerciseReps }
            ?.let { return false } ?: return true
    }

    private suspend fun onCompleteWorkout(workoutId: Int) {
        workoutProgramRepository.updateWorkoutCompleteStatus(
            workoutId = workoutId,
            isComplete = true
        )
    }
}