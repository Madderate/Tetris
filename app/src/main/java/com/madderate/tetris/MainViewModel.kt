package com.madderate.tetris

import android.app.Application
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    application: Application,
    private val savedStateHandle: SavedStateHandle,
) : AndroidViewModel(application) {
    private val _tetris = MutableStateFlow<TetrisImpl?>(null)
    val tetris: StateFlow<TetrisImpl?>
        get() = _tetris


    init {
        viewModelScope.launch {
            val tetrisCellImplList = withContext(Dispatchers.Default) {
                val cell = TetrisCellImpl(
                    position = Offset(0f, 0f),
                    color = Color(red = 0xaf, green = 0xaa, blue = 0x80)
                )
                listOf(cell)
            }
            val tetrisImpl = TetrisImpl(tetrisCellImplList)
            _tetris.value = tetrisImpl
        }
    }
}