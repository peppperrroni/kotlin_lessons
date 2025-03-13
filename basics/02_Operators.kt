/**
 * Урок 2: Операторы в Kotlin
 * 
 * В этом уроке мы рассмотрим различные операторы, доступные в Kotlin.
 */

fun main() {
    println("Урок 2: Операторы в Kotlin")
    println("===========================")
    
    // ======== Арифметические операторы ========
    
    println("\n=== Арифметические операторы ===")
    
    val a = 10
    val b = 3
    
    println("a = $a, b = $b")
    println("a + b = ${a + b}")  // Сложение
    println("a - b = ${a - b}")  // Вычитание
    println("a * b = ${a * b}")  // Умножение
    println("a / b = ${a / b}")  // Целочисленное деление (результат: 3)
    println("a % b = ${a % b}")  // Остаток от деления (результат: 1)
    
    // Деление с плавающей точкой
    println("a / b (с плавающей точкой) = ${a.toDouble() / b}")
    
    // Инкремент и декремент
    var c = 5
    println("\nc = $c")
    
    c++  // Постфиксный инкремент
    println("После c++: $c")
    
    ++c  // Префиксный инкремент
    println("После ++c: $c")
    
    c--  // Постфиксный декремент
    println("После c--: $c")
    
    --c  // Префиксный декремент
    println("После --c: $c")
    
    // Разница между префиксным и постфиксным инкрементом/декрементом
    c = 5
    val d1 = c++  // Сначала d1 = c, затем c = c + 1
    println("\nc = $c, d1 = $d1")
    
    c = 5
    val d2 = ++c  // Сначала c = c + 1, затем d2 = c
    println("c = $c, d2 = $d2")
    
    // ======== Операторы присваивания ========
    
    println("\n=== Операторы присваивания ===")
    
    var x = 10
    println("Начальное значение x = $x")
    
    x += 5  // Эквивалентно x = x + 5
    println("После x += 5: $x")
    
    x -= 3  // Эквивалентно x = x - 3
    println("После x -= 3: $x")
    
    x *= 2  // Эквивалентно x = x * 2
    println("После x *= 2: $x")
    
    x /= 4  // Эквивалентно x = x / 4
    println("После x /= 4: $x")
    
    x %= 3  // Эквивалентно x = x % 3
    println("После x %= 3: $x")
    
    // ======== Операторы сравнения ========
    
    println("\n=== Операторы сравнения ===")
    
    val num1 = 10
    val num2 = 20
    
    println("num1 = $num1, num2 = $num2")
    println("num1 == num2: ${num1 == num2}")  // Равно
    println("num1 != num2: ${num1 != num2}")  // Не равно
    println("num1 < num2: ${num1 < num2}")    // Меньше
    println("num1 > num2: ${num1 > num2}")    // Больше
    println("num1 <= num2: ${num1 <= num2}")  // Меньше или равно
    println("num1 >= num2: ${num1 >= num2}")  // Больше или равно
    
    // Сравнение строк
    val str1 = "Привет"
    val str2 = "привет"
    val str3 = "Привет"
    
    println("\nСравнение строк:")
    println("str1 = \"$str1\", str2 = \"$str2\", str3 = \"$str3\"")
    println("str1 == str2: ${str1 == str2}")  // Сравнение содержимого
    println("str1 == str3: ${str1 == str3}")
    
    // Сравнение ссылок
    println("str1 === str3: ${str1 === str3}")  // Сравнение ссылок
    
    // ======== Логические операторы ========
    
    println("\n=== Логические операторы ===")
    
    val isTrue = true
    val isFalse = false
    
    println("isTrue = $isTrue, isFalse = $isFalse")
    println("isTrue && isFalse: ${isTrue && isFalse}")  // Логическое И
    println("isTrue || isFalse: ${isTrue || isFalse}")  // Логическое ИЛИ
    println("!isTrue: ${!isTrue}")                      // Логическое НЕ
    
    // Короткое замыкание (short-circuit evaluation)
    println("\nКороткое замыкание:")
    
    var result = false
    
    // Второе выражение не вычисляется, если первое false (для &&)
    if (isFalse && isTrue) {
        result = true
    }
    println("isFalse && isTrue: $result")
    
    // Второе выражение не вычисляется, если первое true (для ||)
    if (isTrue || isFalse) {
        result = true
    }
    println("isTrue || isFalse: $result")
    
    // ======== Побитовые операторы ========
    
    println("\n=== Побитовые операторы ===")
    
    val bit1 = 0b1010  // 10 в двоичной системе
    val bit2 = 0b1100  // 12 в двоичной системе
    
    println("bit1 = ${bit1.toString(2).padStart(4, '0')} (${bit1})")
    println("bit2 = ${bit2.toString(2).padStart(4, '0')} (${bit2})")
    
    // Побитовое И
    val andResult = bit1 and bit2
    println("bit1 and bit2 = ${andResult.toString(2).padStart(4, '0')} (${andResult})")
    
    // Побитовое ИЛИ
    val orResult = bit1 or bit2
    println("bit1 or bit2 = ${orResult.toString(2).padStart(4, '0')} (${orResult})")
    
    // Побитовое исключающее ИЛИ (XOR)
    val xorResult = bit1 xor bit2
    println("bit1 xor bit2 = ${xorResult.toString(2).padStart(4, '0')} (${xorResult})")
    
    // Побитовое НЕ (инверсия)
    val notResult = bit1.inv()
    println("bit1.inv() = ${notResult.toString(2)} (${notResult})")
    
    // Сдвиг влево
    val leftShift = bit1 shl 1
    println("bit1 shl 1 = ${leftShift.toString(2).padStart(5, '0')} (${leftShift})")
    
    // Сдвиг вправо
    val rightShift = bit1 shr 1
    println("bit1 shr 1 = ${rightShift.toString(2).padStart(3, '0')} (${rightShift})")
    
    // Беззнаковый сдвиг вправо
    val unsignedRightShift = bit1 ushr 1
    println("bit1 ushr 1 = ${unsignedRightShift.toString(2).padStart(3, '0')} (${unsignedRightShift})")
    
    // ======== Операторы диапазона ========
    
    println("\n=== Операторы диапазона ===")
    
    // Оператор .. создает включающий диапазон
    val inclusiveRange = 1..5  // Диапазон от 1 до 5 включительно
    println("1..5: $inclusiveRange")
    println("3 in 1..5: ${3 in inclusiveRange}")
    println("6 in 1..5: ${6 in inclusiveRange}")
    
    // Оператор until создает исключающий диапазон
    val exclusiveRange = 1 until 5  // Диапазон от 1 до 4 (5 не включается)
    println("\n1 until 5: $exclusiveRange")
    println("3 in 1 until 5: ${3 in exclusiveRange}")
    println("5 in 1 until 5: ${5 in exclusiveRange}")
    
    // Оператор downTo создает убывающий диапазон
    val descendingRange = 5 downTo 1  // Диапазон от 5 до 1
    println("\n5 downTo 1: $descendingRange")
    println("3 in 5 downTo 1: ${3 in descendingRange}")
    
    // Оператор step задает шаг
    val stepRange = 1..10 step 2  // Диапазон от 1 до 10 с шагом 2
    println("\n1..10 step 2: $stepRange")
    println("Элементы: ${stepRange.joinToString()}")
    
    // ======== Оператор Elvis (?:) ========
    
    println("\n=== Оператор Elvis (?:) ===")
    
    val nullableValue: String? = null
    val nonNullValue = "Не null"
    
    // Если левая часть null, возвращается правая часть
    val result1 = nullableValue ?: "Значение по умолчанию"
    val result2 = nonNullValue ?: "Значение по умолчанию"
    
    println("nullableValue ?: \"Значение по умолчанию\" = $result1")
    println("nonNullValue ?: \"Значение по умолчанию\" = $result2")
    
    // ======== Перегрузка операторов ========
    
    println("\n=== Перегрузка операторов ===")
    
    val point1 = Point(3, 4)
    val point2 = Point(1, 2)
    
    println("point1 = $point1")
    println("point2 = $point2")
    
    // Использование перегруженного оператора +
    val point3 = point1 + point2
    println("point1 + point2 = $point3")
    
    // Использование перегруженного оператора -
    val point4 = point1 - point2
    println("point1 - point2 = $point4")
    
    // Использование перегруженного оператора *
    val point5 = point1 * 2
    println("point1 * 2 = $point5")
    
    // Использование перегруженного оператора ==
    println("point1 == Point(3, 4): ${point1 == Point(3, 4)}")
    println("point1 == point2: ${point1 == point2}")
}

// Класс для демонстрации перегрузки операторов
data class Point(val x: Int, val y: Int) {
    // Перегрузка оператора +
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
    
    // Перегрузка оператора -
    operator fun minus(other: Point): Point {
        return Point(x - other.x, y - other.y)
    }
    
    // Перегрузка оператора *
    operator fun times(factor: Int): Point {
        return Point(x * factor, y * factor)
    }
    
    // Метод toString() автоматически реализуется в data классах
    // Метод equals() также автоматически реализуется в data классах
} 