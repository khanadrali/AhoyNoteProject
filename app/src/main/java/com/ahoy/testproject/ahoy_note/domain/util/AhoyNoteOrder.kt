package com.ahoy.testproject.ahoy_note.domain.util

sealed class AhoyNoteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): AhoyNoteOrder(orderType)
    class Date(orderType: OrderType): AhoyNoteOrder(orderType)
    class Color(orderType: OrderType): AhoyNoteOrder(orderType)

    fun copy(orderType: OrderType): AhoyNoteOrder {
        return when(this) {
            is Title -> Title(orderType)
            is Date -> Date(orderType)
            is Color -> Color(orderType)
        }
    }
}
