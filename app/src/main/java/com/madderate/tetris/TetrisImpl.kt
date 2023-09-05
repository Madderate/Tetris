package com.madderate.tetris

import com.madderate.data.Tetris
import com.madderate.data.TetrisCell

data class TetrisImpl(
    override val cells: List<TetrisCell>,
) : Tetris
