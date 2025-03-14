/**
 * Задания по теме "Операторы в Kotlin"
 */

/**
 * Задача 1: Арифметические операторы
 * 
 * Создайте метод, который принимает два целых числа и возвращает результат
 * всех арифметических операций над ними в виде Map, где ключ - название операции,
 * а значение - результат операции.
 * Операции: сложение, вычитание, умножение, деление, остаток от деления.
 */
class Solution1 {
    fun performArithmeticOperations(a: Int, b: Int): Map<String, Number> {
        // your solution
    }
}

/**
 * Задача 2: Операторы сравнения
 * 
 * Создайте метод, который принимает два числа и возвращает результат
 * всех операций сравнения между ними в виде Map, где ключ - название операции,
 * а значение - результат операции (true/false).
 * Операции: равно, не равно, больше, меньше, больше или равно, меньше или равно.
 */
class Solution2 {
    fun compareNumbers(a: Int, b: Int): Map<String, Boolean> {
        // your solution
    }
}

/**
 * Задача 3: Инкремент и декремент
 * 
 * Создайте метод, который демонстрирует разницу между префиксным и постфиксным
 * инкрементом/декрементом. Метод должен вернуть Map с результатами операций.
 */
class Solution3 {
    fun demonstrateIncrementDecrement(): Map<String, Int> {
        // your solution
    }
}

/**
 * Задача 4: Составные операторы присваивания
 * 
 * Создайте метод, который демонстрирует работу составных операторов присваивания.
 * Метод должен принимать начальное значение и возвращать Map с результатами
 * применения различных составных операторов.
 */
class Solution4 {
    fun demonstrateCompoundAssignment(initial: Int): Map<String, Int> {
        // your solution
    }
}

/**
 * Задача 5: Логические операторы
 * 
 * Создайте метод, который принимает два булевых значения и возвращает результат
 * всех логических операций над ними в виде Map.
 * Операции: И (&&), ИЛИ (||), НЕ (!) для каждого значения.
 */
class Solution5 {
    fun performLogicalOperations(a: Boolean, b: Boolean): Map<String, Boolean> {
        // your solution
    }
}

/**
 * Задача 6: Побитовые операции
 * 
 * Создайте метод, который принимает два целых числа и возвращает результат
 * всех побитовых операций над ними в виде Map.
 * Операции: И (and), ИЛИ (or), исключающее ИЛИ (xor), инверсия (inv),
 * сдвиг влево (shl), сдвиг вправо (shr).
 */
class Solution6 {
    fun performBitwiseOperations(a: Int, b: Int): Map<String, Int> {
        // your solution
    }
}

/**
 * Задача 7: Операторы диапазона
 * 
 * Создайте метод, который демонстрирует работу операторов диапазона.
 * Метод должен проверить, входит ли заданное число в различные диапазоны,
 * и вернуть результаты проверок в виде Map.
 */
class Solution7 {
    fun checkRanges(number: Int): Map<String, Boolean> {
        // your solution
    }
}

/**
 * Задача 8: Оператор Elvis (?:)
 * 
 * Создайте метод, который демонстрирует работу оператора Elvis.
 * Метод должен принимать nullable строку и возвращать:
 * - саму строку, если она не null
 * - строку "Значение не указано", если входная строка null
 */
class Solution8 {
    fun useElvisOperator(input: String?): String {
        // your solution
    }
}

/**
 * Задача 9: Сравнение строк
 * 
 * Создайте метод, который демонстрирует разницу между операторами == и === при сравнении строк.
 * Метод должен вернуть Map с результатами различных сравнений.
 */
class Solution9 {
    fun compareStrings(): Map<String, Boolean> {
        // your solution
    }
}

/**
 * Задача 10: Комплексная задача с операторами
 * 
 * Создайте метод, который вычисляет индекс массы тела (ИМТ) человека
 * и определяет категорию веса. Метод должен принимать вес (в кг) и рост (в метрах)
 * и возвращать Map с результатами:
 * - ИМТ (вес / (рост * рост))
 * - Категория веса:
 *   - "Недостаточный вес" если ИМТ < 18.5
 *   - "Нормальный вес" если ИМТ >= 18.5 и ИМТ < 25
 *   - "Избыточный вес" если ИМТ >= 25 и ИМТ < 30
 *   - "Ожирение" если ИМТ >= 30
 */
class Solution10 {
    fun calculateBMI(weight: Double, height: Double): Map<String, Any> {
        // your solution
    }
} 