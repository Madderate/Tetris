package com.madderate.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TetrisControllerPreview() {
    TetrisController(
        modifier = Modifier.fillMaxWidth(),
        moveLeft = {},
        moveRight = {},
        moveDown = {},
    )
}

@Composable
fun TetrisController(
    modifier: Modifier = Modifier,
    moveLeft: () -> Unit,
    moveRight: () -> Unit,
    moveDown: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(1f / 2)
                .padding(start = 16.dp, end = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                modifier = Modifier
                    .fillMaxHeight(1f / 2)
                    .padding(8.dp)
                    .aspectRatio(1f)
                    .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = "顺时针旋转")
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp)
                    .aspectRatio(1f)
                    .graphicsLayer {
                        rotationY = 180f
                    }
                    .background(color = MaterialTheme.colorScheme.secondary, shape = CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                IconButton(
                    modifier = Modifier.fillMaxSize(),
                    onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = "逆时针旋转")
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 16.dp)
                .aspectRatio(1f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                modifier = Modifier
                    .fillMaxWidth(1f / 3),
                onClick = {
                    moveLeft()
                }) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "左")
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(1f / 2),
            ) {
                IconButton(
                    modifier = Modifier.align(Alignment.TopCenter),
                    onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "上")
                }
                IconButton(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    onClick = {
                        moveDown()
                    }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "下")
                }
            }
            IconButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    moveRight()
                }) {
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "右")
            }
        }
    }
}