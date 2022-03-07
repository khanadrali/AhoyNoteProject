package com.ahoy.testproject.ahoy_note.data.local_data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahoy.testproject.ahoy_note.domain.model.AhoyNote

@Database(
    entities = [AhoyNote::class],
    version = 1
)
abstract class AhoyNoteDatabase: RoomDatabase() {

    abstract val noteDao: AhoyNoteDao

    companion object {
        const val DATABASE_NAME = "ahoy_note_db"
    }
}