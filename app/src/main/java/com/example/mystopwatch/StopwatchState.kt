package com.example.mystopwatch

/**
 * Определим возможные состояния для нашего секундомера. Их будет всего два:
 * секундомер работает и секундомер на паузе.
 */
sealed class StopwatchState {
    /**
     * Состояние Paused будет содержать только информацию о том, сколько времени прошло (в
    миллисекундах).
     */
    data class Paused(
        val elapsedTime: Long
    ) : StopwatchState()

    /**
     * Состояние Running будет содержать информацию о том, когда секундомер был запущен (в
    миллисекундах) и сколько времени прошло с момента запуска. В момент запуска прошедшее время
    будет == 0. Но каждый раз после паузы это значение будет меняться, чтобы потом мы могли верно
    рассчитать время.
     */
    data class Running(
        val startTime: Long,
        val elapsedTime: Long
    ) : StopwatchState()
}