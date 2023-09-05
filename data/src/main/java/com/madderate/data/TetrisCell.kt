package com.madderate.data

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

interface TetrisCell {
    val position : Offset
    val color: Color
}