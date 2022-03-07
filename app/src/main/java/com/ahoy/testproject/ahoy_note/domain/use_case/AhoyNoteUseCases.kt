package com.ahoy.testproject.ahoy_note.domain.use_case

data class AhoyNoteUseCases(
    val getNotes: GetAhoyNotes,
    val deleteNote: DeleteAhoyNote,
    val addNote: AddAhoyNote,
    val getNote: GetAhoyNote
)
