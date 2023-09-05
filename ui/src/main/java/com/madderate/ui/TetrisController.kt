package com.madderate.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TetrisControllerPreview() {
    TetrisController(modifier = Modifier.fillMaxWidth())
}

@Composable
fun TetrisController(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            modifier = Modifier
                .padding(start = 16.dp, end = 8.dp)
                .fillMaxWidth(0.5f),
            onClick = { /*TODO*/ },
        ) {
            Text(text = "旋转")
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
                onClick = { /*TODO*/ }) {
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
                    onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "下")
                }
            }
            IconButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "右")
            }
        }
    }
}