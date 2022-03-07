package com.ahoy.testproject.ahoy_note.domain.use_case

import com.ahoy.testproject.ahoy_note.domain.model.InvalidNoteException
import com.ahoy.testproject.ahoy_note.domain.model.AhoyNote
import com.ahoy.testproject.ahoy_note.domain.repository.AhoyNoteRepository

class AddAhoyNote(
    private val repository: AhoyNoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: AhoyNote) {
        if(note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertAhoyNote(note)
    }

}