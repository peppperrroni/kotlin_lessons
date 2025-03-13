/**
 * Урок 1: Переменные и типы данных в Kotlin
 * 
 * В этом уроке мы рассмотрим основные типы данных в Kotlin и способы объявления переменных.
 */

fun main() {
    println("Урок 1: Переменные и типы данных в Kotlin")
    println("==========================================")
    
    // ======== Объявление переменных ========
    
    // В Kotlin есть два основных способа объявления переменных:
    // 1. val - неизменяемая переменная (аналог final в Java)
    // 2. var - изменяемая переменная
    
    val immutable = "Это неизменяемая переменная" // Нельзя изменить после инициализации
    var mutable = "Это изменяемая переменная"     // Можно изменить после инициализации
    
    // Попытка изменить val вызовет ошибку компиляции:
    // immutable = "Новое значение" // Ошибка!
    
    // Изменение var допустимо:
    mutable = "Новое значение"
    println("Изменяемая переменная: $mutable")
    
    // ======== Явное указание типа ========
    
    // Тип можно указать явно:
    val explicitString: String = "Строка с явно указанным типом"
    var explicitInt: Int = 42
    
    // Или позволить компилятору определить тип автоматически (вывод типа):
    val inferredString = "Строка с автоматически определенным типом"
    var inferredInt = 42
    
    println("\n=== Основные типы данных ===")
    
    // ======== Числовые типы ========
    
    // Целочисленные типы
    val byte: Byte = 127                // 8 бит, диапазон: -128 до 127
    val short: Short = 32767            // 16 бит, диапазон: -32768 до 32767
    val int: Int = 2147483647           // 32 бита, диапазон: -2^31 до 2^31-1
    val long: Long = 9223372036854775807L // 64 бита, диапазон: -2^63 до 2^63-1
    
    // Числа с плавающей точкой
    val float: Float = 3.14f            // 32 бита, 6-7 значащих цифр
    val double: Double = 3.14159265359  // 64 бита, 15-16 значащих цифр
    
    println("Byte: $byte")
    println("Short: $short")
    println("Int: $int")
    println("Long: $long")
    println("Float: $float")
    println("Double: $double")
    
    // ======== Символьный и строковый типы ========
    
    val char: Char = 'A'                // 16 бит, символ Unicode
    val string: String = "Привет, мир!" // Строка (последовательность символов)
    
    println("\nChar: $char")
    println("String: $string")
    
    // Многострочные строки
    val multilineString = """
        Это многострочная строка.
        Она может содержать несколько строк.
        Переносы строк сохраняются.
    """.trimIndent()
    
    println("\nМногострочная строка:")
    println(multilineString)
    
    // Шаблоны строк (интерполяция)
    val name = "Kotlin"
    val greeting = "Привет, $name!"
    val calculation = "2 + 2 = ${2 + 2}"
    
    println("\nШаблоны строк:")
    println(greeting)
    println(calculation)
    
    // ======== Логический тип ========
    
    val boolean: Boolean = true         // true или false
    println("\nBoolean: $boolean")
    
    // ======== Массивы ========
    
    // Создание массива
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    val stringArray = arrayOf("Яблоко", "Банан", "Вишня")
    
    println("\n=== Массивы ===")
    println("Элементы intArray: ${intArray.joinToString()}")
    println("Элементы stringArray: ${stringArray.joinToString()}")
    println("Длина массива: ${intArray.size}")
    println("Первый элемент: ${intArray[0]}")
    
    // ======== Nullable типы ========
    
    // В Kotlin все типы по умолчанию не могут содержать null
    // var nonNullable: String = null // Ошибка компиляции!
    
    // Чтобы разрешить null, нужно добавить ? к типу
    var nullable: String? = null
    println("\n=== Nullable типы ===")
    println("Nullable переменная: $nullable")
    
    // Безопасный вызов с оператором ?. (вернет null, если переменная равна null)
    println("Длина nullable строки: ${nullable?.length}")
    
    // Оператор элвис ?: (возвращает значение справа, если слева null)
    val length = nullable?.length ?: 0
    println("Длина с оператором элвис: $length")
    
    // Оператор !! (выбрасывает NullPointerException, если значение null)
    // println(nullable!!.length) // Вызовет NullPointerException
    
    // ======== Преобразование типов ========
    
    println("\n=== Преобразование типов ===")
    val intValue = 42
    
    // В Kotlin нет неявного преобразования типов
    // val longValue: Long = intValue // Ошибка компиляции!
    
    // Нужно использовать явное преобразование
    val longValue: Long = intValue.toLong()
    val doubleValue: Double = intValue.toDouble()
    val stringValue: String = intValue.toString()
    
    println("Int -> Long: $longValue")
    println("Int -> Double: $doubleValue")
    println("Int -> String: $stringValue")
    
    // Преобразование строки в число
    val parsedInt = "42".toInt()
    val parsedDouble = "3.14".toDouble()
    
    println("String -> Int: $parsedInt")
    println("String -> Double: $parsedDouble")
    
    // ======== Константы ========
    
    // Константы объявляются на уровне файла с помощью const val
    println("\n=== Константы ===")
    println("PI: $PI")
    println("APP_VERSION: $APP_VERSION")
}

// Константы должны быть примитивными типами или String
const val PI = 3.14159
const val APP_VERSION = "1.0.0" 