package com.ahoy.testproject.ahoy_note.domain.use_case

import com.ahoy.testproject.ahoy_note.domain.model.AhoyNote
import com.ahoy.testproject.ahoy_note.domain.repository.AhoyNoteRepository

class DeleteAhoyNote(
    private val repository: AhoyNoteRepository
) {

    suspend operator fun invoke(note: AhoyNote) {
        repository.deleteAhoyNote(note)
    }
}