package com.ahoy.testproject.ahoy_note.presentation.main_screen

import com.ahoy.testproject.ahoy_note.domain.model.AhoyNote
import com.ahoy.testproject.ahoy_note.domain.util.AhoyNoteOrder

sealed class AhoyNotesEvent {
    data class OrderAhoyNote(val noteOrder: AhoyNoteOrder): AhoyNotesEvent()
    data class DeleteAhoyNote(val note: AhoyNote): AhoyNotesEvent()
    object RestoreAhoyNote: AhoyNotesEvent()
    object ToggleOrderSection: AhoyNotesEvent()
}
