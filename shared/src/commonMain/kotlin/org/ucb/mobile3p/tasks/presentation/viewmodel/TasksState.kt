package org.ucb.mobile3p.tasks.presentation.viewmodel

import org.ucb.mobile3p.tasks.domain.model.TaskModel

data class TasksState(
    val isLoading: Boolean = true,
    val isAdding: Boolean = false,
    val title: String = "",
    val tasks: List<TaskModel> = emptyList(),
    val completedCount: Long = 0L,
    val pendingTaskIds: Set<String> = emptySet(),
    val error: String? = null
)