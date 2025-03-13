# Урок 5: Функции в Kotlin

## Введение

Функции являются одним из основных строительных блоков в программировании, позволяя структурировать код, избегать повторений и создавать переиспользуемые компоненты. Kotlin предлагает мощную и гибкую систему функций с множеством возможностей, которые делают код более читаемым, выразительным и безопасным.

В этом уроке мы рассмотрим различные аспекты функций в Kotlin, включая объявление и вызов функций, параметры, возвращаемые значения, функции высшего порядка и многое другое.

## Объявление и вызов функций

### Базовый синтаксис

В Kotlin функция объявляется с использованием ключевого слова `fun`:

```kotlin
fun greet() {
    println("Привет, мир!")
}

// Вызов функции
greet() // Выведет: "Привет, мир!"
```

### Функции с параметрами

Функции могут принимать параметры, которые указываются в скобках после имени функции:

```kotlin
fun greetPerson(name: String) {
    println("Привет, $name!")
}

// Вызов функции с параметром
greetPerson("Алексей") // Выведет: "Привет, Алексей!"
```

### Функции с несколькими параметрами

```kotlin
fun add(a: Int, b: Int) {
    println("$a + $b = ${a + b}")
}

// Вызов функции с несколькими параметрами
add(5, 3) // Выведет: "5 + 3 = 8"
```

## Параметры функций

### Параметры по умолчанию

Kotlin позволяет задавать значения по умолчанию для параметров, что делает их необязательными при вызове функции:

```kotlin
fun greetWithDefault(name: String = "Гость") {
    println("Привет, $name!")
}

// Вызов с явным параметром
greetWithDefault("Мария") // Выведет: "Привет, Мария!"

// Вызов без параметра (используется значение по умолчанию)
greetWithDefault() // Выведет: "Привет, Гость!"
```

### Именованные аргументы

Kotlin позволяет указывать имена аргументов при вызове функции, что делает код более читаемым и позволяет передавать аргументы в любом порядке:

```kotlin
fun createUser(name: String, age: Int, isAdmin: Boolean = false) {
    println("Создан пользователь: $name, возраст: $age, администратор: $isAdmin")
}

// Вызов с позиционными аргументами
createUser("Иван", 30) // Выведет: "Создан пользователь: Иван, возраст: 30, администратор: false"

// Вызов с именованными аргументами
createUser(age = 25, name = "Анна", isAdmin = true) // Выведет: "Создан пользователь: Анна, возраст: 25, администратор: true"

// Смешанный вызов (позиционные и именованные аргументы)
createUser("Петр", isAdmin = true, age = 40) // Выведет: "Создан пользователь: Петр, возраст: 40, администратор: true"
```

### Переменное количество аргументов (varargs)

Kotlin позволяет функциям принимать переменное количество аргументов с помощью ключевого слова `vararg`:

```kotlin
fun printAll(vararg messages: String) {
    for (message in messages) {
        println(message)
    }
}

// Вызов с разным количеством аргументов
printAll("Привет") // Выведет: "Привет"
printAll("Один", "Два", "Три") // Выведет: "Один", "Два", "Три"

// Передача массива с помощью оператора *
val array = arrayOf("Яблоко", "Банан", "Вишня")
printAll(*array) // Выведет: "Яблоко", "Банан", "Вишня"
```

## Возвращаемые значения

### Функции с возвращаемым значением

Функции в Kotlin могут возвращать значения, тип которых указывается после списка параметров:

```kotlin
fun sum(a: Int, b: Int): Int {
    return a + b
}

val result = sum(5, 3)
println("Сумма: $result") // Выведет: "Сумма: 8"
```

### Функции-выражения

Если функция состоит из одного выражения, ее можно записать в сокращенной форме:

```kotlin
fun multiply(a: Int, b: Int): Int = a * b

val product = multiply(4, 5)
println("Произведение: $product") // Выведет: "Произведение: 20"
```

В таких функциях тип возвращаемого значения может быть опущен, если компилятор может вывести его автоматически:

```kotlin
fun divide(a: Double, b: Double) = a / b

val quotient = divide(10.0, 2.0)
println("Частное: $quotient") // Выведет: "Частное: 5.0"
```

### Функции без возвращаемого значения

Если функция не возвращает значение, можно указать тип возвращаемого значения `Unit` (аналог `void` в других языках) или опустить его:

```kotlin
fun printMessage(message: String): Unit {
    println(message)
}

// Эквивалентная запись
fun printMessage2(message: String) {
    println(message)
}
```

## Локальные функции

Kotlin позволяет объявлять функции внутри других функций, что полезно для инкапсуляции логики, которая используется только в контексте внешней функции:

```kotlin
fun processUser(userId: String) {
    // Локальная функция
    fun validateUserId(id: String): Boolean {
        return id.length >= 4 && id.all { it.isLetterOrDigit() }
    }
    
    if (!validateUserId(userId)) {
        println("Некорректный ID пользователя")
        return
    }
    
    // Продолжение обработки пользователя
    println("Обработка пользователя с ID: $userId")
}

processUser("abc") // Выведет: "Некорректный ID пользователя"
processUser("user123") // Выведет: "Обработка пользователя с ID: user123"
```

## Функции-расширения

Функции-расширения позволяют добавлять новые функции к существующим классам без наследования или модификации исходного класса:

```kotlin
// Добавление функции-расширения к типу String
fun String.addExclamation(): String {
    return "$this!"
}

val message = "Привет"
println(message.addExclamation()) // Выведет: "Привет!"

// Функция-расширение с параметрами
fun String.repeat(times: Int): String {
    val result = StringBuilder()
    for (i in 1..times) {
        result.append(this)
    }
    return result.toString()
}

println("Ха".repeat(3)) // Выведет: "ХаХаХа"
```

## Инфиксные функции

Инфиксные функции позволяют использовать более естественный синтаксис для вызова функций с одним параметром:

```kotlin
// Объявление инфиксной функции
infix fun Int.times(str: String): String {
    val result = StringBuilder()
    for (i in 1..this) {
        result.append(str)
    }
    return result.toString()
}

// Использование инфиксного синтаксиса
val repeated = 3 times "Ха" // Эквивалентно 3.times("Ха")
println(repeated) // Выведет: "ХаХаХа"

// Еще один пример инфиксной функции
infix fun String.onto(other: String) = "$this на $other"

val position = "Книга" onto "столе"
println(position) // Выведет: "Книга на столе"
```

## Функции высшего порядка

Функции высшего порядка — это функции, которые принимают другие функции в качестве параметров или возвращают функции:

```kotlin
// Функция, принимающая другую функцию в качестве параметра
fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// Использование лямбда-выражений при вызове
val sumResult = operateOnNumbers(5, 3) { x, y -> x + y }
println("Сумма: $sumResult") // Выведет: "Сумма: 8"

val productResult = operateOnNumbers(5, 3) { x, y -> x * y }
println("Произведение: $productResult") // Выведет: "Произведение: 15"

// Передача ссылки на функцию
fun subtract(x: Int, y: Int) = x - y
val differenceResult = operateOnNumbers(5, 3, ::subtract)
println("Разность: $differenceResult") // Выведет: "Разность: 2"
```

### Возвращение функций

```kotlin
// Функция, возвращающая другую функцию
fun getOperation(operationType: String): (Int, Int) -> Int {
    return when (operationType) {
        "add" -> { a, b -> a + b }
        "subtract" -> { a, b -> a - b }
        "multiply" -> { a, b -> a * b }
        "divide" -> { a, b -> a / b }
        else -> { _, _ -> 0 }
    }
}

// Использование возвращаемой функции
val addOperation = getOperation("add")
println("5 + 3 = ${addOperation(5, 3)}") // Выведет: "5 + 3 = 8"

val multiplyOperation = getOperation("multiply")
println("5 * 3 = ${multiplyOperation(5, 3)}") // Выведет: "5 * 3 = 15"
```

## Встроенные функции

Kotlin предоставляет множество встроенных функций, которые упрощают работу с коллекциями и другими типами данных:

```kotlin
// Работа с коллекциями
val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// Фильтрация
val evenNumbers = numbers.filter { it % 2 == 0 }
println("Четные числа: $evenNumbers") // Выведет: "Четные числа: [2, 4, 6, 8, 10]"

// Преобразование
val squaredNumbers = numbers.map { it * it }
println("Квадраты чисел: $squaredNumbers") // Выведет: "Квадраты чисел: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]"

// Агрегация
val sum = numbers.sum()
println("Сумма: $sum") // Выведет: "Сумма: 55"

val product = numbers.reduce { acc, i -> acc * i }
println("Произведение: $product") // Выведет: "Произведение: 3628800"

// Комбинирование операций
val sumOfEvenSquares = numbers
    .filter { it % 2 == 0 }
    .map { it * it }
    .sum()
println("Сумма квадратов четных чисел: $sumOfEvenSquares") // Выведет: "Сумма квадратов четных чисел: 220"
```

## Практические примеры

### Пример 1: Калькулятор

```kotlin
// Функция-калькулятор, использующая функции высшего порядка
fun calculator(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// Определение операций
val add: (Int, Int) -> Int = { x, y -> x + y }
val subtract: (Int, Int) -> Int = { x, y -> x - y }
val multiply: (Int, Int) -> Int = { x, y -> x * y }
val divide: (Int, Int) -> Int = { x, y -> if (y != 0) x / y else 0 }

// Использование калькулятора
println("5 + 3 = ${calculator(5, 3, add)}") // Выведет: "5 + 3 = 8"
println("5 - 3 = ${calculator(5, 3, subtract)}") // Выведет: "5 - 3 = 2"
println("5 * 3 = ${calculator(5, 3, multiply)}") // Выведет: "5 * 3 = 15"
println("6 / 3 = ${calculator(6, 3, divide)}") // Выведет: "6 / 3 = 2"
println("5 / 0 = ${calculator(5, 0, divide)}") // Выведет: "5 / 0 = 0"
```

### Пример 2: Обработка строк

```kotlin
// Функция для трансформации списка строк
fun transformWords(words: List<String>, transform: (String) -> String): List<String> {
    return words.map(transform)
}

val words = listOf("apple", "banana", "cherry", "date")

// Преобразование к верхнему регистру
val upperCaseWords = transformWords(words) { it.uppercase() }
println("Верхний регистр: $upperCaseWords") // Выведет: "Верхний регистр: [APPLE, BANANA, CHERRY, DATE]"

// Получение первых букв
val firstLetters = transformWords(words) { it.first().toString() }
println("Первые буквы: $firstLetters") // Выведет: "Первые буквы: [a, b, c, d]"

// Добавление префикса
val prefixedWords = transformWords(words) { "fruit_$it" }
println("С префиксом: $prefixedWords") // Выведет: "С префиксом: [fruit_apple, fruit_banana, fruit_cherry, fruit_date]"
```

### Пример 3: Хвостовая рекурсия

Kotlin поддерживает оптимизацию хвостовой рекурсии с помощью модификатора `tailrec`, что позволяет избежать переполнения стека при рекурсивных вызовах:

```kotlin
// Вычисление факториала с использованием хвостовой рекурсии
tailrec fun factorial(n: Int, accumulator: Long = 1): Long {
    return when {
        n <= 1 -> accumulator
        else -> factorial(n - 1, accumulator * n)
    }
}

println("Факториал 5: ${factorial(5)}") // Выведет: "Факториал 5: 120"
println("Факториал 10: ${factorial(10)}") // Выведет: "Факториал 10: 3628800"

// Вычисление чисел Фибоначчи с использованием хвостовой рекурсии
tailrec fun fibonacci(n: Int, a: Long = 0, b: Long = 1): Long {
    return when (n) {
        0 -> a
        1 -> b
        else -> fibonacci(n - 1, b, a + b)
    }
}

println("Число Фибоначчи #10: ${fibonacci(10)}") // Выведет: "Число Фибоначчи #10: 55"
println("Число Фибоначчи #20: ${fibonacci(20)}") // Выведет: "Число Фибоначчи #20: 6765"
```

## Заключение

В этом уроке мы рассмотрели различные аспекты функций в Kotlin, включая объявление и вызов функций, параметры, возвращаемые значения, функции высшего порядка и многое другое.

Ключевые особенности функций в Kotlin:
- Функции объявляются с использованием ключевого слова `fun`
- Параметры могут иметь значения по умолчанию
- Поддержка именованных аргументов при вызове функций
- Возможность использования переменного количества аргументов (varargs)
- Функции могут быть выражениями
- Локальные функции для инкапсуляции логики
- Функции-расширения для добавления функциональности к существующим классам
- Инфиксные функции для более естественного синтаксиса
- Функции высшего порядка, принимающие или возвращающие другие функции
- Оптимизация хвостовой рекурсии

Функции являются мощным инструментом в Kotlin, позволяющим создавать чистый, выразительный и безопасный код. Понимание различных типов функций и их возможностей является важной частью эффективного программирования на Kotlin. 