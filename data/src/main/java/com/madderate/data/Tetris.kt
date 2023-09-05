package com.madderate.data

interface Tetris {
    val cells: List<TetrisCell>
    fun moveCells(to: Directions): Tetris
}