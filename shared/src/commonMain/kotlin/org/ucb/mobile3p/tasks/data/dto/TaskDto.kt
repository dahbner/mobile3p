package org.ucb.mobile3p.tasks.data.dto

import kotlinx.serialization.Serializable
import org.ucb.mobile3p.tasks.domain.model.TaskModel

@Serializable
data class TaskDto(
    val title: String = "",
    val completed: Boolean = false
) {
    fun toModel(id: String): TaskModel {
        return TaskModel(
            id = id,
            title = title,
            completed = completed
        )
    }
}
