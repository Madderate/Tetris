package com.madderate.tetris

sealed interface CellsState
data object Empty : CellsState
data class Put(val cellCount: Int) : CellsState