package com.ahoy.testproject.ahoy_note.presentation.util

sealed class AhoyScreen(val route: String) {
    object AhoyMainScreen: AhoyScreen("ahoy_note_main_screen")
    object AddEditNoteScreen: AhoyScreen("ahoy_notes_screen")
}
