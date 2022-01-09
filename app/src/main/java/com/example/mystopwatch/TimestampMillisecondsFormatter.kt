package com.example.mystopwatch

/**
 * Класс, который переводит миллисекунды в понятный формат.
 * Тут мы просто делим значение в миллисекундах на 1000 или на 60 без остатка. Если время на
секундомере меньше часа, то мы отображаем минуты, секунды и миллисекунды. Если больше —
отображаем часы, минуты и секунды.
 */
class TimestampMillisecondsFormatter() {

    fun format(timestamp: Long): String {
        val millisecondsFormatted = (timestamp % 1000).pad(3)
        val seconds = timestamp / 1000
        val secondsFormatted = (seconds % 60).pad(2)
        val minutes = seconds / 60
        val minutesFormatted = (minutes % 60).pad(2)
        val hours = minutes / 60

        return if (hours > 0) {
            val hoursFormatted = (minutes / 60).pad(2)
            "$hoursFormatted:$minutesFormatted:$secondsFormatted"
        } else {
            "$minutesFormatted:$secondsFormatted:$millisecondsFormatted"
        }
    }

    /**
     * Функция-расширение Long.pad, которую мы написали сами. Благодаря этому
    простому и изящному решению мы просто отображаем нужное
    количество нулей для каждого параметра, обращаясь напрямую к типу Long.

    padStart дополняет строку до указанной длины в начале указанным символом или пробелом.
    Параметры:
    length - желаемая длина строки.
    padChar - символ, которым дополняется строка, если ее длина меньше указанной длины.
     */
    private fun Long.pad(desiredLength: Int) =
        this.toString().padStart(desiredLength, '0')

    companion object {
        const val DEFAULT_TIME = "00:00:000"
    }
}