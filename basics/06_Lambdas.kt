/**
 * Урок 6: Лямбда-выражения в Kotlin
 * 
 * В этом уроке мы рассмотрим лямбда-выражения и их применение в Kotlin.
 */

fun main() {
    println("Урок 6: Лямбда-выражения в Kotlin")
    println("=================================")
    
    // ======== Основы лямбда-выражений ========
    
    println("\n=== Основы лямбда-выражений ===")
    
    // Простое лямбда-выражение
    val sum = { a: Int, b: Int -> a + b }
    println("Сумма 5 и 3: ${sum(5, 3)}")
    
    // Лямбда-выражение с выводом типов
    val multiply: (Int, Int) -> Int = { a, b -> a * b }
    println("Произведение 4 и 6: ${multiply(4, 6)}")
    
    // Лямбда-выражение без параметров
    val greet: () -> String = { "Привет, мир!" }
    println(greet())
    
    // Лямбда-выражение с одним параметром
    val square: (Int) -> Int = { it * it }
    println("Квадрат числа 7: ${square(7)}")
    
    // Лямбда-выражение с несколькими выражениями
    val absoluteValue: (Int) -> Int = { 
        if (it < 0) -it else it 
    }
    println("Абсолютное значение -10: ${absoluteValue(-10)}")
    println("Абсолютное значение 10: ${absoluteValue(10)}")
    
    // ======== Использование лямбда-выражений с коллекциями ========
    
    println("\n=== Использование лямбда-выражений с коллекциями ===")
    
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Исходный список: $numbers")
    
    // filter - фильтрация элементов
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println("Четные числа: $evenNumbers")
    
    // map - преобразование элементов
    val squaredNumbers = numbers.map { it * it }
    println("Квадраты чисел: $squaredNumbers")
    
    // forEach - выполнение действия для каждого элемента
    print("Обход элементов: ")
    numbers.forEach { print("$it ") }
    println()
    
    // reduce - сворачивание коллекции в одно значение
    val sum2 = numbers.reduce { acc, i -> acc + i }
    println("Сумма всех элементов: $sum2")
    
    // fold - сворачивание с начальным значением
    val product = numbers.fold(1) { acc, i -> acc * i }
    println("Произведение всех элементов: $product")
    
    // any - проверка, удовлетворяет ли хотя бы один элемент условию
    val hasEven = numbers.any { it % 2 == 0 }
    println("Есть ли четные числа: $hasEven")
    
    // all - проверка, удовлетворяют ли все элементы условию
    val allPositive = numbers.all { it > 0 }
    println("Все числа положительные: $allPositive")
    
    // none - проверка, что ни один элемент не удовлетворяет условию
    val noNegative = numbers.none { it < 0 }
    println("Нет отрицательных чисел: $noNegative")
    
    // find - поиск первого элемента, удовлетворяющего условию
    val firstEven = numbers.find { it % 2 == 0 }
    println("Первое четное число: $firstEven")
    
    // groupBy - группировка элементов
    val grouped = numbers.groupBy { if (it % 2 == 0) "четное" else "нечетное" }
    println("Группировка чисел: $grouped")
    
    // ======== Замыкания (Closures) ========
    
    println("\n=== Замыкания (Closures) ===")
    
    // Лямбда-выражение может захватывать переменные из внешней области видимости
    var factor = 2
    val multiplier = { x: Int -> x * factor }
    
    println("Умножение на $factor: ${multiplier(10)}")
    
    factor = 3
    println("Умножение на $factor: ${multiplier(10)}")
    
    // Создание счетчика с помощью замыкания
    val counter = createCounter()
    println("Счетчик: ${counter()}")  // 1
    println("Счетчик: ${counter()}")  // 2
    println("Счетчик: ${counter()}")  // 3
    
    // ======== Функции высшего порядка с лямбдами ========
    
    println("\n=== Функции высшего порядка с лямбдами ===")
    
    // Передача лямбда-выражения в функцию
    val result1 = calculate(10, 5) { a, b -> a + b }
    println("10 + 5 = $result1")
    
    val result2 = calculate(10, 5) { a, b -> a - b }
    println("10 - 5 = $result2")
    
    val result3 = calculate(10, 5) { a, b -> a * b }
    println("10 * 5 = $result3")
    
    // Функция с лямбдой в качестве последнего параметра
    processNumbers(1, 2, 3, 4, 5) {
        println("Обработка числа: $it")
    }
    
    // ======== Возврат из лямбда-выражений ========
    
    println("\n=== Возврат из лямбда-выражений ===")
    
    // Локальный возврат с меткой
    numbers.forEach label@{
        if (it > 5) return@label  // Возврат из лямбды
        print("$it ")
    }
    println("\nПродолжение выполнения после forEach")
    
    // Неявная метка
    numbers.forEach {
        if (it > 5) return@forEach  // Возврат из лямбды
        print("$it ")
    }
    println("\nПродолжение выполнения после forEach")
    
    // Анонимная функция вместо лямбды
    numbers.forEach(fun(value) {
        if (value > 5) return  // Локальный возврат из анонимной функции
        print("$value ")
    })
    println("\nПродолжение выполнения после forEach с анонимной функцией")
    
    // ======== Ссылки на функции ========
    
    println("\n=== Ссылки на функции ===")
    
    // Ссылка на функцию-член
    val isEven: (Int) -> Boolean = Int::isEven
    println("Является ли 4 четным: ${isEven(4)}")
    
    // Ссылка на функцию верхнего уровня
    val squareRef: (Int) -> Int = ::square
    println("Квадрат числа 8: ${squareRef(8)}")
    
    // Ссылка на конструктор
    val personCreator = ::Person
    val person = personCreator("Иван", 30)
    println("Создан человек: $person")
    
    // Ссылка на метод экземпляра
    val ageNextYear = person::getAgeNextYear
    println("Возраст ${person.name} в следующем году: ${ageNextYear()}")
    
    // ======== Встроенные функции с лямбдами ========
    
    println("\n=== Встроенные функции с лямбдами ===")
    
    // Использование встроенной функции
    measureTime {
        // Имитация долгой операции
        Thread.sleep(100)
        println("Операция выполнена")
    }
    
    // ======== Практические примеры ========
    
    println("\n=== Практические примеры ===")
    
    // Пример 1: Фильтрация и преобразование данных
    val people = listOf(
        Person("Анна", 25),
        Person("Борис", 17),
        Person("Виктория", 32),
        Person("Григорий", 15),
        Person("Дарья", 28)
    )
    
    println("Список людей:")
    people.forEach { println("${it.name}, ${it.age} лет") }
    
    // Фильтрация совершеннолетних
    val adults = people.filter { it.age >= 18 }
    println("\nСовершеннолетние:")
    adults.forEach { println("${it.name}, ${it.age} лет") }
    
    // Преобразование в строки
    val names = people.map { it.name }
    println("\nИмена: $names")
    
    // Сортировка по возрасту
    val sortedByAge = people.sortedBy { it.age }
    println("\nОтсортированные по возрасту:")
    sortedByAge.forEach { println("${it.name}, ${it.age} лет") }
    
    // Группировка по совершеннолетию
    val groupedByAdult = people.groupBy { it.age >= 18 }
    println("\nГруппировка по совершеннолетию:")
    println("Совершеннолетние: ${groupedByAdult[true]?.map { it.name }}")
    println("Несовершеннолетние: ${groupedByAdult[false]?.map { it.name }}")
    
    // Пример 2: Обработка текста
    val text = "Kotlin - современный язык программирования для JVM, Android и браузера"
    
    // Разбиение на слова и подсчет
    val words = text.split(Regex("\\s+"))
    println("\nКоличество слов: ${words.size}")
    
    // Фильтрация слов по длине
    val longWords = words.filter { it.length > 6 }
    println("Длинные слова: $longWords")
    
    // Преобразование в верхний регистр
    val upperCaseWords = words.map { it.uppercase() }
    println("Слова в верхнем регистре: $upperCaseWords")
    
    // Сортировка по длине
    val sortedByLength = words.sortedByDescending { it.length }
    println("Слова, отсортированные по длине (по убыванию): $sortedByLength")
    
    // Пример 3: Работа с числами
    val randomNumbers = List(10) { (1..100).random() }
    println("\nСлучайные числа: $randomNumbers")
    
    // Статистика
    println("Минимум: ${randomNumbers.minOrNull()}")
    println("Максимум: ${randomNumbers.maxOrNull()}")
    println("Среднее: ${randomNumbers.average()}")
    println("Сумма: ${randomNumbers.sum()}")
    
    // Фильтрация и преобразование
    val processedNumbers = randomNumbers
        .filter { it % 2 == 0 }  // Только четные
        .map { it * 2 }          // Умножаем на 2
        .sorted()                // Сортируем
    
    println("Обработанные числа: $processedNumbers")
}

// ======== Вспомогательные функции и классы ========

// Функция для создания счетчика (замыкание)
fun createCounter(): () -> Int {
    var count = 0
    return { ++count }
}

// Функция высшего порядка, принимающая лямбда-выражение
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// Функция с лямбдой в качестве последнего параметра
fun processNumbers(vararg numbers: Int, processor: (Int) -> Unit) {
    for (number in numbers) {
        processor(number)
    }
}

// Встроенная функция для измерения времени
inline fun measureTime(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    println("Время выполнения: ${end - start} мс")
}

// Функция-расширение для проверки четности
fun Int.isEven(): Boolean = this % 2 == 0

// Функция для использования в ссылке на функцию
fun square(n: Int): Int = n * n

// Класс для примеров
data class Person(val name: String, val age: Int) {
    fun getAgeNextYear(): Int = age + 1
} 