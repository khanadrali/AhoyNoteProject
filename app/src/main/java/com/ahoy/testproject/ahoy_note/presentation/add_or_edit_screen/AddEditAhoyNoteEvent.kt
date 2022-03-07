package com.ahoy.testproject.ahoy_note.presentation.add_or_edit_screen

import androidx.compose.ui.focus.FocusState

sealed class AddEditAhoyNoteEvent{
    data class EnteredTitle(val value: String): AddEditAhoyNoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState): AddEditAhoyNoteEvent()
    data class EnteredContent(val value: String): AddEditAhoyNoteEvent()
    data class ChangeContentFocus(val focusState: FocusState): AddEditAhoyNoteEvent()
    data class ChangeColor(val color: Int): AddEditAhoyNoteEvent()
    object SaveNote: AddEditAhoyNoteEvent()
}

