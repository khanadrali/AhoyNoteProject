package com.ahoy.testproject.ahoy_note.data.repository

import com.ahoy.testproject.ahoy_note.data.local_data_source.AhoyNoteDao
import com.ahoy.testproject.ahoy_note.domain.model.AhoyNote
import com.ahoy.testproject.ahoy_note.domain.repository.AhoyNoteRepository
import kotlinx.coroutines.flow.Flow

class AhoyNoteRepositoryImpl(
    private val dao: AhoyNoteDao
) : AhoyNoteRepository {

    override fun getAhoyNotes(): Flow<List<AhoyNote>> {
        return dao.getNotes()
    }

    override suspend fun getAhoyNoteById(id: Int): AhoyNote? {
        return dao.getNoteById(id)
    }

    override suspend fun insertAhoyNote(note: AhoyNote) {
        dao.insertNote(note)
    }

    override suspend fun deleteAhoyNote(note: AhoyNote) {
        dao.deleteNote(note)
    }
}