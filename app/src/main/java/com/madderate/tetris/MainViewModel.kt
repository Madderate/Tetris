package com.madderate.tetris

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.madderate.data.Directions
import com.madderate.data.TETRIS_COLUMN_COUNT
import com.madderate.data.TETRIS_ROW_COUNT
import com.madderate.data.Tetris
import com.madderate.data.TetrisCell
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var isFinished = false
    val stableCells: Array<Array<TetrisCell?>> = Array(TETRIS_COLUMN_COUNT) {
        Array(TETRIS_ROW_COUNT) { null }
    }


    private val _tetrisState = MutableStateFlow(getInitTetris())
    val tetrisState: StateFlow<Tetris>
        get() = _tetrisState


    private val _stableCellsState = MutableStateFlow<CellsState>(Empty)
    val stableCellsState: StateFlow<CellsState>
        get() = _stableCellsState


    init {
        viewModelScope.launch {
            while (!isFinished) {
                delay(1000L)
                val lastTetrisState = tetrisState.value
                if (lastTetrisState.canMoveCells(Directions.Down)) {
                    _tetrisState.value = lastTetrisState.moveCells(Directions.Down)
                } else {
                    putInto(stableCells, lastTetrisState.cells)
                    val lastStableCellsState = stableCellsState.value
                    _stableCellsState.value = when (lastStableCellsState) {
                        Empty -> Put(cellCount = lastTetrisState.cells.count())

                        is Put -> {
                            val lastCount = lastStableCellsState.cellCount
                            Put(cellCount = lastCount + lastTetrisState.cells.count())
                        }
                    }
                    _tetrisState.value = getInitTetris()
                }
            }
        }
    }


    fun moveTetris(to: Directions) {
        if (isFinished) {
            return
        }

        val lastTetrisState = tetrisState.value
        if (lastTetrisState.canMoveCells(to)) {
            _tetrisState.value = lastTetrisState.moveCells(to)
        }
    }
}


private fun putInto(container: Array<Array<TetrisCell?>>, cells: List<TetrisCell>) {
    for (cell in cells) {
        val x = cell.position.x.roundToInt()
        val y = cell.position.y.roundToInt()
        val existedCell = container[x][y]
        val alreadyContainsOne = existedCell != null
        if (alreadyContainsOne) {
            throw IllegalArgumentException("This position($x, $y) is already filled by a cell $existedCell")
        }

        container[x][y] = cell
    }
}