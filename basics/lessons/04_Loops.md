# Урок 4: Циклы в Kotlin

## Введение

Циклы являются одним из фундаментальных элементов программирования, позволяющих выполнять повторяющиеся действия без необходимости дублирования кода. Kotlin предлагает несколько типов циклов, которые обеспечивают гибкость и выразительность при решении различных задач.

В этом уроке мы рассмотрим различные типы циклов в Kotlin, включая `for`, `while`, `do-while`, а также специальные возможности для работы с коллекциями и управления потоком выполнения.

## Цикл for

Цикл `for` в Kotlin используется для итерации по диапазонам, массивам, коллекциям и другим итерируемым объектам.

### Итерация по диапазонам

```kotlin
// Итерация по включающему диапазону (1, 2, 3, 4, 5)
for (i in 1..5) {
    println("Значение i: $i")
}

// Итерация по исключающему диапазону (1, 2, 3, 4)
for (i in 1 until 5) {
    println("Значение i: $i")
}

// Итерация по убывающему диапазону (5, 4, 3, 2, 1)
for (i in 5 downTo 1) {
    println("Значение i: $i")
}

// Итерация с шагом (1, 3, 5, 7, 9)
for (i in 1..10 step 2) {
    println("Значение i: $i")
}
```

### Итерация по массивам и коллекциям

```kotlin
// Итерация по элементам массива
val fruits = arrayOf("Яблоко", "Банан", "Вишня", "Груша")
for (fruit in fruits) {
    println("Фрукт: $fruit")
}

// Итерация с индексами
for (index in fruits.indices) {
    println("Фрукт $index: ${fruits[index]}")
}

// Итерация с индексами и значениями
for ((index, fruit) in fruits.withIndex()) {
    println("Фрукт $index: $fruit")
}
```

## Цикл while

Цикл `while` выполняет блок кода, пока указанное условие истинно. Проверка условия происходит перед каждой итерацией.

```kotlin
// Базовый цикл while
var counter = 1
while (counter <= 5) {
    println("Счетчик: $counter")
    counter++
}

// Поиск элемента в массиве
val numbers = arrayOf(3, 7, 2, 9, 5)
var i = 0
var found = false
val target = 9

while (i < numbers.size && !found) {
    if (numbers[i] == target) {
        found = true
        println("Число $target найдено на позиции $i")
    }
    i++
}

if (!found) {
    println("Число $target не найдено")
}
```

## Цикл do-while

Цикл `do-while` похож на `while`, но проверка условия происходит после выполнения блока кода, что гарантирует выполнение блока хотя бы один раз.

```kotlin
// Базовый цикл do-while
var counter = 1
do {
    println("Счетчик: $counter")
    counter++
} while (counter <= 5)

// Ввод числа с проверкой
var number: Int
do {
    print("Введите положительное число: ")
    number = readLine()?.toIntOrNull() ?: 0
    
    if (number <= 0) {
        println("Ошибка: число должно быть положительным")
    }
} while (number <= 0)

println("Вы ввели: $number")
```

## Управление циклами: break и continue

Kotlin предоставляет операторы `break` и `continue` для управления выполнением циклов.

### Оператор break

Оператор `break` прерывает выполнение цикла и передает управление на следующую после цикла инструкцию.

```kotlin
// Прерывание цикла при определенном условии
for (i in 1..10) {
    if (i == 5) {
        println("Достигнуто значение 5, выход из цикла")
        break
    }
    println("Значение i: $i")
}

// Поиск первого четного числа
val numbers = arrayOf(7, 3, 9, 4, 5, 2)
for (number in numbers) {
    if (number % 2 == 0) {
        println("Найдено первое четное число: $number")
        break
    }
}
```

### Оператор continue

Оператор `continue` пропускает оставшуюся часть текущей итерации и переходит к следующей.

```kotlin
// Пропуск четных чисел
for (i in 1..10) {
    if (i % 2 == 0) {
        continue
    }
    println("Нечетное число: $i")
}

// Фильтрация строк
val words = arrayOf("apple", "", "banana", "  ", "cherry")
for (word in words) {
    if (word.isBlank()) {
        continue
    }
    println("Слово: $word")
}
```

### Метки (Labels) для break и continue

Kotlin позволяет использовать метки для указания, к какому циклу применяются операторы `break` и `continue` в случае вложенных циклов.

```kotlin
// Использование метки для break
outerLoop@ for (i in 1..3) {
    for (j in 1..3) {
        if (i == 2 && j == 2) {
            println("Выход из внешнего цикла при i=$i, j=$j")
            break@outerLoop
        }
        println("i=$i, j=$j")
    }
}

// Использование метки для continue
outerLoop@ for (i in 1..3) {
    for (j in 1..3) {
        if (i == 2 && j == 2) {
            println("Переход к следующей итерации внешнего цикла при i=$i, j=$j")
            continue@outerLoop
        }
        println("i=$i, j=$j")
    }
}
```

## Итерация по коллекциям

Kotlin предоставляет удобные способы для итерации по различным типам коллекций.

### Итерация по Map

```kotlin
val capitals = mapOf(
    "Россия" to "Москва",
    "США" to "Вашингтон",
    "Франция" to "Париж",
    "Япония" to "Токио"
)

// Итерация по ключам и значениям
for ((country, capital) in capitals) {
    println("Столица $country - $capital")
}

// Итерация только по ключам
for (country in capitals.keys) {
    println("Страна: $country")
}

// Итерация только по значениям
for (capital in capitals.values) {
    println("Столица: $capital")
}
```

### Итерация по List с использованием функциональных методов

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

// Использование forEach
numbers.forEach { number ->
    println("Число: $number")
}

// Использование forEachIndexed
numbers.forEachIndexed { index, number ->
    println("Число на позиции $index: $number")
}
```

## Функция repeat

Kotlin предоставляет функцию `repeat`, которая позволяет выполнить блок кода указанное количество раз.

```kotlin
// Повторение действия 5 раз
repeat(5) {
    println("Повторение #${it + 1}")
}

// Использование индекса итерации
repeat(3) { index ->
    println("Индекс: $index")
}
```

## Практические примеры

### Вычисление факториала

```kotlin
fun factorial(n: Int): Long {
    var result = 1L
    for (i in 1..n) {
        result *= i
    }
    return result
}

val n = 5
println("Факториал числа $n: ${factorial(n)}") // 120
```

### Таблица умножения

```kotlin
fun multiplicationTable(size: Int) {
    for (i in 1..size) {
        for (j in 1..size) {
            print("${i * j}\t")
        }
        println()
    }
}

println("Таблица умножения 5x5:")
multiplicationTable(5)
```

### Поиск простых чисел

```kotlin
fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    if (n <= 3) return true
    
    if (n % 2 == 0 || n % 3 == 0) return false
    
    var i = 5
    while (i * i <= n) {
        if (n % i == 0 || n % (i + 2) == 0) return false
        i += 6
    }
    
    return true
}

fun findPrimes(start: Int, end: Int): List<Int> {
    val primes = mutableListOf<Int>()
    for (i in start..end) {
        if (isPrime(i)) {
            primes.add(i)
        }
    }
    return primes
}

val primes = findPrimes(10, 50)
println("Простые числа от 10 до 50: $primes")
```

### Обработка двумерного массива

```kotlin
fun processMatrix(matrix: Array<Array<Int>>) {
    // Вывод матрицы
    for (row in matrix) {
        for (element in row) {
            print("$element\t")
        }
        println()
    }
    
    // Сумма элементов по диагонали
    var diagonalSum = 0
    for (i in matrix.indices) {
        diagonalSum += matrix[i][i]
    }
    println("Сумма элементов по диагонали: $diagonalSum")
    
    // Максимальный элемент в каждой строке
    for ((i, row) in matrix.withIndex()) {
        val maxInRow = row.maxOrNull() ?: 0
        println("Максимальный элемент в строке $i: $maxInRow")
    }
}

val matrix = arrayOf(
    arrayOf(1, 2, 3),
    arrayOf(4, 5, 6),
    arrayOf(7, 8, 9)
)
processMatrix(matrix)
```

## Заключение

В этом уроке мы рассмотрели различные типы циклов в Kotlin и их применение для решения разнообразных задач.

Ключевые особенности циклов в Kotlin:
- Цикл `for` для итерации по диапазонам, массивам и коллекциям
- Циклы `while` и `do-while` для выполнения кода, пока условие истинно
- Операторы `break` и `continue` для управления выполнением циклов
- Метки для управления вложенными циклами
- Функциональные методы для итерации по коллекциям
- Функция `repeat` для простого повторения блока кода

Понимание циклов и их эффективное использование является важной частью разработки на Kotlin, позволяя создавать более чистый и выразительный код. 