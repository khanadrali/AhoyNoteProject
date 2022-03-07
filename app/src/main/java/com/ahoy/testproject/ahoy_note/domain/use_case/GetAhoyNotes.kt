package com.ahoy.testproject.ahoy_note.domain.use_case

import com.ahoy.testproject.ahoy_note.domain.model.AhoyNote
import com.ahoy.testproject.ahoy_note.domain.repository.AhoyNoteRepository
import com.ahoy.testproject.ahoy_note.domain.util.AhoyNoteOrder
import com.ahoy.testproject.ahoy_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAhoyNotes(
    private val repository: AhoyNoteRepository
) {

    operator fun invoke(
        noteOrder: AhoyNoteOrder = AhoyNoteOrder.Date(OrderType.Descending)
    ): Flow<List<AhoyNote>> {
        return repository.getAhoyNotes().map { notes ->
            when(noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when(noteOrder) {
                        is AhoyNoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is AhoyNoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is AhoyNoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when(noteOrder) {
                        is AhoyNoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is AhoyNoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is AhoyNoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}