package com.ahoy.testproject.ahoy_note.domain.repository

import com.ahoy.testproject.ahoy_note.domain.model.AhoyNote
import kotlinx.coroutines.flow.Flow

interface AhoyNoteRepository {

    fun getAhoyNotes(): Flow<List<AhoyNote>>

    suspend fun getAhoyNoteById(id: Int): AhoyNote?

    suspend fun insertAhoyNote(note: AhoyNote)

    suspend fun deleteAhoyNote(note: AhoyNote)

}