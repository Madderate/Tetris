package com.madderate.ui

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun TetrisBackgroundPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TetrisBackground(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(0.8f)
        )
    }
}

@Composable
fun TetrisBackground(
    modifier: Modifier = Modifier,
    lineCount: Int = 22,
    rowCount: Int = 12,
) {
    Box(modifier = modifier) {
        val canvasRatio = rowCount.toFloat() / lineCount
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = canvasRatio),
        ) {
            val (width, height) = size
            val cellSize = width / rowCount
            val cellSizeForCheck = height / lineCount
            val hasCorrectSize = cellSize == cellSizeForCheck
            check(hasCorrectSize) {
                "Incorrect size! width=$width, height=$height, but cellSize=$cellSize, cellSizeForCheck=$cellSizeForCheck"
            }

            for (i in 0..lineCount) {
                val gapSize = cellSize * i
                drawLine(
                    canvasWidth = width,
                    canvasHeight = height,
                    horizontal = true,
                    gapSize = gapSize
                )
            }
            for (i in 0..rowCount) {
                val gapSize = cellSize * i
                drawLine(
                    canvasWidth = width,
                    canvasHeight = height,
                    horizontal = false,
                    gapSize = gapSize,
                )
            }
        }
    }
}

private fun DrawScope.drawLine(
    canvasWidth: Float,
    canvasHeight: Float,
    horizontal: Boolean,
    gapSize: Float,
) {
    Log.i(
        "TetrisBackground",
        "drawLine: canvasWidth=$canvasWidth, canvasHeight=$canvasHeight, horizontal=$horizontal, gapSize=$gapSize"
    )
    val (startOffset, endOffset) = if (horizontal) {
        Offset(0f, gapSize) to Offset(canvasWidth, gapSize)
    } else {
        Offset(gapSize, 0f) to Offset(gapSize, canvasHeight)
    }
    drawLine(color = Color.Gray, start = startOffset, end = endOffset)
}
