package com.madderate.data

import androidx.compose.ui.geometry.Offset

data class Tetris(val cells: List<TetrisCell>) {

    fun moveCells(to: Directions): Tetris {
        val newCells = cells.map {
            val oldPosition = it.position
            val newPosition = when (to) {
                Directions.Left -> oldPosition.left()
                Directions.Right -> oldPosition.right()
                Directions.Down -> oldPosition.down()
            }
            it.copy(position = newPosition)
        }
        return Tetris(newCells)
    }
}

private fun Offset.left(): Offset {
    val newX = if (x > 0) x - 1 else 0f
    return copy(x = newX)
}

private fun Offset.right(): Offset {
    val maxX = (TETRIS_COLUMN_COUNT - 1).toFloat()
    val newX = if (x < maxX) x + 1f else maxX
    return copy(x = newX)
}

private fun Offset.down(): Offset {
    val maxY = (TETRIS_ROW_COUNT - 1).toFloat()
    val newPositionY = if (y < maxY) y + 1f else maxY
    return copy(y = newPositionY)
}