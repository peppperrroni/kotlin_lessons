/**
 * Урок 4: Циклы в Kotlin
 * 
 * В этом уроке мы рассмотрим различные типы циклов в Kotlin и их применение.
 */

fun main() {
    println("Урок 4: Циклы в Kotlin")
    println("======================")
    
    // ======== Цикл for ========
    
    println("\n=== Цикл for ===")
    
    // Цикл for с диапазоном (range)
    println("Цикл с диапазоном 1..5:")
    for (i in 1..5) {
        print("$i ")
    }
    println()
    
    // Цикл for с исключающим диапазоном (until)
    println("\nЦикл с диапазоном 1 until 5:")
    for (i in 1 until 5) {  // 1, 2, 3, 4 (5 не включается)
        print("$i ")
    }
    println()
    
    // Цикл for с убывающим диапазоном (downTo)
    println("\nЦикл с убывающим диапазоном 5 downTo 1:")
    for (i in 5 downTo 1) {  // 5, 4, 3, 2, 1
        print("$i ")
    }
    println()
    
    // Цикл for с шагом (step)
    println("\nЦикл с шагом 2:")
    for (i in 1..10 step 2) {  // 1, 3, 5, 7, 9
        print("$i ")
    }
    println()
    
    // Цикл for с индексами массива
    val fruits = arrayOf("Яблоко", "Банан", "Апельсин", "Груша", "Киви")
    println("\nПеребор массива с индексами:")
    for (i in fruits.indices) {
        println("fruits[$i] = ${fruits[i]}")
    }
    
    // Цикл for с индексом и значением (withIndex)
    println("\nПеребор массива с withIndex:")
    for ((index, value) in fruits.withIndex()) {
        println("fruits[$index] = $value")
    }
    
    // Цикл for для перебора коллекции
    println("\nПеребор коллекции:")
    for (fruit in fruits) {
        println("Фрукт: $fruit")
    }
    
    // ======== Цикл while ========
    
    println("\n=== Цикл while ===")
    
    // Простой цикл while
    var counter = 1
    println("Цикл while от 1 до 5:")
    while (counter <= 5) {
        print("$counter ")
        counter++
    }
    println()
    
    // Пример использования while для поиска
    val numbers = arrayOf(1, 3, 5, 7, 9, 11, 13, 15)
    var index = 0
    val searchValue = 9
    
    println("\nПоиск значения $searchValue в массиве:")
    while (index < numbers.size && numbers[index] != searchValue) {
        index++
    }
    
    if (index < numbers.size) {
        println("Значение $searchValue найдено на позиции $index")
    } else {
        println("Значение $searchValue не найдено")
    }
    
    // ======== Цикл do-while ========
    
    println("\n=== Цикл do-while ===")
    
    // Простой цикл do-while
    counter = 1
    println("Цикл do-while от 1 до 5:")
    do {
        print("$counter ")
        counter++
    } while (counter <= 5)
    println()
    
    // Пример, когда тело цикла выполняется хотя бы один раз
    counter = 10
    println("\nЦикл do-while с начальным значением $counter:")
    do {
        print("$counter ")
        counter++
    } while (counter <= 5)
    println("\nЦикл выполнился один раз, хотя условие изначально не выполнялось")
    
    // ======== Управление циклами ========
    
    println("\n=== Управление циклами ===")
    
    // Оператор break
    println("Использование break для выхода из цикла:")
    for (i in 1..10) {
        if (i == 6) {
            println("Достигнуто значение $i, выход из цикла")
            break
        }
        print("$i ")
    }
    println()
    
    // Оператор continue
    println("\nИспользование continue для пропуска итерации:")
    for (i in 1..10) {
        if (i % 2 == 0) {
            continue  // Пропускаем четные числа
        }
        print("$i ")  // Выводим только нечетные числа
    }
    println()
    
    // Метки (labels) для break и continue
    println("\nИспользование меток (labels):")
    
    outerLoop@ for (i in 1..3) {
        print("i=$i: ")
        
        for (j in 1..3) {
            if (i == 2 && j == 2) {
                println("Выход из внешнего цикла при i=$i, j=$j")
                break@outerLoop  // Выход из внешнего цикла
            }
            print("$j ")
        }
        println()
    }
    println("После вложенных циклов")
    
    // ======== Итерация по коллекциям ========
    
    println("\n=== Итерация по коллекциям ===")
    
    // Итерация по Map
    val capitals = mapOf(
        "Россия" to "Москва",
        "США" to "Вашингтон",
        "Франция" to "Париж",
        "Япония" to "Токио"
    )
    
    println("Итерация по Map:")
    for ((country, capital) in capitals) {
        println("Столица $country - $capital")
    }
    
    // Итерация по List
    val colors = listOf("Красный", "Зеленый", "Синий", "Желтый")
    
    println("\nИтерация по List:")
    for (color in colors) {
        println("Цвет: $color")
    }
    
    // Итерация с использованием forEach
    println("\nИтерация с использованием forEach:")
    colors.forEach { color ->
        println("Цвет: $color")
    }
    
    // Итерация с использованием forEachIndexed
    println("\nИтерация с использованием forEachIndexed:")
    colors.forEachIndexed { index, color ->
        println("colors[$index] = $color")
    }
    
    // ======== Практические примеры ========
    
    println("\n=== Практические примеры ===")
    
    // Пример 1: Вычисление факториала
    val n = 5
    var factorial = 1
    
    for (i in 1..n) {
        factorial *= i
    }
    println("Факториал числа $n = $factorial")
    
    // Пример 2: Вывод таблицы умножения
    println("\nТаблица умножения для числа 7:")
    for (i in 1..10) {
        println("7 × $i = ${7 * i}")
    }
    
    // Пример 3: Поиск простых чисел
    println("\nПростые числа от 2 до 30:")
    outerLoop@ for (num in 2..30) {
        for (divisor in 2 until num) {
            if (num % divisor == 0) {
                // Если число делится нацело, оно не простое
                continue@outerLoop
            }
        }
        // Если мы дошли до этой точки, число простое
        print("$num ")
    }
    println()
    
    // Пример 4: Обработка двумерного массива
    println("\nОбработка двумерного массива:")
    val matrix = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )
    
    for (row in matrix) {
        for (element in row) {
            print("$element\t")
        }
        println()
    }
    
    // Пример 5: Использование repeat
    println("\nИспользование функции repeat:")
    repeat(5) { index ->
        println("Повторение #${index + 1}")
    }
} 