package com.ahoy.testproject.ahoy_note.presentation.main_screen.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ahoy.testproject.ahoy_note.domain.util.AhoyNoteOrder
import com.ahoy.testproject.ahoy_note.domain.util.OrderType


@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: AhoyNoteOrder = AhoyNoteOrder.Date(OrderType.Descending),
    navController: NavController,
    onOrderChange: (AhoyNoteOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomRadioButton(
                text = "Title",
                selected = noteOrder is AhoyNoteOrder.Title,
                onSelect = { onOrderChange(AhoyNoteOrder.Title(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            CustomRadioButton(
                text = "Date",
                selected = noteOrder is AhoyNoteOrder.Date,
                onSelect = { onOrderChange(AhoyNoteOrder.Date(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            CustomRadioButton(
                text = "Color",
                selected = noteOrder is AhoyNoteOrder.Color,
                onSelect = { onOrderChange(AhoyNoteOrder.Color(noteOrder.orderType)) }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomRadioButton(
                text = "Ascending",
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            CustomRadioButton(
                text = "Descending",
                selected = noteOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                }
            )


        }

//        Spacer(modifier = Modifier.height(16.dp))
//        Row(modifier = Modifier.fillMaxWidth()) {
//            Text("See Quote of the day",fontSize = 18.sp)
//
//        }
    }
}