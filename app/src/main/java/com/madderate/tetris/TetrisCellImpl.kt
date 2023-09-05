package com.madderate.tetris

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.madderate.data.TetrisCell

data class TetrisCellImpl(
    override val position: Offset,
    override val color: Color,
) : TetrisCell
