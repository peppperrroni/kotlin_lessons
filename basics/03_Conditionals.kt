/**
 * Урок 3: Условные выражения в Kotlin
 * 
 * В этом уроке мы рассмотрим различные условные выражения и конструкции в Kotlin.
 */

fun main() {
    println("Урок 3: Условные выражения в Kotlin")
    println("===================================")
    
    // ======== Оператор if-else ========
    
    println("\n=== Оператор if-else ===")
    
    val number = 42
    
    // Простое условие if
    if (number > 0) {
        println("Число $number положительное")
    }
    
    // Условие if-else
    if (number % 2 == 0) {
        println("Число $number четное")
    } else {
        println("Число $number нечетное")
    }
    
    // Цепочка if-else-if
    if (number < 0) {
        println("Число $number отрицательное")
    } else if (number == 0) {
        println("Число равно нулю")
    } else {
        println("Число $number положительное")
    }
    
    // ======== if как выражение ========
    
    println("\n=== if как выражение ===")
    
    // В Kotlin if является выражением и возвращает значение
    val max = if (5 > 3) 5 else 3
    println("Максимальное значение: $max")
    
    // Более сложный пример
    val temperature = 25
    val description = if (temperature < 0) {
        "Очень холодно"
    } else if (temperature < 10) {
        "Холодно"
    } else if (temperature < 20) {
        "Прохладно"
    } else if (temperature < 30) {
        "Тепло"
    } else {
        "Жарко"
    }
    println("При температуре $temperature°C: $description")
    
    // ======== Выражение when ========
    
    println("\n=== Выражение when ===")
    
    // when - это более мощная версия switch из других языков
    val day = 3
    
    when (day) {
        1 -> println("Понедельник")
        2 -> println("Вторник")
        3 -> println("Среда")
        4 -> println("Четверг")
        5 -> println("Пятница")
        6, 7 -> println("Выходной")
        else -> println("Некорректный день")
    }
    
    // when как выражение
    val dayType = when (day) {
        1, 2, 3, 4, 5 -> "Рабочий день"
        6, 7 -> "Выходной"
        else -> "Некорректный день"
    }
    println("День $day - это $dayType")
    
    // when с произвольными выражениями
    val x = 42
    when {
        x < 0 -> println("Отрицательное число")
        x == 0 -> println("Ноль")
        x % 2 == 0 -> println("Четное положительное число")
        else -> println("Нечетное положительное число")
    }
    
    // when с проверкой типа (Smart Cast)
    val obj: Any = "Привет"
    
    when (obj) {
        is String -> println("Это строка длиной ${obj.length}")
        is Int -> println("Это целое число: $obj")
        is Double -> println("Это число с плавающей точкой: $obj")
        else -> println("Неизвестный тип")
    }
    
    // when с диапазонами
    val score = 85
    
    val grade = when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        in 0..59 -> "F"
        else -> "Некорректная оценка"
    }
    println("Оценка для $score баллов: $grade")
    
    // ======== Безопасный вызов (?.) и оператор Elvis (?:) ========
    
    println("\n=== Безопасный вызов и оператор Elvis ===")
    
    // Работа с null-безопасностью
    val nullableString: String? = null
    val nonNullString: String? = "Привет"
    
    // Безопасный вызов (Safe Call)
    println("Длина nullableString: ${nullableString?.length}") // Выведет null
    println("Длина nonNullString: ${nonNullString?.length}") // Выведет 6
    
    // Оператор Elvis
    val length1 = nullableString?.length ?: 0
    val length2 = nonNullString?.length ?: 0
    
    println("Длина nullableString (с Elvis): $length1") // Выведет 0
    println("Длина nonNullString (с Elvis): $length2") // Выведет 6
    
    // ======== Оператор !! ========
    
    println("\n=== Оператор !! ===")
    
    // Оператор !! преобразует nullable тип в non-null и выбрасывает исключение, если значение null
    try {
        // Это вызовет исключение, так как nullableString равен null
        // val length = nullableString!!.length
        // println("Это не будет выведено")
        
        // Безопасный пример
        val length = nonNullString!!.length
        println("Длина nonNullString (с !!): $length")
    } catch (e: NullPointerException) {
        println("Поймано исключение: ${e.message}")
    }
    
    // ======== Практические примеры ========
    
    println("\n=== Практические примеры ===")
    
    // Пример 1: Проверка возраста
    val age = 20
    
    if (age < 18) {
        println("Несовершеннолетний")
    } else if (age < 65) {
        println("Взрослый")
    } else {
        println("Пенсионер")
    }
    
    // Пример 2: Определение времени суток
    val hour = 14
    
    val timeOfDay = when (hour) {
        in 6..11 -> "Утро"
        in 12..17 -> "День"
        in 18..22 -> "Вечер"
        else -> "Ночь"
    }
    println("Время суток для $hour часов: $timeOfDay")
    
    // Пример 3: Проверка строки
    val input = "Kotlin"
    
    when {
        input.isEmpty() -> println("Строка пуста")
        input.length == 1 -> println("Строка содержит один символ")
        input.length > 10 -> println("Длинная строка")
        input == "Kotlin" -> println("Это Kotlin!")
        else -> println("Обычная строка")
    }
    
    // Пример 4: Комбинирование условий
    val isWeekend = day == 6 || day == 7
    val isHoliday = false
    
    if (isWeekend || isHoliday) {
        println("Можно отдыхать!")
    } else {
        println("Рабочий день")
    }
}
