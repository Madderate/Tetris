package com.madderate.ui

import androidx.compose.ui.graphics.drawscope.DrawScope

@Throws(IllegalStateException::class)
internal fun DrawScope.getCellSizeOrThrowWith(rowCount: Int, columnCount: Int): Float {
    val (width, height) = size
    val cellSize = width / columnCount
    val cellSizeForCheck = height / rowCount
    val hasCorrectSize = cellSize == cellSizeForCheck
    check(hasCorrectSize) {
        "Incorrect size! width=$width, height=$height, but cellSize=$cellSize, cellSizeForCheck=$cellSizeForCheck"
    }
    return cellSize
}