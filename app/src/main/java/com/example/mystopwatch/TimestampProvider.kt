package com.example.mystopwatch

/**
 * Текущее время, нужное для запуска секундомера, мы будем брать через интерфейс.
 * У интерфейса всего одна функция, которая возвращает текущее время (тоже в миллисекундах).
 */
interface TimestampProvider {
    fun getMilliseconds(): Long
}