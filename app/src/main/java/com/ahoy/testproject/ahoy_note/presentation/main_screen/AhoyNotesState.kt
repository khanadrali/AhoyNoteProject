package com.ahoy.testproject.ahoy_note.presentation.main_screen

import com.ahoy.testproject.ahoy_note.domain.model.AhoyNote
import com.ahoy.testproject.ahoy_note.domain.util.AhoyNoteOrder
import com.ahoy.testproject.ahoy_note.domain.util.OrderType

data class AhoyNotesState(
    val notes: List<AhoyNote> = emptyList(),
    val noteOrder: AhoyNoteOrder = AhoyNoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
