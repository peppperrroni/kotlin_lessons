/**
 * Урок 5: Функции в Kotlin
 * 
 * В этом уроке мы рассмотрим различные аспекты функций в Kotlin.
 */

fun main() {
    println("Урок 5: Функции в Kotlin")
    println("========================")
    
    // ======== Объявление и вызов функций ========
    
    println("\n=== Объявление и вызов функций ===")
    
    // Вызов простой функции без параметров
    greet()
    
    // Вызов функции с параметрами
    greetPerson("Алексей")
    
    // Вызов функции с возвращаемым значением
    val sum = add(5, 3)
    println("Сумма 5 и 3 равна $sum")
    
    // Вызов функции с параметрами по умолчанию
    printInfo("Мария")  // Используется значение по умолчанию для age
    printInfo("Иван", 30)  // Указываем оба параметра
    
    // ======== Параметры функций ========
    
    println("\n=== Параметры функций ===")
    
    // Именованные аргументы
    printPersonInfo(
        name = "Елена",
        age = 25,
        city = "Москва"
    )
    
    // Именованные аргументы позволяют менять порядок
    printPersonInfo(
        city = "Санкт-Петербург",
        name = "Дмитрий",
        age = 35
    )
    
    // Смешивание позиционных и именованных аргументов
    // Позиционные аргументы должны идти перед именованными
    printPersonInfo("Ольга", city = "Казань", age = 28)
    
    // Varargs - переменное количество аргументов
    printNumbers(1, 2, 3, 4, 5)
    
    val numbersArray = intArrayOf(6, 7, 8, 9, 10)
    // Оператор * (spread operator) для передачи массива в vararg
    printNumbers(0, *numbersArray, 11)
    
    // ======== Возвращаемые значения ========
    
    println("\n=== Возвращаемые значения ===")
    
    // Функция с явным возвращаемым значением
    val product = multiply(4, 7)
    println("Произведение 4 и 7 равно $product")
    
    // Функция с выражением в качестве тела
    val squared = square(5)
    println("Квадрат числа 5 равен $squared")
    
    // Функция с Unit возвращаемым типом (аналог void)
    printMessage("Это сообщение не возвращает значение")
    
    // Функция с возвращаемым значением типа Nothing
    try {
        // failWithError("Произошла ошибка!")
        println("Этот код не будет выполнен")
    } catch (e: IllegalStateException) {
        println("Поймано исключение: ${e.message}")
    }
    
    // ======== Локальные функции ========
    
    println("\n=== Локальные функции ===")
    
    // Функция, содержащая локальную функцию
    calculateAndPrintSum(10, 20, 30)
    
    // ======== Функции-расширения ========
    
    println("\n=== Функции-расширения ===")
    
    val text = "Привет, мир!"
    println("Исходная строка: '$text'")
    println("Первая буква заглавная: '${text.firstCharToUpperCase()}'")
    println("Последняя буква заглавная: '${text.lastCharToUpperCase()}'")
    
    val numbers = listOf(1, 2, 3, 4, 5)
    println("Список: $numbers")
    println("Сумма элементов: ${numbers.sumOfElements()}")
    println("Произведение элементов: ${numbers.productOfElements()}")
    
    // ======== Инфиксные функции ========
    
    println("\n=== Инфиксные функции ===")
    
    val num1 = 10
    val num2 = 5
    
    // Вызов инфиксной функции
    println("$num1 умножить на $num2 = ${num1 multiply num2}")
    
    // Создание пары с помощью инфиксной функции to
    val pair = "ключ" to "значение"
    println("Пара: $pair")
    
    // ======== Функции высшего порядка ========
    
    println("\n=== Функции высшего порядка ===")
    
    // Передача функции в качестве аргумента
    val numbersList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    println("Список: $numbersList")
    println("Четные числа: ${filterNumbers(numbersList) { it % 2 == 0 }}")
    println("Нечетные числа: ${filterNumbers(numbersList) { it % 2 != 0 }}")
    println("Числа больше 5: ${filterNumbers(numbersList) { it > 5 }}")
    
    // Функция, возвращающая функцию
    val addFive = createAdder(5)
    println("addFive(10) = ${addFive(10)}")  // 15
    
    val multiplyByTwo = createMultiplier(2)
    println("multiplyByTwo(10) = ${multiplyByTwo(10)}")  // 20
    
    // ======== Встроенные функции ========
    
    println("\n=== Встроенные функции ===")
    
    // Использование встроенной функции
    measureExecutionTime {
        // Имитация долгой операции
        Thread.sleep(100)
        println("Операция выполнена")
    }
    
    // ======== Хвостовая рекурсия ========
    
    println("\n=== Хвостовая рекурсия ===")
    
    // Вычисление факториала с использованием хвостовой рекурсии
    val factorialResult = factorial(10)
    println("Факториал числа 10 = $factorialResult")
    
    // Вычисление чисел Фибоначчи с использованием хвостовой рекурсии
    println("Числа Фибоначчи до 100:")
    for (i in 0..10) {
        print("${fibonacci(i)} ")
    }
    println()
    
    // ======== Практические примеры ========
    
    println("\n=== Практические примеры ===")
    
    // Пример 1: Калькулятор
    val calcResult = calculator(10, 5, ::subtract)
    println("Результат вычитания: $calcResult")
    
    // Пример 2: Обработка строк
    val words = listOf("яблоко", "банан", "апельсин", "киви", "груша")
    println("Исходный список слов: $words")
    
    val transformedWords = transformWords(words) { word ->
        word.uppercase()
    }
    println("Слова в верхнем регистре: $transformedWords")
    
    val filteredWords = transformWords(words) { word ->
        if (word.length > 5) word else ""
    }.filter { it.isNotEmpty() }
    println("Слова длиннее 5 символов: $filteredWords")
}

// ======== Определения функций ========

// Простая функция без параметров и возвращаемого значения
fun greet() {
    println("Привет, мир!")
}

// Функция с параметром
fun greetPerson(name: String) {
    println("Привет, $name!")
}

// Функция с параметрами и возвращаемым значением
fun add(a: Int, b: Int): Int {
    return a + b
}

// Функция с параметрами по умолчанию
fun printInfo(name: String, age: Int = 18) {
    println("Имя: $name, Возраст: $age")
}

// Функция с несколькими параметрами
fun printPersonInfo(name: String, age: Int, city: String) {
    println("$name, $age лет, город $city")
}

// Функция с vararg (переменное количество аргументов)
fun printNumbers(vararg numbers: Int) {
    print("Числа: ")
    for (number in numbers) {
        print("$number ")
    }
    println()
}

// Функция с явным возвращаемым значением
fun multiply(a: Int, b: Int): Int {
    return a * b
}

// Функция с выражением в качестве тела
fun square(x: Int): Int = x * x

// Функция с возвращаемым типом Unit (аналог void)
fun printMessage(message: String): Unit {
    println(message)
}

// Функция с возвращаемым типом Nothing
fun failWithError(message: String): Nothing {
    throw IllegalStateException(message)
}

// Функция с локальной функцией
fun calculateAndPrintSum(vararg numbers: Int) {
    // Локальная функция
    fun sum(): Int {
        var result = 0
        for (number in numbers) {
            result += number
        }
        return result
    }
    
    // Использование локальной функции
    val total = sum()
    println("Сумма чисел ${numbers.joinToString()} равна $total")
}

// Функция-расширение для String
fun String.firstCharToUpperCase(): String {
    if (this.isEmpty()) return this
    return this.first().uppercase() + this.substring(1)
}

// Еще одна функция-расширение для String
fun String.lastCharToUpperCase(): String {
    if (this.isEmpty()) return this
    return this.substring(0, this.length - 1) + this.last().uppercase()
}

// Функция-расширение для List<Int>
fun List<Int>.sumOfElements(): Int {
    var sum = 0
    for (element in this) {
        sum += element
    }
    return sum
}

// Еще одна функция-расширение для List<Int>
fun List<Int>.productOfElements(): Int {
    if (this.isEmpty()) return 0
    var product = 1
    for (element in this) {
        product *= element
    }
    return product
}

// Инфиксная функция
infix fun Int.multiply(other: Int): Int {
    return this * other
}

// Функция высшего порядка, принимающая функцию в качестве параметра
fun filterNumbers(numbers: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    val result = mutableListOf<Int>()
    for (number in numbers) {
        if (predicate(number)) {
            result.add(number)
        }
    }
    return result
}

// Функция, возвращающая функцию
fun createAdder(x: Int): (Int) -> Int {
    return { n: Int -> n + x }
}

// Еще одна функция, возвращающая функцию
fun createMultiplier(factor: Int): (Int) -> Int {
    return { n: Int -> n * factor }
}

// Встроенная (inline) функция
inline fun measureExecutionTime(action: () -> Unit) {
    val startTime = System.currentTimeMillis()
    action()
    val endTime = System.currentTimeMillis()
    println("Время выполнения: ${endTime - startTime} мс")
}

// Функция с хвостовой рекурсией
tailrec fun factorial(n: Int, accumulator: Long = 1): Long {
    return when (n) {
        0, 1 -> accumulator
        else -> factorial(n - 1, n * accumulator)
    }
}

// Еще одна функция с хвостовой рекурсией
tailrec fun fibonacci(n: Int, a: Long = 0, b: Long = 1): Long {
    return when (n) {
        0 -> a
        1 -> b
        else -> fibonacci(n - 1, b, a + b)
    }
}

// Функция для примера с калькулятором
fun subtract(a: Int, b: Int): Int {
    return a - b
}

// Функция высшего порядка для обработки списка строк
fun transformWords(words: List<String>, transform: (String) -> String): List<String> {
    val result = mutableListOf<String>()
    for (word in words) {
        result.add(transform(word))
    }
    return result
}

// Функция для примера с калькулятором
fun calculator(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
} 