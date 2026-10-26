package org.ucb.mobile3p.tasks.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ucb.mobile3p.tasks.domain.model.TaskModel
import org.ucb.mobile3p.tasks.domain.usecase.AddTaskUseCase
import org.ucb.mobile3p.tasks.domain.usecase.ObserveCompletedCountUseCase
import org.ucb.mobile3p.tasks.domain.usecase.ObserveTasksUseCase
import org.ucb.mobile3p.tasks.domain.usecase.ToggleTaskUseCase

class TasksViewModel(
    private val observeTasksUseCase: ObserveTasksUseCase,
    private val observeCompletedCountUseCase: ObserveCompletedCountUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val toggleTaskUseCase: ToggleTaskUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(TasksState())
    val state = _state.asStateFlow()

    init {
        observeTasks()
        observeCompletedCount()
    }

    private fun observeTasks() {
        viewModelScope.launch {
            observeTasksUseCase.invoke()
                .catch { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = error.message
                                ?: "No se pudieron acceder a las tareas"
                        )
                    }
                }
                .collect { tasks ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            tasks = tasks
                        )
                    }
                }
        }
    }

    private fun observeCompletedCount() {
        viewModelScope.launch {
            observeCompletedCountUseCase.invoke()
                .catch { error ->
                    _state.update {
                        it.copy(
                            error = error.message
                                ?: "No se pudo acceder al contador"
                        )
                    }
                }
                .collect { count ->
                    _state.update {
                        it.copy(completedCount = count)
                    }
                }
        }
    }

    fun onTitleChanged(value: String) {
        _state.update {
            it.copy(title = value)
        }
    }

    fun addTask() {
        val title = state.value.title.trim()

        if (title.isEmpty()) {
            _state.update {
                it.copy(error = "Escribe el titulo de la tarea")
            }
            return
        }

        viewModelScope.launch {
            _state.update { it.copy(isAdding = true) }

            runCatching {
                addTaskUseCase.invoke(title)
            }.onSuccess {
                _state.update {
                    it.copy(title = "")
                }
            }.onFailure { error ->
                _state.update {
                    it.copy(
                        error = error.message
                            ?: "No se pudo agregar la tarea"
                    )
                }
            }

            _state.update { it.copy(isAdding = false) }
        }
    }

    fun setCompleted(
        task: TaskModel,
        completed: Boolean
    ) {
        if (task.id in state.value.pendingTaskIds) return

        viewModelScope.launch {
            _state.update {
                it.copy(
                    pendingTaskIds =
                        it.pendingTaskIds + task.id
                )
            }

            runCatching {
                toggleTaskUseCase.invoke(task, completed)
            }.onFailure { error ->
                _state.update {
                    it.copy(
                        error = error.message
                            ?: "No se pudo sincronizar la tarea"
                    )
                }
            }

            _state.update {
                it.copy(
                    pendingTaskIds =
                        it.pendingTaskIds - task.id
                )
            }
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}