package com.ahoy.testproject.ahoy_note.domain.use_case

import com.ahoy.testproject.ahoy_note.domain.model.AhoyNote
import com.ahoy.testproject.ahoy_note.domain.repository.AhoyNoteRepository

class GetAhoyNote(
    private val repository: AhoyNoteRepository
) {

    suspend operator fun invoke(id: Int): AhoyNote? {
        return repository.getAhoyNoteById(id)
    }
}