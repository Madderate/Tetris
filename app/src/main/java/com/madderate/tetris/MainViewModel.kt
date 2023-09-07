package com.madderate.tetris

import android.app.Application
import android.util.Log
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.madderate.data.Directions
import com.madderate.data.TETRIS_COLUMN_COUNT
import com.madderate.data.TETRIS_ROW_COUNT
import com.madderate.data.Tetris
import com.madderate.data.TetrisCell
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.roundToInt

class MainViewModel(
    application: Application,
    private val savedStateHandle: SavedStateHandle,
) : AndroidViewModel(application) {
    private var isFinished = false

    private val _tetrisState = MutableStateFlow<Tetris?>(null)
    val tetrisState: StateFlow<Tetris?>
        get() = _tetrisState


    init {
        viewModelScope.launch {
            while (true) {
                val existedTetrisCell = tetrisState.value?.cells?.firstOrNull()
                val cell = existedTetrisCell ?: withContext(Dispatchers.Default) {
                    val cellX = (TETRIS_COLUMN_COUNT shr 1).toFloat()
                    TetrisCell(
                        position = Offset(x = cellX, y = -1f),
                        color = Color(red = 0xaf, green = 0xaa, blue = 0x80)
                    )
                }
                val oldPosition = cell.position
                if (oldPosition.y >= TETRIS_ROW_COUNT - 1) {
                    Log.i("GAME", "At Bottom!")
                    isFinished = true
                    break
                }

                val newPositionY = ((oldPosition.y + 1f).roundToInt() % TETRIS_ROW_COUNT).toFloat()
                val newPosition = oldPosition.copy(y = newPositionY)
                val newCell = cell.copy(position = newPosition)
                val newTetris = Tetris(listOf(newCell))
                _tetrisState.value = newTetris
                delay(1000L)
            }
        }
    }


    fun moveTetris(to: Directions) {
        if (isFinished) {
            return
        }

        val oldTetris = tetrisState.value ?: return
        val newTetris = oldTetris.moveCells(to)
        _tetrisState.value = newTetris
    }
}