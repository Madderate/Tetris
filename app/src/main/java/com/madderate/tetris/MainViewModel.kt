package com.madderate.tetris

import android.app.Application
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
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
    private val _tetris = MutableStateFlow<TetrisImpl?>(null)
    val tetris: StateFlow<TetrisImpl?>
        get() = _tetris


    init {
        viewModelScope.launch {
            while (true) {
                val cell = tetris.value?.cells?.firstOrNull() ?: withContext(Dispatchers.Default) {
                    TetrisCellImpl(
                        position = Offset(-1f, -1f),
                        color = Color(red = 0xaf, green = 0xaa, blue = 0x80)
                    )
                }
                val oldPosition = cell.position
                val newPosition = oldPosition.copy(
                    x = ((oldPosition.x + 1f).roundToInt() % TETRIS_COLUMN_COUNT).toFloat(),
                    y = ((oldPosition.y + 1f).roundToInt() % TETRIS_ROW_COUNT).toFloat(),
                )
                val newCell = (cell as TetrisCellImpl).copy(position = newPosition)
                val newTetris = TetrisImpl(listOf(newCell))
                _tetris.value = newTetris
                delay(1000L)
            }
        }
    }
}