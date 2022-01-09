package com.example.mystopwatch.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mystopwatch.model.Stopwatch
import kotlinx.coroutines.flow.StateFlow

class StopwatchViewModel(
    private val stopwatch: Stopwatch
) : ViewModel() {

    val ticker: StateFlow<String> = stopwatch.ticker

    fun onStartClicked() {
        stopwatch.start()
    }

    fun onPauseClicked() {
        stopwatch.pause()
    }

    fun onStopClicked() {
        stopwatch.stop()
    }
}