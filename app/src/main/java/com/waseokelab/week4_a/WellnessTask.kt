package com.waseokelab.week4_a

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class WellnessTask(
    val id: Int,
    val label: String,
    val checked: Boolean = false,
)
