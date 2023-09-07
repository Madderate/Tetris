package com.madderate.data

import androidx.compose.ui.geometry.Offset

data class Tetris(val cells: List<TetrisCell>) {

    fun moveCells(to: Directions): Tetris {
        if (!canMoveCells(to)) {
            throw IllegalStateException("Unable to move! Please check whether this Tetris($this) can move to $to before move cells!")
        }

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

    fun canMoveCells(to: Directions): Boolean = when (to) {
        Directions.Left -> {
            var farLeft = Float.MAX_VALUE
            for (cell in cells) {
                val cellX = cell.position.x
                val isFarLeft = cellX < farLeft
                if (!isFarLeft) continue
                farLeft = cellX
            }
            farLeft > 0f // > 0f: 可以左移；<= 0f：已经在最左边了，不能左移
        }

        Directions.Right -> {
            var farRight = Float.MIN_VALUE
            for (cell in cells) {
                val cellX = cell.position.x
                val isFarRight = cellX > farRight
                if (!isFarRight) continue
                farRight = cellX
            }
            farRight < TETRIS_COLUMN_COUNT - 1
        }

        Directions.Down -> {
            var bottom = Float.MIN_VALUE
            for (cell in cells) {
                val cellY = cell.position.y
                val isDowner = cellY > bottom
                if (!isDowner) continue
                bottom = cellY
            }
            bottom < TETRIS_ROW_COUNT - 1
        }
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