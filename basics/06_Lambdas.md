# Урок 6: Лямбда-выражения в Kotlin

## Введение

Лямбда-выражения (или просто лямбды) — это анонимные функции, которые можно передавать как значения. Они являются одной из ключевых особенностей функционального программирования в Kotlin, позволяя писать более краткий и выразительный код.

В этом уроке мы рассмотрим синтаксис и применение лямбда-выражений в Kotlin, а также связанные с ними концепции, такие как функции высшего порядка, замыкания и ссылки на функции.

## Основы лямбда-выражений

### Синтаксис лямбда-выражений

Лямбда-выражение в Kotlin имеет следующий синтаксис:

```kotlin
val lambda: (ТипПараметра1, ТипПараметра2, ...) -> ТипВозвращаемогоЗначения = { параметр1, параметр2, ... -> 
    // Тело лямбда-выражения
    // Последнее выражение является возвращаемым значением
}
```

### Простые примеры лямбда-выражений

```kotlin
// Лямбда без параметров
val sayHello: () -> Unit = { println("Привет, мир!") }
sayHello() // Выведет: "Привет, мир!"

// Лямбда с одним параметром
val square: (Int) -> Int = { x -> x * x }
println(square(5)) // Выведет: 25

// Лямбда с несколькими параметрами
val sum: (Int, Int) -> Int = { a, b -> a + b }
println(sum(3, 4)) // Выведет: 7
```

### Вывод типов в лямбда-выражениях

Kotlin может автоматически выводить типы параметров и возвращаемого значения лямбда-выражения:

```kotlin
// Тип выводится из контекста
val square = { x: Int -> x * x }
println(square(5)) // Выведет: 25

// Тип выводится из объявления переменной
val sum: (Int, Int) -> Int = { a, b -> a + b }
println(sum(3, 4)) // Выведет: 7
```

### Лямбда-выражения без параметров

```kotlin
val printHello: () -> Unit = { println("Привет!") }
printHello() // Выведет: "Привет!"
```

### Лямбда-выражения с одним параметром

Для лямбда-выражений с одним параметром Kotlin предоставляет сокращенный синтаксис с использованием ключевого слова `it`:

```kotlin
// Полный синтаксис
val square: (Int) -> Int = { x -> x * x }

// Сокращенный синтаксис с it
val squareIt: (Int) -> Int = { it * it }

println(square(5)) // Выведет: 25
println(squareIt(5)) // Выведет: 25
```

## Лямбда-выражения и коллекции

Лямбда-выражения особенно полезны при работе с коллекциями, позволяя кратко и выразительно описывать операции над элементами.

### Фильтрация элементов

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// Фильтрация четных чисел
val evenNumbers = numbers.filter { it % 2 == 0 }
println(evenNumbers) // Выведет: [2, 4, 6, 8, 10]

// Фильтрация чисел больше 5
val largeNumbers = numbers.filter { it > 5 }
println(largeNumbers) // Выведет: [6, 7, 8, 9, 10]
```

### Преобразование элементов

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

// Возведение в квадрат
val squares = numbers.map { it * it }
println(squares) // Выведет: [1, 4, 9, 16, 25]

// Преобразование в строки
val strings = numbers.map { "Число: $it" }
println(strings) // Выведет: [Число: 1, Число: 2, Число: 3, Число: 4, Число: 5]
```

### Комбинирование операций

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// Фильтрация и преобразование
val squaresOfEven = numbers
    .filter { it % 2 == 0 }
    .map { it * it }
println(squaresOfEven) // Выведет: [4, 16, 36, 64, 100]

// Фильтрация, преобразование и агрегация
val sumOfSquaresOfEven = numbers
    .filter { it % 2 == 0 }
    .map { it * it }
    .sum()
println(sumOfSquaresOfEven) // Выведет: 220
```

### Сортировка с использованием лямбда-выражений

```kotlin
val words = listOf("apple", "banana", "cherry", "date", "elderberry")

// Сортировка по длине строки
val sortedByLength = words.sortedBy { it.length }
println(sortedByLength) // Выведет: [date, apple, cherry, banana, elderberry]

// Сортировка по последней букве
val sortedByLastLetter = words.sortedBy { it.last() }
println(sortedByLastLetter) // Выведет: [banana, apple, date, cherry, elderberry]

// Обратная сортировка
val sortedDescending = words.sortedByDescending { it.length }
println(sortedDescending) // Выведет: [elderberry, banana, cherry, apple, date]
```

## Замыкания (Closures)

Лямбда-выражения в Kotlin могут захватывать и использовать переменные из внешнего контекста, что называется замыканием:

```kotlin
fun createCounter(): () -> Int {
    var count = 0
    return {
        count++
        count
    }
}

val counter = createCounter()
println(counter()) // Выведет: 1
println(counter()) // Выведет: 2
println(counter()) // Выведет: 3

// Создание нового счетчика
val counter2 = createCounter()
println(counter2()) // Выведет: 1 (независимый счетчик)
```

В этом примере лямбда-выражение захватывает переменную `count` из внешней функции и сохраняет ее состояние между вызовами.

## Функции высшего порядка

Функции высшего порядка — это функции, которые принимают другие функции в качестве параметров или возвращают функции:

```kotlin
// Функция, принимающая функцию в качестве параметра
fun applyOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// Использование с различными лямбда-выражениями
val sum = applyOperation(5, 3) { x, y -> x + y }
println("Сумма: $sum") // Выведет: "Сумма: 8"

val product = applyOperation(5, 3) { x, y -> x * y }
println("Произведение: $product") // Выведет: "Произведение: 15"

val max = applyOperation(5, 3) { x, y -> if (x > y) x else y }
println("Максимум: $max") // Выведет: "Максимум: 5"
```

### Возвращение функций

```kotlin
// Функция, возвращающая функцию
fun createMultiplier(factor: Int): (Int) -> Int {
    return { number -> number * factor }
}

val double = createMultiplier(2)
val triple = createMultiplier(3)

println(double(5)) // Выведет: 10
println(triple(5)) // Выведет: 15
```

## Возврат из лямбда-выражений

В Kotlin есть несколько способов возврата из лямбда-выражений:

### Локальный возврат

По умолчанию оператор `return` в лямбда-выражении возвращает значение из самой лямбды:

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

// Преобразование с использованием локального возврата
val transformed = numbers.map { number ->
    if (number % 2 == 0) {
        return@map "Четное: $number"
    } else {
        return@map "Нечетное: $number"
    }
}

println(transformed) // Выведет: [Нечетное: 1, Четное: 2, Нечетное: 3, Четное: 4, Нечетное: 5]
```

### Нелокальный возврат

Оператор `return` без метки в лямбда-выражении возвращает значение из ближайшей функции, содержащей лямбду:

```kotlin
fun findFirstEven(numbers: List<Int>): Int? {
    numbers.forEach { number ->
        if (number % 2 == 0) {
            return number // Возврат из функции findFirstEven, а не из лямбды
        }
    }
    return null
}

val result = findFirstEven(listOf(1, 3, 5, 6, 7, 8))
println(result) // Выведет: 6
```

## Ссылки на функции

Kotlin позволяет использовать ссылки на существующие функции вместо лямбда-выражений:

```kotlin
// Обычная функция
fun isEven(number: Int): Boolean {
    return number % 2 == 0
}

val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// Использование лямбда-выражения
val evenNumbers1 = numbers.filter { it % 2 == 0 }

// Использование ссылки на функцию
val evenNumbers2 = numbers.filter(::isEven)

println(evenNumbers1) // Выведет: [2, 4, 6, 8, 10]
println(evenNumbers2) // Выведет: [2, 4, 6, 8, 10]
```

### Ссылки на методы объекта

```kotlin
class StringProcessor {
    fun isLong(str: String): Boolean {
        return str.length > 5
    }
}

val processor = StringProcessor()
val strings = listOf("a", "abc", "abcdef", "abcdefghi")

// Использование ссылки на метод объекта
val longStrings = strings.filter(processor::isLong)
println(longStrings) // Выведет: [abcdef, abcdefghi]
```

### Ссылки на конструкторы

```kotlin
data class Person(val name: String, val age: Int)

val names = listOf("Alice", "Bob", "Charlie")
val ages = listOf(25, 30, 35)

// Создание списка объектов Person с использованием ссылки на конструктор
val people = names.zip(ages).map { (name, age) -> Person(name, age) }
// Эквивалентно:
val people2 = names.zip(ages).map(::Person)

println(people) // Выведет: [Person(name=Alice, age=25), Person(name=Bob, age=30), Person(name=Charlie, age=35)]
println(people2) // Выведет: [Person(name=Alice, age=25), Person(name=Bob, age=30), Person(name=Charlie, age=35)]
```

## Встроенные функции с лямбда-выражениями

Kotlin предоставляет множество встроенных функций, которые принимают лямбда-выражения:

### forEach

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

numbers.forEach { number ->
    println("Число: $number")
}
// Выведет:
// Число: 1
// Число: 2
// Число: 3
// Число: 4
// Число: 5
```

### map и flatMap

```kotlin
val numbers = listOf(1, 2, 3)

// map преобразует каждый элемент
val doubled = numbers.map { it * 2 }
println(doubled) // Выведет: [2, 4, 6]

// flatMap преобразует каждый элемент в коллекцию и объединяет результаты
val flatMapped = numbers.flatMap { listOf(it, it * 10) }
println(flatMapped) // Выведет: [1, 10, 2, 20, 3, 30]
```

### filter и filterNot

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// filter оставляет элементы, удовлетворяющие условию
val evenNumbers = numbers.filter { it % 2 == 0 }
println(evenNumbers) // Выведет: [2, 4, 6, 8, 10]

// filterNot оставляет элементы, не удовлетворяющие условию
val oddNumbers = numbers.filterNot { it % 2 == 0 }
println(oddNumbers) // Выведет: [1, 3, 5, 7, 9]
```

### reduce и fold

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

// reduce применяет операцию к элементам последовательно
val sum = numbers.reduce { acc, number -> acc + number }
println(sum) // Выведет: 15 (1 + 2 + 3 + 4 + 5)

// fold похож на reduce, но принимает начальное значение
val sumWithInitial = numbers.fold(10) { acc, number -> acc + number }
println(sumWithInitial) // Выведет: 25 (10 + 1 + 2 + 3 + 4 + 5)
```

## Практические примеры

### Пример 1: Фильтрация и преобразование данных

```kotlin
data class Product(val name: String, val price: Double, val category: String)

val products = listOf(
    Product("Ноутбук", 1200.0, "Электроника"),
    Product("Смартфон", 800.0, "Электроника"),
    Product("Футболка", 25.0, "Одежда"),
    Product("Джинсы", 60.0, "Одежда"),
    Product("Книга", 15.0, "Книги")
)

// Фильтрация товаров по категории
val electronics = products.filter { it.category == "Электроника" }
println("Электроника: $electronics")

// Получение названий всех товаров
val productNames = products.map { it.name }
println("Названия товаров: $productNames")

// Фильтрация и преобразование
val expensiveProductNames = products
    .filter { it.price > 100.0 }
    .map { it.name }
println("Дорогие товары: $expensiveProductNames")

// Группировка товаров по категории
val groupedByCategory = products.groupBy { it.category }
println("Товары по категориям: $groupedByCategory")

// Вычисление средней цены товаров в каждой категории
val averagePriceByCategory = products
    .groupBy { it.category }
    .mapValues { (_, products) -> products.map { it.price }.average() }
println("Средняя цена по категориям: $averagePriceByCategory")
```

### Пример 2: Обработка текста

```kotlin
val text = """
    Kotlin - современный язык программирования,
    который делает разработчиков счастливее.
    Kotlin лаконичен, безопасен, совместим с Java
    и поддерживает множество стилей программирования.
""".trimIndent()

// Разделение текста на слова
val words = text.split(Regex("\\s+"))
println("Количество слов: ${words.size}")

// Подсчет частоты слов (игнорируя регистр и знаки препинания)
val wordFrequency = words
    .map { it.lowercase().replace(Regex("[^а-яa-z]"), "") }
    .filter { it.isNotEmpty() }
    .groupingBy { it }
    .eachCount()
    .toList()
    .sortedByDescending { (_, count) -> count }
    .toMap()

println("Частота слов:")
wordFrequency.forEach { (word, count) ->
    println("$word: $count")
}

// Поиск самого длинного слова
val longestWord = words
    .map { it.replace(Regex("[^а-яa-zА-ЯA-Z]"), "") }
    .maxByOrNull { it.length }
println("Самое длинное слово: $longestWord")
```

### Пример 3: Работа с числами

```kotlin
// Генерация случайных чисел
val random = java.util.Random()
val randomNumbers = List(10) { random.nextInt(100) }
println("Случайные числа: $randomNumbers")

// Статистика
val stats = mapOf(
    "Минимум" to randomNumbers.minOrNull(),
    "Максимум" to randomNumbers.maxOrNull(),
    "Среднее" to randomNumbers.average(),
    "Сумма" to randomNumbers.sum(),
    "Количество четных" to randomNumbers.count { it % 2 == 0 },
    "Количество нечетных" to randomNumbers.count { it % 2 != 0 }
)

println("Статистика:")
stats.forEach { (key, value) ->
    println("$key: $value")
}

// Проверка, все ли числа положительные
val allPositive = randomNumbers.all { it > 0 }
println("Все числа положительные: $allPositive")

// Проверка, есть ли числа больше 50
val anyLarge = randomNumbers.any { it > 50 }
println("Есть числа больше 50: $anyLarge")
```

## Заключение

В этом уроке мы рассмотрели лямбда-выражения в Kotlin и их применение в различных контекстах.

Ключевые особенности лямбда-выражений в Kotlin:
- Лямбда-выражения — это анонимные функции, которые можно передавать как значения
- Синтаксис лямбда-выражений: `{ параметры -> тело }`
- Для лямбда-выражений с одним параметром можно использовать ключевое слово `it`
- Лямбда-выражения могут захватывать переменные из внешнего контекста (замыкания)
- Функции высшего порядка принимают или возвращают другие функции
- Ссылки на функции (`::имяФункции`) позволяют использовать существующие функции как лямбда-выражения
- Kotlin предоставляет множество встроенных функций для работы с коллекциями, которые принимают лямбда-выражения

Лямбда-выражения являются мощным инструментом в Kotlin, позволяющим писать более краткий, выразительный и функциональный код. Понимание и эффективное использование лямбда-выражений является важной частью программирования на Kotlin. 