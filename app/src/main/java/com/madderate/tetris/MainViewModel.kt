package com.madderate.tetris

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.madderate.data.Directions
import com.madderate.data.Tetris
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var isFinished = false

    private val _tetrisState = MutableStateFlow(getInitTetris())
    val tetrisState: StateFlow<Tetris>
        get() = _tetrisState


    init {
        viewModelScope.launch {
            while (!isFinished) {
                delay(1000L)
                val lastTetrisState = tetrisState.value
                if (lastTetrisState.canMoveCells(Directions.Down)) {
                    _tetrisState.value = lastTetrisState.moveCells(Directions.Down)
                } else {
                    isFinished = true
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