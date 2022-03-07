package com.ahoy.testproject.ahoy_note.domain.di

import android.app.Application
import androidx.room.Room
import com.ahoy.testproject.ahoy_note.data.local_data_source.AhoyNoteDatabase
import com.ahoy.testproject.ahoy_note.data.repository.AhoyNoteRepositoryImpl
import com.ahoy.testproject.ahoy_note.domain.repository.AhoyNoteRepository
import com.ahoy.testproject.ahoy_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): AhoyNoteDatabase {
        return Room.databaseBuilder(
            app,
            AhoyNoteDatabase::class.java,
            AhoyNoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: AhoyNoteDatabase): AhoyNoteRepository {
        return AhoyNoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: AhoyNoteRepository): AhoyNoteUseCases {
        return AhoyNoteUseCases(
            getNotes = GetAhoyNotes(repository),
            deleteNote = DeleteAhoyNote(repository),
            addNote = AddAhoyNote(repository),
            getNote = GetAhoyNote(repository)
        )
    }
}