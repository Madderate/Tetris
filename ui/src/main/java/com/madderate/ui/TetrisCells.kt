package com.madderate.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.madderate.data.Directions
import com.madderate.data.Tetris
import com.madderate.data.TetrisCell

private data class TempTetrisImpl(
    override val cells: List<TetrisCell>
) : Tetris {
    override fun moveCells(to: Directions): Tetris {
        TODO("No need to implement")
    }
}

private data class TempTetrisCellImpl(
    override val position: Offset = Offset(0f, 0f),
    override val color: Color = Color.Yellow,
) : TetrisCell


@Preview(showSystemUi = true)
@Composable
fun TetrisCellsPreview() {
    val tetrisCells = listOf(
        TempTetrisCellImpl()
    )
    val tetris = TempTetrisImpl(tetrisCells)
    TetrisCells(
        modifier = Modifier.fillMaxWidth(),
        rowCount = 22,
        columnCount = 12,
        tetris = tetris
    )
}

@Composable
fun TetrisCells(
    modifier: Modifier = Modifier,
    rowCount: Int,
    columnCount: Int,
    tetris: Tetris?
) {
    if (tetris == null) {
        return
    }

    Box(modifier = modifier) {
        val canvasRatio = columnCount.toFloat() / rowCount
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(canvasRatio),
        ) {
            val cellSize = getCellSizeOrThrowWith(rowCount = rowCount, columnCount = columnCount)
            for (cell in tetris.cells) {
                val (x, y) = cell.position
                drawRect(
                    color = cell.color,
                    topLeft = Offset(x * cellSize, y * cellSize),
                    size = Size(cellSize, cellSize),
                )
            }
        }
    }
}