package com.example.mystopwatch

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.mystopwatch.di.StopwatchModule
import com.example.mystopwatch.viewmodel.StopwatchViewModelFactory

class App : Application() {
    private val stopwatchModule = StopwatchModule()

    val stopwatchViewModelFactory by lazy {
        StopwatchViewModelFactory { stopwatchModule.getStopwatch() }
    }
}

val Fragment.app: App
    get() = requireActivity().application as App