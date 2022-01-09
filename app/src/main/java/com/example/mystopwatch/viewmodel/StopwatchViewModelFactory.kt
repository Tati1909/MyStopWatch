package com.example.mystopwatch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mystopwatch.model.Stopwatch

/**
 * Поскольку ViewModel должна учитывать жизненный цикл, она должна быть создана с помощью объекта,
 * который может реагировать на события жизненного цикла. Создаем фабрику
 */
class StopwatchViewModelFactory(
    private val stopwatchBuilder: () -> Stopwatch
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(Stopwatch::class.java)
            .newInstance(stopwatchBuilder())
    }
}