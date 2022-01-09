package com.example.mystopwatch

/**
 * Вычислять прошедшее время будет класс ElapsedTimeCalculator, который мы передаем вторым
аргументом в наш StopwatchStateCalculator.
Тут всего одна функция, которая вычитает из текущего времени стартовое и выдаёт результат в
миллисекундах. Также она возвращает время, которое прошло в с момента старта (ведь секундомер
могли ставить на паузу несколько раз).
 */
class ElapsedTimeCalculator(
    private val timestampProvider: TimestampProvider,
) {
    fun calculate(state: StopwatchState.Running): Long {
        val currentTimestamp = timestampProvider.getMilliseconds()
        val timePassedSinceStart = if (currentTimestamp > state.startTime) {
            currentTimestamp - state.startTime
        } else {
            0
        }
        return timePassedSinceStart + state.elapsedTime
    }
}