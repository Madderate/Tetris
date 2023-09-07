package com.madderate.tetris

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.madderate.data.TETRIS_COLUMN_COUNT
import com.madderate.data.Tetris
import com.madderate.data.TetrisCell
import com.madderate.data.TetrisShape

internal fun getInitTetris(): Tetris {
    val centerIndex = TETRIS_COLUMN_COUNT shr 1

    val cells = when (TetrisShape.entries.random()) {
        TetrisShape.I -> getInitICells(centerIndex)
        TetrisShape.L -> getInitLCells(centerIndex)
        TetrisShape.T -> getInitTCells(centerIndex)
        TetrisShape.J -> getInitJCells(centerIndex)
        TetrisShape.Z -> getInitZCells(centerIndex)
        TetrisShape.S -> getInitSCells(centerIndex)
        TetrisShape.O -> getInitOCells(centerIndex)
    }
    return Tetris(cells)
}

private fun getInitICells(centerIndex: Int): List<TetrisCell> {
    val color = Color(red = 93, green = 202, blue = 204)
    return listOf(
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 2f, 0f),
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 1f, 0f),
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex.toFloat(), 0f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex + 1f, 0f),
        )
    )
}

private fun getInitLCells(centerIndex: Int): List<TetrisCell> {
    val color = Color(red = 192, green = 108, blue = 39)
    return listOf(
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 2f, 1f),
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 1f, 1f),
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex.toFloat(), 1f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex.toFloat(), 0f)
        )
    )
}

private fun getInitTCells(centerIndex: Int): List<TetrisCell> {
    val color = Color(red = 141, green = 27, blue = 198)
    return listOf(
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 2f, 1f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 1f, 1f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex.toFloat(), 1f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 1f, 0f)
        )
    )
}

private fun getInitJCells(centerIndex: Int): List<TetrisCell> {
    val color = Color(red = 0, green = 0, blue = 197)
    return listOf(
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 2f, 0f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 2f, 1f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 1f, 1f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex.toFloat(), 1f)
        )
    )
}

fun getInitZCells(centerIndex: Int): List<TetrisCell> {
    val color = Color(red = 188, green = 39, blue = 26)
    return listOf(
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 2f, 0f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 1f, 0f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 1f, 1f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex.toFloat(), 1f)
        ),
    )
}

fun getInitSCells(centerIndex: Int): List<TetrisCell> {
    val color = Color(red = 93, green = 202, blue = 59)
    return listOf(
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 2f, 1f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 1f, 1f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 1f, 0f)
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex.toFloat(), 0f)
        ),
    )
}

fun getInitOCells(centerIndex: Int): List<TetrisCell> {
    val color = Color(red = 205, green = 205, blue = 66)
    return listOf(
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 1f, 0f),
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex.toFloat(), 0f),
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex - 1f, 1f),
        ),
        TetrisCell(
            color = color,
            position = Offset(centerIndex.toFloat(), 1f),
        ),
    )
}
