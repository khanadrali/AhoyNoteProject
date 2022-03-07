package com.ahoy.testproject.ahoy_note.data.local_data_source

import androidx.room.*
import com.ahoy.testproject.ahoy_note.domain.model.AhoyNote
import kotlinx.coroutines.flow.Flow

@Dao
interface AhoyNoteDao {

    @Query("SELECT * FROM AhoyNote")
    fun getNotes(): Flow<List<AhoyNote>>

    @Query("SELECT * FROM AhoyNote WHERE id = :id")
    suspend fun getNoteById(id: Int): AhoyNote?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(ahoyNote: AhoyNote)

    @Delete
    suspend fun deleteNote(ahoyNote: AhoyNote)
}