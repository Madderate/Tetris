package com.madderate.tetris

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madderate.data.Directions
import com.madderate.ui.BaseActivity
import com.madderate.ui.TetrisBackground
import com.madderate.ui.TetrisCells
import com.madderate.ui.TetrisController
import com.madderate.ui.theme.TetrisTheme

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TetrisTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        val mainViewModel: MainViewModel = viewModel()
                        val tetris by mainViewModel.tetrisState.collectAsState()
                        Box(
                            modifier = Modifier
                                .statusBarsPadding()
                                .padding(top = 16.dp)
                                .fillMaxWidth(0.8f)
                                .wrapContentHeight(),
                        ) {
                            TetrisBackground(
                                modifier = Modifier.fillMaxWidth(),
                                rowCount = TETRIS_ROW_COUNT,
                                columnCount = TETRIS_COLUMN_COUNT,
                            )
                            TetrisCells(
                                modifier = Modifier.fillMaxWidth(),
                                rowCount = TETRIS_ROW_COUNT,
                                columnCount = TETRIS_COLUMN_COUNT,
                                tetris = tetris,
                            )
                        }
                        TetrisController(
                            modifier = Modifier
                                .fillMaxSize()
                                .navigationBarsPadding(),
                            moveLeft = {
                                mainViewModel.moveTetris(Directions.Left)
                            },
                            moveRight = {
                                mainViewModel.moveTetris(Directions.Right)
                            },
                            moveDown = {
                                mainViewModel.moveTetris(Directions.Down)
                            }
                        )
                    }
                }
            }
        }
    }
}
