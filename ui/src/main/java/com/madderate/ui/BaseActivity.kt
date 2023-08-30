package com.madderate.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.view.WindowCompat

open class BaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.let {
            WindowCompat.setDecorFitsSystemWindows(it, false)
        }
    }
}