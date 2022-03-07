package com.ahoy.testproject.ahoy_note.presentation.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahoy.testproject.ahoy_note.domain.model.AhoyNote
import com.ahoy.testproject.ahoy_note.domain.use_case.AhoyNoteUseCases
import com.ahoy.testproject.ahoy_note.domain.util.AhoyNoteOrder
import com.ahoy.testproject.ahoy_note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AhoyNotesViewModel @Inject constructor(
    private val noteUseCases: AhoyNoteUseCases
) : ViewModel() {

    private val _state = mutableStateOf(AhoyNotesState())
    val state: State<AhoyNotesState> = _state

    private var recentlyDeletedNote: AhoyNote? = null

    private var getNotesJob: Job? = null

    init {
        getNotes(AhoyNoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: AhoyNotesEvent) {
        when (event) {
            is AhoyNotesEvent.OrderAhoyNote -> {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getNotes(event.noteOrder)
            }
            is AhoyNotesEvent.DeleteAhoyNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
            }
            is AhoyNotesEvent.RestoreAhoyNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
            is AhoyNotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }

        }
    }

    private fun getNotes(noteOrder: AhoyNoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getNotes(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }
}